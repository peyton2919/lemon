package cn.peyton.spring.lemon.controller.usergroup;

import cn.peyton.spring.basis.param.RegionParam;
import cn.peyton.spring.basis.service.RegionService;
import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.usergroup.param.CustomerGradeParam;
import cn.peyton.spring.usergroup.param.CustomerParam;
import cn.peyton.spring.usergroup.service.CustomerGradeService;
import cn.peyton.spring.usergroup.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <h3>客户 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:28:50
 * @version 1.0.0
 * </pre>
*/
@Controller
public class CustomerController {
    /**  */
    private final static String INITIALIZE_PASSWORD = "123456";

	@Resource
	private CustomerService customerInfoService;
	@Resource
    private RegionService regionService;
	@Resource
    private CustomerGradeService customerGradeService;

    @RequestMapping("/reg-cus.page")
    public ModelAndView register() {
        return new ModelAndView("cus/reg");
    }

    @RequestMapping("/sys/cus/sys-cus.page")
    public ModelAndView sysCustomer() {
        return new ModelAndView("cus/sys-cus");
    }

    @RequestMapping("/cus/save.json")
    @ResponseBody
    public JsonData save(CustomerParam param) {
        //默认用户类型为零售客户 值 = 1
        param.setType(CustomerService.Holder.CUSTOMER_RETAIL);
        param.setStatus(Status.APPLY_FOR.getCode());
        customerInfoService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/cus/update.json")
    @ResponseBody
    public JsonData update(CustomerParam param) {
        customerInfoService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/cus/detail.json")
    @ResponseBody
    public JsonData detail() {
        Map<String, Object> map = new ConcurrentHashMap<>(2);
        map.put("regionList", regionService.findBySelect());
        map.put("customerGradeList", customerGradeService.findBySelect());
        return JsonData.success(map);
    }

    @RequestMapping("/sys/cus/sys-editor.json")
    @ResponseBody
    public JsonData sysEditor(@RequestParam(name = "customerId",required = false,defaultValue = "") Long customerId) {
        Map<String, Object> map = new ConcurrentHashMap<>(4);
        if (null != customerId && !"".equals(customerId)) {
            map.put("customer",customerInfoService.findById(customerId));
        }
        map.put("regionList", regionService.findBySelect());
        map.put("customerGradeList", customerGradeService.findBySelect());
        return JsonData.success(map);
    }

    @RequestMapping("/sys/cus/sys-detail.json")
    @ResponseBody
    public JsonData sysDetail(@RequestParam(name = "customerId",required = false,defaultValue = "") Long customerId) {
        Map<String, Object> map = new ConcurrentHashMap<>(4);
        if (null != customerId && !"".equals(customerId)) {
            CustomerParam customer = customerInfoService.findById(customerId);
            map.put("customer",customer);
            List<RegionParam> regionParamList = new ArrayList<RegionParam>();
            regionParamList.add(regionService.findById(customer.getRegiId()));
            map.put("regionList",regionParamList);
            List<CustomerGradeParam> customerGradeParamList = new ArrayList<CustomerGradeParam>();
            customerGradeParamList.add(customerGradeService.findById(customer.getCugrId()));
            map.put("customerGradeList",customerGradeParamList);
        }
        return JsonData.success(map);
    }

    @RequestMapping("/sys/cus/sys-save.json")
    @ResponseBody
    public JsonData sysSave(CustomerParam param) {
        param.setPwd(INITIALIZE_PASSWORD);
        param.setConfirmPwd(INITIALIZE_PASSWORD);
        customerInfoService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/cus/sys-update.json")
    @ResponseBody
    public JsonData sysUpdate(CustomerParam param) {
        param.setPwd(INITIALIZE_PASSWORD);
        param.setConfirmPwd(INITIALIZE_PASSWORD);
        customerInfoService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/cus/delete.json")
    @ResponseBody
    public JsonData delete(Long customerId) {
        customerInfoService.delete(customerId);
        return JsonData.success();
    }

    @RequestMapping("/sys/cus/sys-list.json")
    @ResponseBody
    public JsonData sysList(PageQuery page) {
        return JsonData.success(customerInfoService.findByAll(page));
    }

    @RequestMapping("/sys/cus/sys-search.json")
    @ResponseBody
    public JsonData sysSearch(String keyword,PageQuery page) {
        return JsonData.success(customerInfoService.findLikeByKeyword(keyword,page));
    }

    @RequestMapping("/sys/cus/sys-play.json")
    @ResponseBody
    public JsonData sysPlay(Long customerId) {
        customerInfoService.updateStatus(customerId, Status.NORMAL.getCode());
        return JsonData.success();
    }

    @RequestMapping("/sys/cus/sys-stop.json")
    @ResponseBody
    public JsonData sysStop(Long customerId) {
        customerInfoService.updateStatus(customerId, Status.CONGEAL.getCode());
        return JsonData.success();
    }


}
