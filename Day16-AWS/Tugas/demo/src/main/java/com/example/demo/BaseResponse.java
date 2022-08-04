package com.example.demo;

public class BaseResponse {
	  
    private String status;
    private Integer code;
    private String msg;
  
    public String getStatus() {
        return status;
    }
  
    public void setStatus(String status) {
        this.status = status;
    }
  
    public Integer getCode() {
        return code;
    }
  
    public void setCode(Integer code) {
        this.code = code;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
  
}