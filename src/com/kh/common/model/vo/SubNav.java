package com.kh.common.model.vo;

public class SubNav {

	private String title1;
	private String title1Addr;
	private String title2;
	private String title2Addr;
	private String title3;
	private String active1;
	private String active2;
	private String active3;
	private String active4;
	
	public SubNav() { }

	public SubNav(String title1, String title1Addr, String title2, String title2Addr, String title3, String active1,
			String active2, String active3, String active4) {
		super();
		this.title1 = title1;
		this.title1Addr = title1Addr;
		this.title2 = title2;
		this.title2Addr = title2Addr;
		this.title3 = title3;
		this.active1 = active1;
		this.active2 = active2;
		this.active3 = active3;
		this.active4 = active4;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getTitle1Addr() {
		return title1Addr;
	}

	public void setTitle1Addr(String title1Addr) {
		this.title1Addr = title1Addr;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getTitle2Addr() {
		return title2Addr;
	}

	public void setTitle2Addr(String title2Addr) {
		this.title2Addr = title2Addr;
	}

	public String getTitle3() {
		return title3;
	}

	public void setTitle3(String title3) {
		this.title3 = title3;
	}

	public String getActive1() {
		return active1;
	}

	public void setActive1(String active1) {
		this.active1 = active1;
	}

	public String getActive2() {
		return active2;
	}

	public void setActive2(String active2) {
		this.active2 = active2;
	}

	public String getActive3() {
		return active3;
	}

	public void setActive3(String active3) {
		this.active3 = active3;
	}

	public String getActive4() {
		return active4;
	}

	public void setActive4(String active4) {
		this.active4 = active4;
	}

	@Override
	public String toString() {
		return "SubNav [title1=" + title1 + ", title1Addr=" + title1Addr + ", title2=" + title2 + ", title2Addr="
				+ title2Addr + ", title3=" + title3 + ", active1=" + active1 + ", active2=" + active2 + ", active3="
				+ active3 + ", active4=" + active4 + "]";
	}
		
}
