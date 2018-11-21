package cn.peyton.spring.lemon.controller.basis;

import cn.peyton.spring.basis.param.WebConfigBaseParam;
import cn.peyton.spring.basis.param.WebConfigCloseParam;
import cn.peyton.spring.basis.param.WebConfigCopyrightParam;
import cn.peyton.spring.basis.param.WebConfigExtParam;
import cn.peyton.spring.basis.service.SysWebConfigService;
import cn.peyton.spring.constant.Constants;
import cn.peyton.spring.exception.GlobalException;
import cn.peyton.spring.exception.ParamException;
import cn.peyton.spring.img.ImageUtil;
import cn.peyton.spring.lemon.controller.BasePicturePath;
import cn.peyton.spring.util.NameUtil;
import cn.peyton.spring.util.PathUtil;
import cn.peyton.spring.common.JsonData;
import cn.peyton.spring.file.FolderOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <h3>全局配置 Controller 类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/21 15:55
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
@Controller
public class WebConfigController {

	@Resource
	private SysWebConfigService sysWebConfigService;

    @RequestMapping("/sys/wc/webconfig.page")
    public ModelAndView index() {
        return new ModelAndView("basis/webConfig");
    }
    
    @ResponseBody
    @RequestMapping("/sys/wc/update_base.json")
    public JsonData updateBase(WebConfigBaseParam param, HttpServletRequest request) {
        String path = PathUtil.getPath(BasePicturePath.IMG_SYS,request);
        MultipartFile file = param.getLogoImgFile();
        String name = param.getImgName();
        //从session中获取图片名称
        Object tName = request.getSession().getAttribute(Constants.SESSION_WEBCONFIG_LOGO_IMAGE.name());
        if (null != tName){
            if (!tName.toString().equals(name)) {
                if ("".equals(file.getOriginalFilename())) {
                    throw new ParamException("Logo图片不能为空");
                }
                name = "logo.ico";
                path = path + name;
                param.setCompletePath(path);
            }
            param.setWebLogoImage(BasePicturePath.IMG_SYS + name);
        }else {
            throw new GlobalException("读取图片数据不正常,请重新加载...");
        }
        if (file.getSize() > 0) {
            try {
                ImageUtil.scale(file,path,600,600,true);
            } catch (Exception e) {
                FolderOperation.delFile(path);
               throw new GlobalException("图片保存错误!");
            }
        }
        sysWebConfigService.updateBase(param);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping("/wc/detail_base.json")
    public JsonData detailBase(@RequestParam(value = "id",required = false,defaultValue = "1")Integer webId, HttpServletRequest request) {

        WebConfigBaseParam webConfig = sysWebConfigService.findBaseById(webId);
        webConfig.setImgName(NameUtil.getImageName(webConfig.getWebLogoImage()));
        request.getSession().setAttribute(Constants.SESSION_WEBCONFIG_LOGO_IMAGE.name(),webConfig.getImgName());
        return JsonData.success(webConfig);
    }

    @ResponseBody
    @RequestMapping("/sys/wc/update_ext.json")
    public JsonData updateExt(WebConfigExtParam param) {
        sysWebConfigService.updateExt(param);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping("/wc/detail_ext.json")
    public JsonData detailExt(@RequestParam(value = "id",required = false,defaultValue = "1")Integer webId) {
        WebConfigExtParam webConfig = sysWebConfigService.findExtById(webId);

        return JsonData.success(webConfig);
    }

    @ResponseBody
    @RequestMapping("/sys/wc/update_copyright.json")
    public JsonData updateCopyright(WebConfigCopyrightParam param, HttpServletRequest request) {
        String path = PathUtil.getPath(BasePicturePath.IMG_SYS,request);
        MultipartFile file = param.getLinkIconFile();
        String name = param.getImgName();
        Object tName = request.getSession().getAttribute(Constants.SESSION_WEBCONFIG_LINK_ICON.name());
        if (null != tName){
            if (!tName.toString().equals(name)) {
                if ("".equals(file.getOriginalFilename())) {
                    throw new ParamException("Link Icon图片不能为空");
                }
                name = "headline.ico";
                path = path + name;
                param.setCompletePath(path);
            }
            param.setWebLinkIcon(BasePicturePath.IMG_SYS + name);
        }else {
            throw new GlobalException("读取图片数据不正常,请重新加载...");
        }
        if (file.getSize() > 0) {
            try {
                ImageUtil.scale(file,path,400,400,true);
            } catch (Exception e) {
                FolderOperation.delFile(path);
                throw new GlobalException("图片保存错误!");
            }
        }
        sysWebConfigService.updateCopyright(param);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping("/wc/detail_copyright.json")
    public JsonData detailCopyright(@RequestParam(value = "id",required = false,defaultValue = "1")Integer webId,HttpServletRequest request) {
        WebConfigCopyrightParam param = sysWebConfigService.findCopyrightById(webId);
        request.getSession().setAttribute(Constants.SESSION_WEBCONFIG_LINK_ICON.name(),param.getImgName());
        return JsonData.success(param);
    }

    @ResponseBody
    @RequestMapping("/sys/wc/update_close.json")
    public JsonData updateClose(WebConfigCloseParam param) {
        sysWebConfigService.updateClose(param);
        return JsonData.success();
    }

    @ResponseBody
    @RequestMapping("/wc/detail_close.json")
    public JsonData detailClose() {
        return JsonData.success(sysWebConfigService.findCloseById(1));
    }


    @ResponseBody
    @PostMapping("/load.json")
    public JsonData filesUpload(@RequestParam("file")MultipartFile file,HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("img/sys");
        if (!file.isEmpty()) {
            try {
                path = path + "\\" + file.getOriginalFilename();
                file.transferTo(new File(path));
            } catch (Exception e) {
                e.printStackTrace();
                return JsonData.error(e.getMessage());
            }
        }

        System.out.println(path);
        return JsonData.success(path);
    }
}
