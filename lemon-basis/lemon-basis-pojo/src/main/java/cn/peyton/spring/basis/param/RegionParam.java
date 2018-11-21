package cn.peyton.spring.basis.param;

import cn.peyton.spring.basis.entity.Region;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.util.Lists;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Pattern;

import java.util.List;

/**
 * <h3>地区 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/27 16:34:34
 * @version 1.0.0
 * </pre>
*/
public class RegionParam{
	/** 编号  */
	private Long id;
	/** 名称  */
	@NotBlank(message = "地区名称不能为空")
    @Length(max = 50,message = "地区名称长度不能超过50个字符")
	private String name;
	/** 地区区码  */
	@Length(max = 20,message = "地区码长度不能超过20个字符")
	private String code;
	/** 排序,从小到大排序  */
	@NotBlank(message = "排序不能为空")
    @Pattern(regexp = Regulation.REGEX_INT,message = "排序格式不正确")
	private Integer seq;
	/** 地区层级  */
	@Length(max = 50,message = "地区层级长度不能超过50个字符")
	private String level;
	/** 父级编号，默认顶层为0  */
	@NotBlank(message = "父地区编号不能为空")
	private Long parentId;
    /** 展开状态 默认 false 关闭 */
	private boolean open = false;
    /** 地区 了集合对象 */
	private List<RegionParam> regionList = Lists.newArrayList();

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成RegionInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,regiName,regiCode,regiSeq,regiLevel,parentId]
     * </pre>
     */
    public Region convert(){
        Region region = new Region();
        region.setId(id);
        region.setRegiName(name);
        region.setRegiCode(code);
        region.setRegiSeq(seq);
        region.setRegiLevel(level);
        region.setParentId(parentId);
        return region;
    }

    /**
     * <h4>RegionInfo对象转成RegionParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,regiName,regiCode,regiSeq,regiLevel,parentId]
     * </pre>
     */
    public RegionParam compat(Region region){
        if(null == region){
            return new RegionParam();
        }
        this.id = region.getId();
        this.name = region.getRegiName();
        this.code = region.getRegiCode();
        this.seq = region.getRegiSeq();
        this.level = region.getRegiLevel();
        this.parentId = region.getParentId();
        return this;
    }


    //================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(Long id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public Long getId(){
		return id;
	}

	/** 
	 * @param name 名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param code 地区区码 
	 */ 
	public void setCode(String code){
        this.code = code;
    }

	/** 
	 * @return 地区区码 
	 */ 
	public String getCode(){
		return code;
	}

	/** 
	 * @param seq 排序,从小到大排序 
	 */ 
	public void setSeq(Integer seq){
		this.seq = seq;
	}

	/** 
	 * @return 排序,从小到大排序 
	 */ 
	public Integer getSeq(){
		return seq;
	}

	/** 
	 * @param level 地区层级 
	 */ 
	public void setLevel(String level){
		this.level = level;
	}

	/** 
	 * @return 地区层级 
	 */ 
	public String getLevel(){
		return level;
	}

	/** 
	 * @param parentId 父级编号，默认顶层为0 
	 */ 
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}

	/** 
	 * @return 父级编号，默认顶层为0 
	 */ 
	public Long getParentId(){
		return parentId;
	}

    /**
     * @return 展开状态 默认 false 关闭
     */
    public boolean isOpen() {
        return open;
    }

    /**
     * @param open 展开状态 默认 false 关闭
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

    /**
     * @return 子集合
     */
    public List<RegionParam> getRegionList() {
        return regionList;
    }

    /**
     * @param regionList 子集合
     */
    public void setRegionList(List<RegionParam> regionList) {
        this.regionList = regionList;
    }
}
