package cn.peyton.spring.lemon.controller.usergroup;

import cn.peyton.spring.beans.PageQuery;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.enums.Status;
import cn.peyton.spring.usergroup.param.SupplierParam;
import cn.peyton.spring.usergroup.service.SupplierService;
import cn.peyton.spring.util.CookieUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h3>供应商 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/17 10:58:54
 * @version 1.0.0
 * </pre>
*/
@Controller
public class SupplierController {

	@Resource
	private SupplierService supplierService;

	@RequestMapping("/reg-sup.page")
    public ModelAndView register(HttpServletRequest request,HttpServletResponse response) {
	    return new ModelAndView("sup/reg");
    }

    @RequestMapping("/sys/sup/sys-sup.page")
    public ModelAndView sysSupplier() {
        return new ModelAndView("sup/sys-sup");
    }

    @RequestMapping("/sup/save.json")
    @ResponseBody
    public JsonData save(SupplierParam param) {
	    param.setStatus(Status.APPLY_FOR.getCode());
        supplierService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/sup/update.json")
    @ResponseBody
    public JsonData update(SupplierParam param) {
        supplierService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/sup/detail.json")
    @ResponseBody
    public JsonData detail(Long id) {
        return JsonData.success(supplierService.findById(id));
    }

    @RequestMapping("/sys/sup/sys-save.json")
    @ResponseBody
    public JsonData sysSave(SupplierParam param) {
        param.setPwd("123456");
        param.setConfirmPwd("123456");
        supplierService.save(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/sup/sys-update.json")
    @ResponseBody
    public JsonData sysUpdate(SupplierParam param) {
	    param.setPwd("123456");
	    param.setConfirmPwd("123456");
        supplierService.update(param);
        return JsonData.success();
    }

    @RequestMapping("/sys/sup/delete.json")
    @ResponseBody
    public JsonData delete(Long id) {
        supplierService.delete(id);
        return JsonData.success();
    }

    @RequestMapping("/sys/sup/sys-list.json")
    @ResponseBody
    public JsonData sysList(PageQuery page) {
	    return JsonData.success(supplierService.findByAll(page));
    }

    @RequestMapping("/sys/sup/sys-search.json")
    @ResponseBody
    public JsonData sysSearch(String keyword,PageQuery page) {
	    return JsonData.success(supplierService.findLikeByKeyword(keyword,page));
    }

    @RequestMapping("/sys/sup/sys-play.json")
    @ResponseBody
    public JsonData sysPlay(Long id) {
        supplierService.updateStatus(id, Status.NORMAL.getCode());
        return JsonData.success();
    }

    @RequestMapping("/sys/sup/sys-stop.json")
    @ResponseBody
    public JsonData sysStop(Long id) {
        supplierService.updateStatus(id, Status.CONGEAL.getCode());
        return JsonData.success();
    }

}
