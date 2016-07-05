package com.office.rebates.dal.dataobj;

import java.math.BigDecimal;
import java.util.Date;

public class RebatesBonusMock {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_bonus_mock.bonus_mock_id
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    private Long bonusMockId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_bonus_mock.customer_name
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    private String customerName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_bonus_mock.customer_mobile
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    private String customerMobile;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_bonus_mock.rebates_amount
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    private BigDecimal rebatesAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column rebates_bonus_mock.last_update_time
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    private Date lastUpdateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_bonus_mock.bonus_mock_id
     *
     * @return the value of rebates_bonus_mock.bonus_mock_id
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public Long getBonusMockId() {
        return bonusMockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_bonus_mock.bonus_mock_id
     *
     * @param bonusMockId the value for rebates_bonus_mock.bonus_mock_id
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public void setBonusMockId(Long bonusMockId) {
        this.bonusMockId = bonusMockId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_bonus_mock.customer_name
     *
     * @return the value of rebates_bonus_mock.customer_name
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_bonus_mock.customer_name
     *
     * @param customerName the value for rebates_bonus_mock.customer_name
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_bonus_mock.customer_mobile
     *
     * @return the value of rebates_bonus_mock.customer_mobile
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public String getCustomerMobile() {
        return customerMobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_bonus_mock.customer_mobile
     *
     * @param customerMobile the value for rebates_bonus_mock.customer_mobile
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public void setCustomerMobile(String customerMobile) {
        this.customerMobile = customerMobile == null ? null : customerMobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_bonus_mock.rebates_amount
     *
     * @return the value of rebates_bonus_mock.rebates_amount
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public BigDecimal getRebatesAmount() {
        return rebatesAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_bonus_mock.rebates_amount
     *
     * @param rebatesAmount the value for rebates_bonus_mock.rebates_amount
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public void setRebatesAmount(BigDecimal rebatesAmount) {
        this.rebatesAmount = rebatesAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column rebates_bonus_mock.last_update_time
     *
     * @return the value of rebates_bonus_mock.last_update_time
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column rebates_bonus_mock.last_update_time
     *
     * @param lastUpdateTime the value for rebates_bonus_mock.last_update_time
     *
     * @mbggenerated Tue Jul 05 14:55:04 CST 2016
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}