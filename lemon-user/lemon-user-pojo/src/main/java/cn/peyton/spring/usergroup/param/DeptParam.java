package cn.peyton.spring.usergroup.param;

import cn.peyton.spring.usergroup.entity.SysDept;
import cn.peyton.spring.validator.constraints.Length;
import cn.peyton.spring.validator.constraints.NotBlank;
import cn.peyton.spring.validator.constraints.NotNull;

/**
 * <h3>部门 参数 传递类[用来展示数据]类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/11/17 08:59:27
 * @version 1.0.0
 * </pre>
*/
public class DeptParam{
    /**  部门ID */
    private Integer id;
    /** 部门名称 */
    @NotBlank(message = "部门名称不可以为空")
    @Length(max = 20,min = 2,message = "部门名称长度需要2-20之间字")
    private String name;
    /** 上级部门ID */
    private Integer parentId = 0;
    /** 部门在当前层级下的顺序，由小到大 */
    @NotNull(message = "展示顺序不能为空")
    private Integer seq;
    /**  备注 */
    @Length(max = 256,message = "备注长度不能超过256个字", min = 0)
    private String remark;

	//================================== Constructor =======================================//

	//================================== Method =======================================//
    /**
     * <h4>对象转成SysDept对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,parentId,seq,remark,operator]
     * </pre>
     */
    public SysDept convert(){
        SysDept sysDept = new SysDept();
        sysDept.setId(id);
        sysDept.setName(name);
        sysDept.setParentId(parentId);
        sysDept.setSeq(seq);
        sysDept.setRemark(remark);
        return sysDept;
    }

    /**
     * <h4>SysDept对象转成DeptParam对象<h4>
     * <pre>
     * 	 转换字段如下:
     * 	 [id,name,parentId,seq,remark,operator]
     * </pre>
     */
    public DeptParam compat(SysDept sysDept){
        if(null == sysDept){
            return new DeptParam();
        }
        this.setId(sysDept.getId());
        this.setName(sysDept.getName());
        this.setParentId(sysDept.getParentId());
        this.setSeq(sysDept.getSeq());
        this.setRemark(sysDept.getRemark());
        return this;
    }

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

}
