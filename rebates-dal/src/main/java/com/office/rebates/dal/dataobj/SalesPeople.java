package com.office.rebates.dal.dataobj;

import java.util.Date;

public class SalesPeople {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sales_people.sales_id
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    private Long salesId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sales_people.sales_num
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    private Integer salesNum;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sales_people.user_name
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sales_people.user_password
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    private String userPassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sales_people.create_time
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sales_people.last_update_time
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sales_people.sales_id
     *
     * @return the value of sales_people.sales_id
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public Long getSalesId() {
        return salesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sales_people.sales_id
     *
     * @param salesId the value for sales_people.sales_id
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public void setSalesId(Long salesId) {
        this.salesId = salesId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sales_people.sales_num
     *
     * @return the value of sales_people.sales_num
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public Integer getSalesNum() {
        return salesNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sales_people.sales_num
     *
     * @param salesNum the value for sales_people.sales_num
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public void setSalesNum(Integer salesNum) {
        this.salesNum = salesNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sales_people.user_name
     *
     * @return the value of sales_people.user_name
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sales_people.user_name
     *
     * @param userName the value for sales_people.user_name
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sales_people.user_password
     *
     * @return the value of sales_people.user_password
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sales_people.user_password
     *
     * @param userPassword the value for sales_people.user_password
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sales_people.create_time
     *
     * @return the value of sales_people.create_time
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sales_people.create_time
     *
     * @param createTime the value for sales_people.create_time
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sales_people.last_update_time
     *
     * @return the value of sales_people.last_update_time
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sales_people.last_update_time
     *
     * @param lastUpdateTime the value for sales_people.last_update_time
     *
     * @mbggenerated Tue Mar 08 19:17:55 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}