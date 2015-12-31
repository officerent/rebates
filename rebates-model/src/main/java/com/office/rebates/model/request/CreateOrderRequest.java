package com.office.rebates.model.request;

import java.util.List;

import com.office.rebates.model.OrderItem;

public class CreateOrderRequest {
	public String getCustomerMobile() {
		return customerMobile;
	}
	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerCompany() {
		return customerCompany;
	}
	public void setCustomerCompany(String customerCompany) {
		this.customerCompany = customerCompany;
	}
	public String getCustomerAlipay() {
		return customerAlipay;
	}
	public void setCustomerAlipay(String customerAlipay) {
		this.customerAlipay = customerAlipay;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public Integer getPeriodMonth() {
		return periodMonth;
	}
	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}
	public Integer getPeriodWeek() {
		return periodWeek;
	}
	public void setPeriodWeek(Integer periodWeek) {
		this.periodWeek = periodWeek;
	}
	public Integer getLeaseAmount() {
		return leaseAmount;
	}
	public void setLeaseAmount(Integer leaseAmount) {
		this.leaseAmount = leaseAmount;
	}
	public Integer getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(Integer depositAmount) {
		this.depositAmount = depositAmount;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	private String customerMobile;
	private String customerName;
	private String customerCompany;
	private String customerAlipay;
	private String projectId;
	private String projectName;
	private String checkInDate; // 'yyyy-mm-dd'
	private String checkOutDate;
	private Integer periodMonth;
	private Integer periodWeek;
	private Integer leaseAmount;
	private Integer depositAmount;
	private List<OrderItem> orderItems;
	
}
