package com.heroes.dto;

public class JSONResult {
	private String result;
	private String message;
	private Object data;
	private int state;

	private JSONResult(String result, String message, Object data, int state) {
		this.result = result;
		this.message = message;
		this.data = data;
		this.state = state;
	}

	private JSONResult(String result, String message, Object data) {
		this.result = result;
		this.message = message;
		this.data = data;
	}

	private JSONResult(String message, int state) {
		this.message = message;
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static JSONResult success(Object data) {
		return new JSONResult("success", null, data);
	}

	public static JSONResult success(Object data, String message) {
		return new JSONResult("success", message, data);
	}

	public static JSONResult success(String message, int state) {
		return new JSONResult("success", message, "", state);
	}

	public static JSONResult fail(Object data, String message) {
		return new JSONResult("fail", message, data);
	}

	public static JSONResult success(Object data, String message, int state) {
		return new JSONResult("success", message, data, state);
	}

	public static JSONResult fail(Object data, String message, int state) {
		return new JSONResult("fail", message, data, state);
	}

	public static JSONResult fail(String message) {
		return new JSONResult("fail", message, null);
	}

	public static JSONResult fail(String message, int state) {
		return new JSONResult(message, state);
	}

	public String getResult() {
		return result;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
}
