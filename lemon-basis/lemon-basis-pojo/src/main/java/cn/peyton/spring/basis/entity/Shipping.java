package cn.peyton.spring.basis.entity;
import java.util.Date;

/**
 * <h3>运输 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/09/11 14:22:56
 * @version 1.0.0
 * </pre>
*/
public class Shipping {
	/** 编号  */
	private Long id;
	/** 顾客编号  */
	private Long custId;
	/** 名称  */
	private String shipName;
	/** 电话  */
	private String shipTel;
	/** 手机  */
	private String shipPhone;
	/** 省份  */
	private String shipProvince;
	/** 城市  */
	private String shipCity;
	/** 区/县  */
	private String shipDistrict;
	/** 地址  */
	private String shipAddress;
	/** 邮编  */
	private String shipZip;
	/** 创建时间  */
	private Date shipCreated;
	/** 最后登录时间  */
	private Date shipUpdated;

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
	 * @param custId 顾客编号 
	 */ 
	public void setCustId(Long custId){
		this.custId = custId;
	}

	/** 
	 * @return 顾客编号 
	 */ 
	public Long getCustId(){
		return custId;
	}

	/** 
	 * @param shipName 名称 
	 */ 
	public void setShipName(String shipName){
		this.shipName = shipName;
	}

	/** 
	 * @return 名称 
	 */ 
	public String getShipName(){
		return shipName;
	}

	/** 
	 * @param shipTel 电话 
	 */ 
	public void setShipTel(String shipTel){
		this.shipTel = shipTel;
	}

	/** 
	 * @return 电话 
	 */ 
	public String getShipTel(){
		return shipTel;
	}

	/** 
	 * @param shipPhone 手机 
	 */ 
	public void setShipPhone(String shipPhone){
		this.shipPhone = shipPhone;
	}

	/** 
	 * @return 手机 
	 */ 
	public String getShipPhone(){
		return shipPhone;
	}

	/** 
	 * @param shipProvince 省份 
	 */ 
	public void setShipProvince(String shipProvince){
		this.shipProvince = shipProvince;
	}

	/** 
	 * @return 省份 
	 */ 
	public String getShipProvince(){
		return shipProvince;
	}

	/** 
	 * @param shipCity 城市 
	 */ 
	public void setShipCity(String shipCity){
		this.shipCity = shipCity;
	}

	/** 
	 * @return 城市 
	 */ 
	public String getShipCity(){
		return shipCity;
	}

	/** 
	 * @param shipDistrict 区/县 
	 */ 
	public void setShipDistrict(String shipDistrict){
		this.shipDistrict = shipDistrict;
	}

	/** 
	 * @return 区/县 
	 */ 
	public String getShipDistrict(){
		return shipDistrict;
	}

	/** 
	 * @param shipAddress 地址 
	 */ 
	public void setShipAddress(String shipAddress){
		this.shipAddress = shipAddress;
	}

	/** 
	 * @return 地址 
	 */ 
	public String getShipAddress(){
		return shipAddress;
	}

	/** 
	 * @param shipZip 邮编 
	 */ 
	public void setShipZip(String shipZip){
		this.shipZip = shipZip;
	}

	/** 
	 * @return 邮编 
	 */ 
	public String getShipZip(){
		return shipZip;
	}

	/** 
	 * @param shipCreated 创建时间 
	 */ 
	public void setShipCreated(Date shipCreated){
		this.shipCreated = shipCreated;
	}

	/** 
	 * @return 创建时间 
	 */ 
	public Date getShipCreated(){
		return shipCreated;
	}

	/** 
	 * @param shipUpdated 最后登录时间 
	 */ 
	public void setShipUpdated(Date shipUpdated){
		this.shipUpdated = shipUpdated;
	}

	/** 
	 * @return 最后登录时间 
	 */ 
	public Date getShipUpdated(){
		return shipUpdated;
	}

}
