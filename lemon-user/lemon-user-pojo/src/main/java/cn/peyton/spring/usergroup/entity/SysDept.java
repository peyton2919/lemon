package cn.peyton.spring.usergroup.entity;

import java.util.Date;
/**
 * <h3>部门 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 08:54:47
 * @version 1.0.0
 * </pre>
*/
public class SysDept{
	/** 部门id  */
	private Integer id;
	/** 部门名称  */
	private String name;
	/** 上级部门id  */
	private Integer parentId;
	/** 部门层级  */
	private String level;
	/** 部门在当前层级下的顺序，由小到大  */
	private Integer seq;
	/** 备注  */
	private String remark;
	/** 操作者  */
	private String operator;
	/** 最后一次操作时间  */
	private Date operateTime;
	/** 最后一次更新操作者的ip地址  */
	private String operateIp;

	//================================== Constructor =======================================//

	//================================== Method =======================================//


	//================================== PREFIX_GET AND PREFIX_SET =======================================//

	/** 
	 * @param id 部门id 
	 */ 
	public void setId(Integer id){
		this.id = id;
	}

	/** 
	 * @return 部门id 
	 */ 
	public Integer getId(){
		return id;
	}

	/** 
	 * @param name 部门名称 
	 */ 
	public void setName(String name){
		this.name = name;
	}

	/** 
	 * @return 部门名称 
	 */ 
	public String getName(){
		return name;
	}

	/** 
	 * @param parentId 上级部门id 
	 */ 
	public void setParentId(Integer parentId){
		this.parentId = parentId;
	}

	/** 
	 * @return 上级部门id 
	 */ 
	public Integer getParentId(){
		return parentId;
	}

	/** 
	 * @param level 部门层级 
	 */ 
	public void setLevel(String level){
		this.level = level;
	}

	/** 
	 * @return 部门层级 
	 */ 
	public String getLevel(){
		return level;
	}

	/** 
	 * @param seq 部门在当前层级下的顺序，由小到大 
	 */ 
	public void setSeq(Integer seq){
		this.seq = seq;
	}

	/** 
	 * @return 部门在当前层级下的顺序，由小到大 
	 */ 
	public Integer getSeq(){
		return seq;
	}

	/** 
	 * @param remark 备注 
	 */ 
	public void setRemark(String remark){
		this.remark = remark;
	}

	/** 
	 * @return 备注 
	 */ 
	public String getRemark(){
		return remark;
	}

	/** 
	 * @param operator 操作者 
	 */ 
	public void setOperator(String operator){
		this.operator = operator;
	}

	/** 
	 * @return 操作者 
	 */ 
	public String getOperator(){
		return operator;
	}

	/** 
	 * @param operateTime 最后一次操作时间 
	 */ 
	public void setOperateTime(Date operateTime){
		this.operateTime = operateTime;
	}

	/** 
	 * @return 最后一次操作时间 
	 */ 
	public Date getOperateTime(){
		return operateTime;
	}

	/** 
	 * @param operateIp 最后一次更新操作者的ip地址 
	 */ 
	public void setOperateIp(String operateIp){
		this.operateIp = operateIp;
	}

	/** 
	 * @return 最后一次更新操作者的ip地址 
	 */ 
	public String getOperateIp(){
		return operateIp;
	}

}
