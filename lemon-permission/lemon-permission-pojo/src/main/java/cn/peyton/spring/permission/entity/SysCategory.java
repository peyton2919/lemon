package cn.peyton.spring.permission.entity;

/**
 * <h3>栏目 实体类 .</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/18 14:21
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class SysCategory {
	/** 编号  */
	private Integer id;
	/** 父编号  */
	private Integer parentId;
	/** 名称  */
	private String cateName;
	/** 地址  */
	private String cateUrl;
	/** 前样式  */
	private String cateBeforeStyle;
	/** 后样式  */
	private String cateAfterStyle;
	/** 排序 从小到大排序  */
	private Integer cateSeq;
	/** 状态 0 不可用 1 可用 2 删除 默认 1  */
	private Integer cateStatus;
	/** 类目类型 0 顾客 1 供应商 2 员工 3 管理员  */
	private Integer cateType;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 编号 
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return 编号 
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param parentId 父编号
	 */ 
	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}

	/** 
	 * @return 父编号 
	 */ 
	public Integer getParentId(){
		return parentId;
	}

	/** 
	 * @param cateName 名称 
	 */ 
	public void setCateName(String cateName){
		this.cateName = cateName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getCateName(){
		return cateName;
	}

	/** 
	 * @param cateUrl 地址 
	 */ 
	public void setCateUrl(String cateUrl){
		this.cateUrl = cateUrl;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getCateUrl(){
		return cateUrl;
	}

	/** 
	 * @param cateBeforeStyle 前样式 
	 */ 
	public void setCateBeforeStyle(String cateBeforeStyle){
		this.cateBeforeStyle = cateBeforeStyle;
	}

	/** 
	 * @return 前样式 
	 */ 
	public String getCateBeforeStyle(){
		return cateBeforeStyle;
	}

	/** 
	 * @param cateAfterStyle 后样式 
	 */ 
	public void setCateAfterStyle(String cateAfterStyle){
		this.cateAfterStyle = cateAfterStyle;
	}

	/** 
	 * @return 后样式 
	 */ 
	public String getCateAfterStyle(){
		return cateAfterStyle;
	}

	/** 
	 * @param cateSeq 排序 从小到大排序 
	 */ 
	public void setCateSeq(Integer cateSeq){
		this.cateSeq = cateSeq;
	}

	/** 
	 * @return 排序 从小到大排序 
	 */ 
	public Integer getCateSeq(){
		return cateSeq;
	}

	/** 
	 * @param cateStatus 状态 0 不可用 1 可用 2 删除 默认 1 
	 */ 
	public void setCateStatus(Integer cateStatus){
		this.cateStatus = cateStatus;
	}

	/** 
	 * @return 状态 0 不可用 1 可用 2 删除 默认 1 
	 */ 
	public Integer getCateStatus(){
		return cateStatus;
	}

	/** 
	 * @param cateType 类目类型 0 顾客 1 供应商 2 员工 3 管理员 
	 */ 
	public void setCateType(Integer cateType){
		this.cateType = cateType;
	}

	/** 
	 * @return 类目类型 0 顾客 1 供应商 2 员工 3 管理员 
	 */ 
	public Integer getCateType(){
		return cateType;
	}

}
