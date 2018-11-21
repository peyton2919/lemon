package cn.peyton.spring.mall.entity;
import java.util.Date;

/**
 * <h3>出入库 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/13 16:19:41
 * @version 1.0.0
 * </pre>
*/
public class Storage {
	/** 编号  */
	private Long id;
	/** 入库时间，默认当前时间  */
	private Date storCreated;
	/** 更新时间  */
	private Date storUpdated;
	/** 出入库[0 入库, 1 出库],默认 0  */
    private Integer storDirection;
	/** 状态[0 废单,1 正常],默认 1  */
	private Integer storStatus;
    /** 总个数  */
	private Integer storTotal;
	/** 商品名称 */
	private String storComName;
    /** 商品图片地址  */
	private String storImageUrl;
    /**  仓库名称  */
	private String storWarName;
	/** 员工名称 */
	private String storEmpName;
    /** 仓库编号  */
    private Integer warId;
    /** 商品编号  */
    private String comId;
	/** 员工编号  */
	private Integer empId;


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
	 * @param storCreated 入库时间，默认当前时间 
	 */ 
	public void setStorCreated(Date storCreated){
		this.storCreated = storCreated;
	}

	/** 
	 * @return 入库时间，默认当前时间 
	 */ 
	public Date getStorCreated(){
		return storCreated;
	}

	/** 
	 * @param storUpdated 更新时间 
	 */ 
	public void setStorUpdated(Date storUpdated){
		this.storUpdated = storUpdated;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public Date getStorUpdated(){
		return storUpdated;
	}

    /**
     * @param storDirection 出入库[0 入库, 1 出库],默认 0
     */
    public void setStorDirection(Integer storDirection){
        this.storDirection = storDirection;
    }

    /**
     * @return 出入库[0 入库, 1 出库],默认 0
     */
    public Integer getStorDirection(){
        return storDirection;
    }

	/** 
	 * @param storStatus 状态[0 废单,1 正常],默认 1 
	 */ 
	public void setStorStatus(Integer storStatus){
		this.storStatus = storStatus;
	}

	/** 
	 * @return 状态[0 废单,1 正常],默认 1 
	 */ 
	public Integer getStorStatus(){
		return storStatus;
	}

    /**
     * @return 总个数
     */
    public Integer getStorTotal() {
        return storTotal;
    }

    /**
     * @param storTotal 总个数
     */
    public void setStorTotal(Integer storTotal) {
        this.storTotal = storTotal;
    }

    /**
     * @return 商品名称
     */
    public String getStorComName() {
        return storComName;
    }

    /**
     * @param storComName 商品名称
     */
    public void setStorComName(String storComName) {
        this.storComName = storComName;
    }

    /**
     * @return 商品图片地址
     */
    public String getStorImageUrl() {
        return storImageUrl;
    }

    /**
     * @param storImageUrl 商品图片地址
     */
    public void setStorImageUrl(String storImageUrl) {
        this.storImageUrl = storImageUrl;
    }

    /**
     * @return 仓库名称
     */
    public String getStorWarName() {
        return storWarName;
    }

    /**
     * @param storWarName 仓库名称
     */
    public void setStorWarName(String storWarName) {
        this.storWarName = storWarName;
    }

    /**
     * @return 员工名称
     */
    public String getStorEmpName() {
        return storEmpName;
    }

    /**
     * @param storEmpName 员工名称
     */
    public void setStorEmpName(String storEmpName) {
        this.storEmpName = storEmpName;
    }

    /**
     * @param warId 仓库编号
     */
    public void setWarId(Integer warId){
        this.warId = warId;
    }

    /**
     * @return 仓库编号
     */
    public Integer getWarId(){
        return warId;
    }

    /**
     * @param comId 商品编号
     */
    public void setComId(String comId){
        this.comId = comId;
    }

    /**
     * @return 商品编号
     */
    public String getComId(){
        return comId;
    }

    /**
     * @param empId 员工编号
     */
    public void setEmpId(Integer empId){
        this.empId = empId;
    }

	/** 
	 * @return 员工编号 
	 */ 
	public Integer getEmpId(){
		return empId;
	}

}
