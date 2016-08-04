package com.gk.vo;

public class sampleVO {

	int srNO;
	String code;
	String name;
	String mobile;
	String view;
	
	public sampleVO(int srNO,String code,String name,String mobile,String view)
	{
		this.code=code;
		this.name=name;
		this.mobile=mobile;
	}

	public int getSrNO() {
		return srNO;
	}

	public void setSrNO(int srNO) {
		this.srNO = srNO;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}
}
