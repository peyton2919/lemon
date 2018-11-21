package cn.peyton.spring.mall.entity;
import java.util.Date;

/**
 * <h3>商品多层分类 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/13 22:13:17
 * @version 1.0.0
 * </pre>
*/
public class CommodityCategory{
	/** 编号  */
	private Long id;
	/** 父编号  */
	private Long parentId;
	/** 名称  */
	private String cocaName;
	/** 商品分类层级  */
	private String cocaLevel;
	/** 排序,按升序  */
	private Integer cocaSeq;
    /** 说明  */
    private String cocaExplain;
	/** 创建时间  */
	private Date cocaCreated;
	/** 更新时间  */
	private Date cocaUpdated;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


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
	 * @param parentId 父编号 
	 */ 
	public void setParentId(Long parentId){
		this.parentId = parentId;
	}

	/** 
	 * @return 父编号 
	 */ 
	public Long getParentId(){
		return parentId;
	}

	/** 
	 * @param cocaName 名称 
	 */ 
	public void setCocaName(String cocaName){
		this.cocaName = cocaName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getCocaName(){
		return cocaName;
	}

	/** 
	 * @param cocaLevel 商品分类层级 
	 */ 
	public void setCocaLevel(String cocaLevel){
		this.cocaLevel = cocaLevel;
	}

	/** 
	 * @return 商品分类层级 
	 */ 
	public String getCocaLevel(){
		return cocaLevel;
	}

	/** 
	 * @param cocaSeq 排序,按升序 
	 */ 
	public void setCocaSeq(Integer cocaSeq){
		this.cocaSeq = cocaSeq;
	}

	/** 
	 * @return 排序,按升序 
	 */ 
	public Integer getCocaSeq(){
		return cocaSeq;
	}

    /**
     * @param cocaExplain 说明
     */
    public void setCocaExplain(String cocaExplain){
        this.cocaExplain = cocaExplain;
    }

    /**
     * @return 说明
     */
    public String getCocaExplain(){
        return cocaExplain;
    }

    /**
	 * @param cocaCreated 创建时间 
	 */ 
	public void setCocaCreated(Date cocaCreated){
		this.cocaCreated = cocaCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getCocaCreated(){
		return cocaCreated;
	}

	/** 
	 * @param cocaUpdated 更新时间 
	 */ 
	public void setCocaUpdated(Date cocaUpdated){
		this.cocaUpdated = cocaUpdated;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public Date getCocaUpdated(){
		return cocaUpdated;
	}

}
