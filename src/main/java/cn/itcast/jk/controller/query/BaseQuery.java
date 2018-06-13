package cn.itcast.jk.controller.query;

import java.io.Serializable;

/**
 * 条件对象公用对象
 * @author lx
 */
public class BaseQuery implements Serializable{

	private static final long serialVersionUID = 1L;
	public final static int DEFAULT_SIZE = 10;
	protected int pageSize = DEFAULT_SIZE;
	protected int startRow;
	protected int pageNo = 1;

	protected String fields;
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
		this.startRow = (pageNo-1)*this.pageSize;
	}
	public int getPageSize() {
		return pageSize;
	}
	public BaseQuery setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.startRow = (pageNo-1)*this.pageSize;
		return this;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	
	public String getFields() {
		return fields;
	}
	public void setFields(String fields) {
		this.fields = fields;
	}
	
}
