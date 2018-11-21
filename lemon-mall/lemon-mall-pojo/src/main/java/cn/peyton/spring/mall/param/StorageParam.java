package cn.peyton.spring.mall.param;

import cn.peyton.spring.mall.dto.StoragePageDto;
import cn.peyton.spring.mall.entity.Storage;
import cn.peyton.spring.regex.Regulation;
import cn.peyton.spring.util.DateUtil;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.Pattern;
import cn.peyton.spring.validator.constraints.Size;

import java.util.LinkedList;
import java.util.List;

/**
 * <h3>出入库 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/14 11:44:37
 * @version 1.0.0
 * </pre>
*/
public class StorageParam{
	/** 编号  */
	private Long id;
	/** 入库时间，默认当前时间  */
	private String created;
	/** 更新时间  */
	private String updated;
	/** 出入库[0 入库, 1 出库],默认 0  */
	@NotBlank(message = "出入库方向不能为空")
    @Size(min = 0,max = 1,message = "出入库方向选择不正确")
	private Integer direction;
	/** 状态[0 废单,1 正常],默认 1  */
	private Integer status;
	/** 总个数 */
	private Integer total;
	/** 商品名称,用来模糊查找 */
    @NotBlank(message = "商品名称不能为空")
    @Length(max = 100,message = "商品名称长度不能超过100个字符")
	private String comName;
    /** 商品图片地址 */
    @Length(max = 150,message = "图片地址长度不能超过150个字符")
	private String imageUrl;
    /** 仓库名称 */
    @Length(max = 50,message = "仓库名称长度不能超过50个字符")
	private String warName;
    /**  员工名称 */
    @Length(max = 50,message = "员工名称长度不能超过50个字符")
	private String empName;
	/** 仓库编号  */
	@NotBlank(message = "仓库编号不能为空")
    @Pattern(regexp = Regulation.REGEX_INT,message = "仓库编号格式不正确")
	private Integer warId;
	/** 商品编号  */
    @NotBlank(message = "商品编号不能为空")
    @Length(max = 50,message = "商品编号长度不能超过50个字符")
	private String comId;
	/** 员工编号  */
	private Integer empId;
    /**  数量集合 */
    private LinkedList<Integer> quantities;
    /** 颜色编号集合 */
    private LinkedList<Integer> colIds;
    /** 库存数量集合 */
    private  LinkedList<Integer> inventoryQuantities;
    /**  出入库明细 集合 */
    private List<StorageDetailParam> storageDetailParams;

    /** 出入库明细页面 集合 */
    private List<StoragePageDto> storagePages;

	//================================== Constructor =======================================//



    //================================== Method =======================================//
    /**
     * <h4>对象转成StorageInfo对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,storCreated,storUpdated,storStyle,storStatus,storTotal,storComName,
     * 	 storImageUrl,storWarName,storEmpName,warId,comId,empId]
     * </pre>
     */
    public Storage convert(){
        Storage storage = new Storage();
        storage.setId(id);
        storage.setStorCreated(DateUtil.conventStr2Date(created));
        storage.setStorUpdated(DateUtil.conventStr2Date(updated));
        storage.setStorDirection(direction);
        storage.setStorStatus(status);
        storage.setStorTotal(total);
        storage.setStorComName(comName);
        storage.setStorImageUrl(imageUrl);
        storage.setStorWarName(warName);
        storage.setStorEmpName(empName);
        storage.setWarId(warId);
        storage.setComId(comId);
        storage.setEmpId(empId);
        return storage;
    }

