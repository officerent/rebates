package com.soho3q.cms.model.common;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *  ZLL on 2015-10-15.
 */
public class ResultCode {
	
    private String message;
    private Integer status;
    private Object data;
    
    public ResultCode() {
        this.message = "success";
        this.status = 0;
        this.data = null;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
