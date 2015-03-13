package com.zhuc.cmps;

public abstract class CmpsResult {

	/**
	 * 执行是否成功
	 */
	public boolean isSuccess;

	/**
	 * 错误信息
	 */
	public String errorMsg;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
