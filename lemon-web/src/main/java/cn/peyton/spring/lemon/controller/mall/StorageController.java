package cn.peyton.spring.lemon.controller.mall;

import cn.peyton.spring.basis.param.ColorParam;
import cn.peyton.spring.basis.service.ColorService;
import cn.peyton.spring.basis.service.WarehouseService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.enums.StorageStatus;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.exception.ValidationException;
import cn.peyton.spring.mall.dto.StoragePageDto;
import cn.peyton.spring.mall.entity.Inventory;
import cn.peyton.spring.mall.entity.StorageDetail;
import cn.peyton.spring.mall.param.*;
import cn.peyton.spring.mall.service.*;
import cn.peyton.spring.util.CheckedUtil;
import cn.peyton.spring.util.DateUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>出入库 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 09:24:23
 * @version 1.0.0
 * </pre>
*/
@Controller
public class StorageController {

    @Resource
    private StorageService storageService;
    @Resource
    private ColorService colorService;
    @Resource
    private CommodityService commodityService;
    @Resource
    private WarehouseService warehouseService;
    @Resource
    private InventoryService inventoryService;

    @RequestMapping("/sys/stor/storage.page")
    public ModelAndView index() {
        return new ModelAndView("mall/storage");
    }

    @RequestMapping("/sys/stor/change.page")
    public ModelAndView changeAdd(@RequestParam(name = "id",required = false,value = "") Long id ,
                                  @RequestParam(name = "commodityId",required = false,value = "") String commodityId ,
                                  HttpServletRequest request) {
        request.setAttribute("storageId",id);
        request.setAttribute("commodityId",commodityId);
        return new ModelAndView("mall/storage_add");
    }

    @PostMapping("/sys/stor/save.json")
    @ResponseBody
    public JsonData save(StorageParam param) {
        storageService.save(param);
        return JsonData.success();
    }

    @PostMapping("/sys/stor/update.json")
    @ResponseBody
    public JsonData update(StorageParam param) {
        storageService.update(param);
        return JsonData.success();
    }

    @PostMapping("/sys/stor/delete.json")
    @ResponseBody
    public JsonData delete(Long id) {
        storageService.delete(id);
        return JsonData.success();
    }

    @PostMapping("/sys/stor/obtainstoragedetail.json")
    @ResponseBody
    public JsonData obtainStorageDetail(Long storageId){
        List<StorageDetail> storageDetails = storageService.findDetailById(storageId);
        Map<Integer, ColorParam> maps = conventColorList2Map();
        List<StoragePageDto> storagePageDtos = new ArrayList<>();
        StoragePageDto dto;
        int size = storageDetails.size();
        Integer total = 0;
        for (int i = 0; i < size; i++) {
            StorageDetail storageDetail = storageDetails.get(i);
            dto = new StoragePageDto();
            Integer key = storageDetail.getColId();
            dto.setColId(key);
            dto.setQuantity(storageDetail.getStdeQuantity());
            total += storageDetail.getStdeQuantity();
            dto.setColName(maps.get(key).getName());
            storagePageDtos.add(dto);
        }
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("total", total);
        map.put("storageDetails", storagePageDtos);
        return JsonData.success(map);
    }

    @RequestMapping("/sys/stor/list.json")
    @ResponseBody
    public JsonData list(PageQuery page) {
        return JsonData.success(storageService.findByAll(page));
    }

    @RequestMapping("/sys/stor/search.json")
    @ResponseBody
    public JsonData search(PageQuery page, Integer warId, Integer direction, String comName, String beginTime, String endTime){
        warId = (null == warId) ? -1 : warId;
        direction = (null == direction) ? -1 : direction;
        if (warId < 0 && direction < 0 &&(null == comName || "".equals(comName.trim()))
                && (null == beginTime || "".equals(beginTime.trim())) && (null == endTime || "".equals(endTime.trim()))){
            throw new ValidationException("请选择参数搜索");
        }
        Date tBeginTime = DateUtil.conventStr2Date(beginTime);
        Date tEndTime = DateUtil.conventStr2Date(endTime);
        if (tBeginTime != null && tEndTime !=null){
            if (tBeginTime.getTime() > tEndTime.getTime()){
                throw new ValidationException("开始时间不能大于结束时间");
            }
        }
        warId = warId < 0 ? null:warId;
        direction = direction < 0 ? null:direction;
        return JsonData.success(storageService.findMultiCondition(page,warId,direction,comName,tBeginTime,tEndTime));
    }

