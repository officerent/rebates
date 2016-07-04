package com.office.rebates.dal.dataobj;

import java.util.Date;

public class RebatesOrderItem {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.order_item_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Long orderItemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.order_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Long orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.porject_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private String porjectId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.original_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Integer originalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.final_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Integer finalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.deposit_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Integer depositPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.product_type
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private String productType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.product_sub_type
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private String productSubType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.book_num
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Integer bookNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.total_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Integer totalPrice;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.coupon_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Long couponId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.create_time
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_order_item.last_update_time
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.order_item_id
     *
     * @return the value of rebates_order_item.order_item_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Long getOrderItemId() {
        return orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.order_item_id
     *
     * @param orderItemId the value for rebates_order_item.order_item_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.order_id
     *
     * @return the value of rebates_order_item.order_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.order_id
     *
     * @param orderId the value for rebates_order_item.order_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.porject_id
     *
     * @return the value of rebates_order_item.porject_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public String getPorjectId() {
        return porjectId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.porject_id
     *
     * @param porjectId the value for rebates_order_item.porject_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setPorjectId(String porjectId) {
        this.porjectId = porjectId == null ? null : porjectId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.original_price
     *
     * @return the value of rebates_order_item.original_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Integer getOriginalPrice() {
        return originalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.original_price
     *
     * @param originalPrice the value for rebates_order_item.original_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.final_price
     *
     * @return the value of rebates_order_item.final_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Integer getFinalPrice() {
        return finalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.final_price
     *
     * @param finalPrice the value for rebates_order_item.final_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setFinalPrice(Integer finalPrice) {
        this.finalPrice = finalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.deposit_price
     *
     * @return the value of rebates_order_item.deposit_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Integer getDepositPrice() {
        return depositPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.deposit_price
     *
     * @param depositPrice the value for rebates_order_item.deposit_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setDepositPrice(Integer depositPrice) {
        this.depositPrice = depositPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.product_type
     *
     * @return the value of rebates_order_item.product_type
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public String getProductType() {
        return productType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.product_type
     *
     * @param productType the value for rebates_order_item.product_type
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.product_sub_type
     *
     * @return the value of rebates_order_item.product_sub_type
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public String getProductSubType() {
        return productSubType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.product_sub_type
     *
     * @param productSubType the value for rebates_order_item.product_sub_type
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setProductSubType(String productSubType) {
        this.productSubType = productSubType == null ? null : productSubType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.book_num
     *
     * @return the value of rebates_order_item.book_num
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Integer getBookNum() {
        return bookNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.book_num
     *
     * @param bookNum the value for rebates_order_item.book_num
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.total_price
     *
     * @return the value of rebates_order_item.total_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Integer getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.total_price
     *
     * @param totalPrice the value for rebates_order_item.total_price
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.coupon_id
     *
     * @return the value of rebates_order_item.coupon_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Long getCouponId() {
        return couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.coupon_id
     *
     * @param couponId the value for rebates_order_item.coupon_id
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setCouponId(Long couponId) {
        this.couponId = couponId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.create_time
     *
     * @return the value of rebates_order_item.create_time
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.create_time
     *
     * @param createTime the value for rebates_order_item.create_time
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_order_item.last_update_time
     *
     * @return the value of rebates_order_item.last_update_time
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_order_item.last_update_time
     *
     * @param lastUpdateTime the value for rebates_order_item.last_update_time
     *
     * @mbggenerated Mon Jul 04 16:27:44 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}