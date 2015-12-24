package com.soho3q.cms.model.admin;

import java.util.Date;

/**
 *  key 实体类
 *  ZLL  2015-10-14
 */
public class CmsKeyModel {
	
	private Long keyId;

    private Long channelId;
    
    private String channelName;

    private Long tagId;
    
    private String tagName;
    
    private String tagColor;

    private String cmsKey;

    private String name;

    private String description;

    private String keyType;

    private Byte enabled;
    /** 待更新的状态 **/
    private Byte enabledSub;

    private String creator;

    private Date createTime;

    private String updater;

    private Date lastUpdateTime;
    
	public Long getKeyId() {
		return keyId;
	}

	public void setKeyId(Long keyId) {
		this.keyId = keyId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getCmsKey() {
		return cmsKey;
	}

	public void setCmsKey(String cmsKey) {
		this.cmsKey = cmsKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyType() {
		return keyType;
	}

	public void setKeyType(String keyType) {
		this.keyType = keyType;
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
		this.creator = creator;
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
		this.updater = updater;
	}

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Byte getEnabledSub() {
		return enabledSub;
	}

	public void setEnabledSub(Byte enabledSub) {
		this.enabledSub = enabledSub;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagColor() {
		return tagColor;
	}

	public void setTagColor(String tagColor) {
		this.tagColor = tagColor;
	}
	
}
