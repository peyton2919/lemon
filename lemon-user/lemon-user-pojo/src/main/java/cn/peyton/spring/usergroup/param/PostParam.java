package cn.peyton.spring.usergroup.param;

import cn.peyton.spring.usergroup.entity.SysPost;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;

/**
 * <h3>职务 参数 传递类[用来展示数据]</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/17 14:45
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public final class PostParam {
    /** 编号 */
    private Integer id;
    /** 名称  */
    @NotBlank(message = "职务名不可以为空")
    @Length(max = 50,message = "用户名长度需要在50个字以内")
    private String name;
    /** 说明 */
    @Length(max = 250,message = "备注长度需要在250个字以内")
    private String explain;
    /**
     * <h4>对象转换<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,postName,postExplain,depId]
     * </pre>
     */
    public SysPost convert(){
        SysPost sysPost = new SysPost();
        sysPost.setId(id);
        sysPost.setPostName(name);
        sysPost.setPostExplain(explain);
        return sysPost;
    }

    /**
     * <h4>SysPost对象转成PostParam对象</h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,postName,postExplain,depId]
     * </pre>
     * @param post
     * @return
     */
    public PostParam compat(SysPost post) {
        if (null == post) {
            return new PostParam();
        }
        this.setId(post.getId());
        this.setName(post.getPostName());
        this.setExplain(post.getPostExplain());
        return this;
    }

    /**
     * @return 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return 说明
     */
    public String getExplain() {
        return explain;
    }

    /**
     * @param explain 说明
     */
    public void setExplain(String explain) {
        this.explain = explain;
    }
}
