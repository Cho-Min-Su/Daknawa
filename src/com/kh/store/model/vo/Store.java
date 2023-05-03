package com.kh.store.model.vo;

public class Store {
	
	private int storeNo;		  
	private String storeName;		
	private String storeAddress;	
	private String storePhone;	
	private String storeTime; 		
	private String brandNo;     	
	private String brandName;
	private int startRow;	
	private int endRow;
	
	public Store( ) { }

	public Store(int storeNo, String storeName, String storeAddress, String storePhone, String storeTime, String brandNo) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storeAddress = storeAddress;
		this.storePhone = storePhone;
		this.storeTime = storeTime;
		this.brandNo = brandNo;
	}
	
	
	public Store(String brandName) {
		super();
		this.brandName = brandName;
	}

	public Store(String storeName, String brandName, int startRow, int endRow) {
		super();
		this.storeName = storeName;
		this.brandName = brandName;
		this.startRow = startRow;
		this.endRow = endRow;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStorePhone() {
		return storePhone;
	}

	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public String getStoreTime() {
		return storeTime;
	}

	public void setStoreTime(String storeTime) {
		this.storeTime = storeTime;
	}

	public String getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(String brandNo) {
		this.brandNo = brandNo;
	}
	
	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
	public int getStartRow() {
		return startRow;
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	@Override
	public String toString() {
		return "Store [storeNo=" + storeNo + ", storeName=" + storeName + ", storeAddress=" + storeAddress
				+ ", storePhone=" + storePhone + ", storeTime=" + storeTime + ", brandNo=" + brandNo 
				+ ", brandName=" + brandName + ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
	
	
	
	
	

}
