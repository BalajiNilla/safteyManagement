package com.SafteyManagementSystem.project.Exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
public class APIerrors {

	String msg;
	String details;
	HttpStatus status;
	LocalDateTime timestamp;
	public APIerrors(String msg, String details, HttpStatus status, LocalDateTime timestamp) {
		super();
		this.msg = msg;
		this.details = details;
		this.status = status;
		this.timestamp = timestamp;
	}
	public APIerrors() {
		super();
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
