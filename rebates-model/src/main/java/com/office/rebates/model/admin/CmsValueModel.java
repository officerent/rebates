package com.soho3q.cms.model.admin;

import java.util.Date;

/**
 * 
 * @author pangweidong	
 * @version 1.0 (2015-10-19)
 */
public class CmsValueModel {

	private Long valueId;

    private String channelName;

    private String cmsKey;

    private String language;

    private String client;

    private String os;

    private String businessId;

    private String cmsValue;

    private Byte enabled;

    private String creator;

    private Date createTime;

    private String updater;

    private Date lastUpdateTime;
    
    private String description;

    public Long getValueId() {
        return valueId;
    }

    public void setValueId(Long valueId) {
        this.valueId = valueId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getCmsKey() {
        return cmsKey;
    }

    public void setCmsKey(String cmsKey) {
        this.cmsKey = cmsKey == null ? null : cmsKey.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client == null ? null : client.trim();
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public String getCmsValue() {
        return cmsValue;
    }

    public void setCmsValue(String cmsValue) {
        this.cmsValue = cmsValue == null ? null : cmsValue.trim();
    }

    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
