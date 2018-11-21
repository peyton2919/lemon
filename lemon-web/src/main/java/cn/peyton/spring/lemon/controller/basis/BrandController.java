package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.param.BrandParam;
import cn.peyton.spring.basis.service.BrandService;
import cn.peyton.spring.common.RequestHolder;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.file.FolderOperation;
import cn.peyton.spring.img.ImageUtil;
import cn.peyton.spring.lemon.controller.BasePicturePath;
import cn.peyton.spring.usergroup.service.SupplierService;
import cn.peyton.spring.util.NameUtil;
import cn.peyton.spring.util.PathUtil;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>品牌 Controller 类 .</h3>
 * <pre>
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @projectName: lemon
 * @packageName: cn.peyton.spring.lemon.controller.mall.BrandController.java
 * @createDate: 2018-09-13 17:34
 * @version: 1.0.0
 * </pre>
 */
@Controller
public class BrandController {

    @Resource
    private BrandService brandService;
    @Resource
    private SupplierService supplierService;

    @RequestMapping("/sys/brand/brand.page")
    public ModelAndView index() {
        return new ModelAndView("basis/brand");
    }


    @ResponseBody
    @RequestMapping("/sys/brand/save.json")
    public JsonData save(BrandParam param, HttpServletRequest request) {
        if (null != param.getImgFile() && param.getImgFile().getSize() > 0) {
            savePicture(param,request);
        } else {
            throw new GlobalException("读取图片数据不正常,请重新加载...");
        }

        brandService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/brand/play.json")
    @ResponseBody
    public JsonData play(Integer id) {
        brandService.updateStatus(id, Status.NORMAL.getCode());
        return JsonData.success();
    }

    @RequestMapping("/sys/brand/stop.json")
    @ResponseBody
    public JsonData stop(Integer id) {
        brandService.updateStatus(id, Status.CONGEAL.getCode());
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping("/sys/brand/delete.json")
    public JsonData delete(Integer id) {
        brandService.delete(id);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping("/sys/brand/update.json")
    public JsonData update(BrandParam param,HttpServletRequest request) {
        String tName = (String) RequestHolder.getCurrentRequest().getSession(false).
                getAttribute(Constants.SESSION_CURRENT_IMAGE.name());
        MultipartFile file = param.getImgFile();
        long length = file.getSize();
        if (null == param.getImgName() || tName == null || "".equals(tName)) {
            throw new ParamException("请选择LOGO图片");
        }
        boolean tExist = brandService.exist(tName, param.getImgName(), file.getOriginalFilename(), length);
        if (tExist) {
            savePicture(param,request);
        }
       //TODO

        brandService.update(param);
        return JsonData.success();
    }


    @ResponseBody
    @RequestMapping("/brand/detail.json")
    public JsonData detail(Integer id) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        if (null != id && !"".equals(id)) {
            BrandParam param = brandService.findById(id);
            map.put("brand", param);

            RequestHolder.getCurrentRequest().getSession()
                    .setAttribute(Constants.SESSION_CURRENT_IMAGE.name()
                            ,NameUtil.getImageName(param.getLogo()));
        }
        map.put("suppliers", supplierService.findBySelect());
        return JsonData.success(map);
    }


    @ResponseBody
    @RequestMapping("/brand/list.json")
    public JsonData list(PageQuery page) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("brands", brandService.findByAll(page));
        map.put("suppliers", supplierService.findBySelect());
        return JsonData.success(map);
    }


    @ResponseBody
    @RequestMapping("/brand/search.json")
    public JsonData search(String keyword, PageQuery page) {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("brands", brandService.findLikeByKeyword(keyword,page));
        map.put("suppliers", supplierService.findBySelect());
        return JsonData.success(map);
    }

    private void savePicture(BrandParam param,HttpServletRequest request) {
        MultipartFile file = param.getImgFile();
        String name = param.getImgName();
        if (null == name || "".equals(name.trim())) {
            throw new GlobalException("读取图片数据不正常,请重新加载...");
        }
        StringBuilder dataPath = new StringBuilder();
        StringBuilder completePath = new StringBuilder();
        PathUtil.convertPath(request, BasePicturePath.IMG_LOGO,file.getOriginalFilename(),dataPath,completePath);
        //设置保存在数据库中的路径 [/img/sys/aaa.png]
        param.setLogo(dataPath.toString());
        param.setCompletePath(completePath.toString());
        try {
            //保存图片
            ImageUtil.scale(file, param.getCompletePath(), 360, 180, true);
        } catch (Exception e) {
            //保存异常删除图片
            FolderOperation.delFile(param.getCompletePath());
            throw new GlobalException("图片保存错误!");
        }
    }


}
