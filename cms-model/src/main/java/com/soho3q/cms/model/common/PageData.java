package com.soho3q.cms.model.common;

import java.util.List;

/**
 * @author ZLL 分页数据 2015-10-15
 */
public class PageData<T> {

	/**
	 * 总数
	 */
	private Integer total = 0;
	/**
	 * 总页数
	 */
	private Integer pageTotal = 0;
	/**
	 * 每页数量
	 */
	private Integer pageSize = 10;
	/**
	 * 当前页数
	 */
	private Integer pageNum = 1;
	/**
	 * 页面数据
	 */
	private List<T> listData;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public List<T> getListData() {
		return listData;
	}

	public void setListData(List<T> listData) {
		this.listData = listData;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int total,int pageSize) {
		if(pageSize>0){
			int num = total%pageSize;
			if(num>0){
				this.pageTotal = (total/pageSize)+1;
			}else{
				this.pageTotal = (total/pageSize);
			}
		}else{
			this.pageTotal = 0;
		}
	}
	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = this.getPageTotal();
	}
	
	
}