    @RequestMapping("/sys/stor/obtainwarehouse.json")
    @ResponseBody
    public JsonData obtainWarehouse() {
        return JsonData.success(warehouseService.findBySelect());
    }


    @RequestMapping("/sys/stor/obtainstorage.json")
    @ResponseBody
    public JsonData obtainStorage(String commodityId,Long storageId) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        CommodityParam commodityParam = commodityService.findById(commodityId);
        //获取 库存主
        List<Inventory> inventories = inventoryService.findDisplayByComId(commodityId);
        int size = inventories.size();
        StringBuilder displayInventory = new StringBuilder();
        String warId = "-1";
        for (int i = 0; i < size; i++) {
            if(i == 0){
                warId = inventories.get(i).getWarId() + "";
            }else {
                displayInventory.append(" , ");
            }
            displayInventory.append(inventories.get(i).getInveExplain());
        }
        if (null != storageId && !"".equals(storageId)){
            StorageParam storage = storageService.findById(storageId);
            storage.setStoragePages(storagePages(commodityId, storage.getWarId(), storage.getDirection()));
            map.put("storage", storage);
        }

        map.put("warId", warId);
        map.put("displayInventory", displayInventory.toString());
        map.put("commodity", commodityParam);
        map.put("warehouseList", warehouseService.findBySelect());
        return JsonData.success(map);
    }

    @RequestMapping("/sys/stor/obtainstoragepages.json")
    @ResponseBody
    public JsonData getStoragePages(@RequestParam(name = "commodityId",required = false,defaultValue = "")String commodityId,
                                    @RequestParam(name = "warehouseId",required = false,defaultValue = "")Integer warehouseId, Integer direction) {

        return JsonData.success(storagePages(commodityId,warehouseId,direction));
    }

    /**
     * <h4></h4>
     * @param commodityId
     * @param warehouseId
     * @param direction
     * @return
     */
    private List<StoragePageDto> storagePages(String commodityId,Integer warehouseId,Integer direction){
        List<StoragePageDto> storagePageDtos = new ArrayList<>();
        if (StorageStatus.IN.getCode().equals(direction)) {
            List<ColorParam> colorParams = colorService.findBySelect();
            if (null != colorParams && colorParams.size() > 0) {
                StoragePageDto dto;
                int size = colorParams.size();
                for (int i = 0; i < size; i++) {
                    dto = new StoragePageDto();
                    dto.setColId(colorParams.get(i).getId());
                    dto.setColName(colorParams.get(i).getName());
                    dto.setInventoryQuantity(0);
                    storagePageDtos.add(dto);
                }
            }
        } else if (StorageStatus.OUT.getCode().equals(direction)) {
            InventoryParam param = inventoryService.findByComIdAndWarId(commodityId, warehouseId);
            Map<Integer,ColorParam> maps = conventColorList2Map();
            String detail = param.getDetail();
            CheckedUtil.checkNoNull(detail, "没有库存");
            String[] firstSplits = detail.split(",");
            int length = firstSplits.length;

            StoragePageDto dto;
            for (int i = 0; i < length; i++) {
                dto = new StoragePageDto();
                String[] secondSplits = firstSplits[i].split(":");
                Integer colorId = Integer.parseInt(secondSplits[0]);
                Integer inventoryQuantity = Integer.parseInt(secondSplits[1]);
                dto.setColName(maps.get(colorId).getName());
                dto.setColId(colorId);
                dto.setInventoryQuantity(inventoryQuantity);
                storagePageDtos.add(dto);
            }
        } else {
            throw new ParamException("获取出入库方向参数异常");
        }
        return storagePageDtos;
    }

    /**
     * <h4>颜色集合转成以颜色编号为key ,颜色对象为value的Map集合</h4>
     * @return map集合
     */
    private Map<Integer, ColorParam> conventColorList2Map() {
        Map<Integer, ColorParam> maps = new ConcurrentHashMap<>();
        List<ColorParam> colorParams = colorService.findBySelect();
        CheckedUtil.checkNoNull(colorParams,"找不到颜色列表信息");
        int size = colorParams.size();
        for (int i = 0; i < size; i++) {
            maps.put(colorParams.get(i).getId(), colorParams.get(i));
        }
        return maps;
    }
}