    /**
     * <h4>StorageInfo对象转成StorageParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,storCreated,storUpdated,storStyle,storStatus,storTotal,storComName,
     * 	 storImageUrl,storWarName,storEmpName,warId,comId,empId]
     * </pre>
     */
    public StorageParam compat(Storage storage){
        if (null == storage){
            return new StorageParam();
        }
        this.id = storage.getId();
        this.created = DateUtil.conventDate2Str(storage.getStorCreated());
        this.updated = DateUtil.conventDate2Str(storage.getStorUpdated());
        this.direction = storage.getStorDirection();
        this.status = storage.getStorStatus();
        this.total = storage.getStorTotal();
        this.comName = storage.getStorComName();
        this.imageUrl = storage.getStorImageUrl();
        this.empName = storage.getStorEmpName();
        this.warName = storage.getStorWarName();
        this.warId = storage.getWarId();
        this.comId = storage.getComId();
        this.empId = storage.getEmpId();
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
	 * @param created 入库时间，默认当前时间 
	 */ 
	public void setCreated(String created){
		this.created = created;
	}

	/** 
	 * @return 入库时间，默认当前时间 
	 */ 
	public String getCreated(){
		return created;
	}

	/** 
	 * @param updated 更新时间 
	 */ 
	public void setUpdated(String updated){
		this.updated = updated;
	}

	/** 
	 * @return 更新时间 
	 */ 
	public String getUpdated(){
		return updated;
	}

	/** 
	 * @param direction 出入库[0 入库, 1 出库],默认 0
	 */ 
	public void setDirection(Integer direction){
		this.direction = direction;
	}

	/** 
	 * @return 出入库[0 入库, 1 出库],默认 0 
	 */ 
	public Integer getDirection(){
		return direction;
	}

	/** 
	 * @param status 状态[0 废单,1 正常],默认 1 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 状态[0 废单,1 正常],默认 1 
	 */ 
	public Integer getStatus(){
		return status;
	}

    /**
     * @return 总个数
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total 总个数
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return 商品名称,用来模糊查找
     */
    public String getComName() {
        return comName;
    }

    /**
     * @param comName 商品名称,用来模糊查找
     */
    public void setComName(String comName) {
        this.comName = comName;
    }

    /**
     * @return 商品图片地址
     */
    public String getImageUrl() {
        return imageUrl;
    }

    /**
     * @param imageUrl 商品图片地址
     */
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * @return 仓库名称
     */
    public String getWarName() {
        return warName;
    }

    /**
     * @param warName 仓库名称
     */
    public void setWarName(String warName) {
        this.warName = warName;
    }

    /**
     * @return 员工名称
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName 员工名称
     */
    public void setEmpName(String empName) {
        this.empName = empName;
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

    /**
     * @return 数量集合
     */
    public LinkedList<Integer> getQuantities() {
        return quantities;
    }

    /**
     * @param quantities 数量集合
     */
    public void setQuantities(LinkedList<Integer> quantities) {
        this.quantities = quantities;
    }

    /**
     * @return 颜色编号集合
     */
    public LinkedList<Integer> getColIds() {
        return colIds;
    }

    /**
     * @param colIds 颜色编号集合
     */
    public void setColIds(LinkedList<Integer> colIds) {
        this.colIds = colIds;
    }

    /**
     * @return 库存数量集合
     */
    public LinkedList<Integer> getInventoryQuantities() {
        return inventoryQuantities;
    }

    /**
     * @param inventoryQuantities 库存数量集合
     */
    public void setInventoryQuantities(LinkedList<Integer> inventoryQuantities) {
        this.inventoryQuantities = inventoryQuantities;
    }

    /**
     * @return 出入库明细 集合
     */
    public List<StorageDetailParam> getStorageDetailParams() {
        return storageDetailParams;
    }

    /**
     * @param storageDetailParams 出入库明细 集合
     */
    public void setStorageDetailParams(List<StorageDetailParam> storageDetailParams) {
        this.storageDetailParams = storageDetailParams;
    }

    /**
     * @return 出入库明细页面 集合
     */
    public List<StoragePageDto> getStoragePages() {
        return storagePages;
    }

    /**
     * @param storagePages 出入库明细页面 集合
     */
    public void setStoragePages(List<StoragePageDto> storagePages) {
        this.storagePages = storagePages;
    }
}
