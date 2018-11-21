package cn.peyton.spring.mall.entity;

/**
 * <h3>删除图片 实体类 .</h3>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @email <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @createDate 2018/10/10 10:18:11
 * @version 1.0.0
 * </pre>
*/
public class DeletePicture{
	/** 编号  */
	private Long id;
	/** 名称  */
	private String name;
	/** 状态，1为可用，0不可用，2为删除, 默认为1  */
	private Integer status;

	//================================== Constructor =======================================//

    /**
     * <h4>构造函数</h4>
     */
    public DeletePicture() {
    }

    /**
     * <h4>构造函数</h4>
     * @param name 名称
     * @param status 状态
     */
    public DeletePicture(String name, Integer status) {
        this.name = name;
        this.status = status;
    }


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
	 * @param status 状态，1为可用，0不可用，2为删除, 默认为1 
	 */ 
	public void setStatus(Integer status){
		this.status = status;
	}

	/** 
	 * @return 状态，1为可用，0不可用，2为删除, 默认为1 
	 */ 
	public Integer getStatus(){
		return status;
	}

}
