package cn.peyton.spring.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * <h3>分页 标签</h3>
 * <pre>
 * @email: <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @create date: 2018/11/16 15:46
 * @author: <a href="http://www.peyton.cn">peyton</a>
 * @version: 1.0.0
 * </pre>
 */
public class Pagination extends TagSupport{
	/** */
	private static final long serialVersionUID = 1L;
	/** 总页数 */
	private int totalPages;
	/** 当前页数 */
	private int currentPage = 1;
	/** 每页显示数,默认12 */
	private int pageRecorders;
	/** 总条数,在数据库查到的总行数 */
	private int totalRows;
	
	/** 要跳转的action 地址与href功能相同,直接用名称不用加.action  */
	private String action; 
	/** 要跳转的action 地址与action功能相同,名称后面要加.action  */
	private String href;
	/**跳转参数名称跟在？后面的参数如：aaa.action?value  */
	private String jumpName;
	/** 参数名集合,多个用','分开 */
	private Object paramProperties;
	/** 参数值集合,多个用','分开 */
	private Object paramValues;
	/** 内部参数值*/
	private StringBuffer params;
	
	

	/** 构造方法*/
	public Pagination(){ }

	@Override
	public int doStartTag() throws JspException{
		if(pageRecorders <= 0) {pageRecorders = 12;}
		
		int temp = 0;
		totalPages = totalRows/pageRecorders;
		temp = totalRows % pageRecorders;
		if(temp > 0) {totalPages ++ ;}
		
		if( getJumpName() == null || "".equals(getJumpName())){setJumpName("currentPage");}
		
		try {
			if (paramProperties != null  && paramValues != null) {
				String[] _paramNames = paramProperties.toString().split("_");
				String[] _paramValues= paramValues.toString().split("_");
				if (_paramNames.length == _paramValues.length) {
					params = new StringBuffer();
					for (int i = 0; i < _paramNames.length; i++) {
						params.append("&" + _paramNames[i] + "=" + _paramValues[i]);
					} 
				}
			}
		} catch (Exception e) {
			params = null;
		}
		
		return super.doStartTag();
	}
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = super.pageContext.getOut();
		try {
			if(totalPages >=2){
				out.println("<div style=\"text-align:center;\">");
				out.println("<nav aria-label=\"Page navigation\">"); 
				out.println("<ul class=\"pagination\">");
				if(totalPages > 7){
					for (int i = 1; i <= totalPages; i++) {
						if(currentPage >= 5){
							if(i == (currentPage - 4)){
								out.println("<li class=\"paginItem\"><a href=\"" + href + "?" + jumpName + "=1"
										 + ((params!=null) ? params : "") + "\">");
								out.println("首页</a></li>");
								out.println("<li><a href=\"javascript:;\">...</a></li>");
							}
							if(i == (currentPage + 4)){
								out.println(" <li><a href=\"javascript:;\">...</a></li>");
								out.println("<li class=\"paginItem\"><a href=\""+ href + "?" + jumpName+"=" + totalPages 
										 + ((params!=null) ? params : "") + "\">");
								out.println("未页</a></li>");
							}
							if(i >= (currentPage-3) && i <= (currentPage+3)){outPage(out, i);}
						}else{
							if(i > 7){
								out.println("<li><a href=\"javascript:;\">...</a></li> ");
								out.println("<li><a href=\"" + href + "?" + jumpName + "=" + totalPages 
										 + ((params!=null) ? params : "") + "\">");
								out.println("未页</a></li>");
								break;
							}
							outPage(out, i);
						}
					}
				}else{for (int i = 1; i <= totalPages; i++) {outPage(out, i);}}
				out.println("</ul></nav></div>");
			}
		} catch (Exception e) {}
		return EVAL_PAGE;
	}
	
	private void outPage(JspWriter out, int i) throws IOException {
		if(i==currentPage){
			out.println("<li class=\"active\"><a href=\"#\">");
			out.println( i + "<span class=\"sr-only\">(current)</span></a></li>");
		}else{
			out.println("<li><a href=\"" + href + "?" + jumpName + "=" + i  
						 + ((params!=null) ? params : "") +"\">");
			out.println( i + "</a></li>");
		}
	}
	/** @return 参数名集合,多个用','分开	 */
	public Object getParamProperties() {
		return paramProperties;
	}
	/** @param paramProperties 参数名集合,多个用','分开	 */
	public void setParamProperties(Object paramProperties) {
		this.paramProperties = paramProperties;
	}
	/** @return  参数值集合,多个用','分开	 */
	public Object getParamValues() {
		return paramValues;
	}
	/** @param paramValues 参数值集合,多个用','分开	 */
	public void setParamValues(Object paramValues) {
		this.paramValues = paramValues;
	}
	/** @return 跳转参数名称跟在？后面的参数如：aaa.action?value */
	public String getJumpName() {
		return jumpName;
	}
	/** @param jumpName 跳转参数名称跟在？后面的参数如：aaa.action?value */
	public void setJumpName(String jumpName) {
		this.jumpName = jumpName;
	}
	/** @return 当前页数 */
	public int getCurrentPage() {
		return currentPage;
	}
	/** @param currentPage 当前页数 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/** @return 每页显示数,默认2*/
	public int getPageRecorders() {
		return pageRecorders;
	}
	/** @param pageRecorders  每页显示数,默认20*/
	public void setPageRecorders(int pageRecorders) {
		this.pageRecorders = pageRecorders;
	}
	/** @return 总条数,在数据库查到的总行数 */
	public int getTotalRows() {
		return totalRows;
	}
	/** @param totalRows 总条数,在数据库查到的总行数*/
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
	/** @return 要跳转的action 地址与href功能相同,直接用名称不用加.action */
	public String getAction() {
		return action;
	}
	/** @param action  要跳转的action 地址与href功能相同,直接用名称不用加.action */
	public void setAction(String action) {
		this.action = action;
	}
	/** @return 要跳转的action 地址与action功能相同,名称后面要加.action */
	public String getHref() {
		return href;
	}
	/** @param href 要跳转的action 地址与action功能相同,名称后面要加.action */
	public void setHref(String href) {
		this.href = href;
	}
}
