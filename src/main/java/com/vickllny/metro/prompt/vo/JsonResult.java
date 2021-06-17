package com.vickllny.metro.prompt.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonResult<T> {
	
	public static final String STATUS_SUCCESS = "success";
	public static final String STATUS_ERROR = "error";
	
	public static final int CODE_SUCCESS = 0;
	public static final int CODE_ERROR = -1;
	
	private String message;
	private T data;
	private String status;
	private int code;
	
	public JsonResult(){
		
	}

	public String getMessage() {
		return message;
	}

	public JsonResult<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public T getData() {
		return data;
	}

	public JsonResult<T> setData(T data) {
		this.data = data;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public JsonResult<T> setStatus(String status) {
		this.status = status;
		return this;
	}
	
	public JsonResult<T> success(){
		this.status = STATUS_SUCCESS;
		this.message = "操作成功";
		this.code = CODE_SUCCESS;
		return this;
	}
	
	public JsonResult<T> success(String message){
		this.status = STATUS_SUCCESS;
		this.message = message;
		this.code = CODE_SUCCESS;
		return this;
	}
	
	public JsonResult<T> error(){
		this.status = STATUS_ERROR;
		this.message = "操作失败!";
		this.code = CODE_ERROR;
		return this;
	}
	
	public JsonResult<T> error(String message){
		this.status = STATUS_ERROR;
		this.message = message;
		return this;
	}

	public JsonResult<T> data(T data) {
		this.data = data;
		return this;
	}
	
	public int getCode() {
		return code;
	}

	public JsonResult<T> setCode(int code) {
		this.code = code;
		return this;
	}

	@JsonIgnore
	public boolean isSuccess(){
		if (null != this.status) {
			if (STATUS_SUCCESS.equals(this.status)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
