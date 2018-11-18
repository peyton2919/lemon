package cn.peyton.spring.lemon.controller.usergroup;

import cn.peyton.spring.beans.PageResult;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.usergroup.param.PostParam;
import cn.peyton.spring.usergroup.service.SysPostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <h3>职务 Controller 类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 14:32:57
 * @version 1.0.0
 * </pre>
*/
@Controller
@RequestMapping("/sys/post")
public class PostController {

	@Resource
	private SysPostService sysPostService;

    @RequestMapping("/list.json")
    @ResponseBody
    public JsonData list() {
        PageResult result = sysPostService.findByAll();
        return JsonData.success(result);
    }

    @ResponseBody
    @RequestMapping("/save.json")
    public JsonData save(PostParam param) {
        sysPostService.save(param);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping("/update.json")
    public JsonData update(PostParam param) {
        sysPostService.update(param);
        return JsonData.success();
    }
    @ResponseBody
    @RequestMapping("/delete.json")
    public JsonData delete(Integer id) {
        sysPostService.delete(id);
        return JsonData.success();
    }

}
