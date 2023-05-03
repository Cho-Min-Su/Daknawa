package com.kh.menu.model.vo;

public class Menu {
//	
//	MENU_NO	NUMBER
//	MENU_NAME	VARCHAR2(90 BYTE)
//	MENU_PRICE	NUMBER
//	MENU_CATEGORY	VARCHAR2(90 BYTE)
//	STORE_NO	NUMBER

    private int menuNo;
    private String menuName;
    private int menuPrice;
    private String menuCategory;
    private int brandNo;
    private String menuDesc;
    private String Img;
    private int view;
    private String brandName;


	public Menu() {}
	
    public Menu(int menuNo, String menuName, int menuPrice, String menuCategory, int brandNo, String menuDesc,
			String img, int view, String brandName) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCategory = menuCategory;
		this.brandNo = brandNo;
		this.menuDesc = menuDesc;
		Img = img;
		this.view = view;
		this.brandName = brandName;
	}

	

	public Menu(int menuNo, String menuName, int menuPrice, String menuCategory, int brandNo, String menuDesc) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCategory = menuCategory;
		this.brandNo = brandNo;
		this.menuDesc = menuDesc;
	}
	
	public Menu(int menuNo, String menuName, int menuPrice, String menuCategory, int brandNo, String menuDesc,
			String brandName) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCategory = menuCategory;
		this.brandNo = brandNo;
		this.menuDesc = menuDesc;
		this.brandName = brandName;
	}

	public Menu(int menuNo, String menuName, int menuPrice, String menuCategory, int brandNo, String menuDesc,
			String img, String brandName) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCategory = menuCategory;
		this.brandNo = brandNo;
		this.menuDesc = menuDesc;
		Img = img;
		this.brandName = brandName;
	}

	

	public Menu(int menuNo, String menuName, int menuPrice, String menuCategory, int brandNo, String menuDesc, int view,
			String brandName) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCategory = menuCategory;
		this.brandNo = brandNo;
		this.menuDesc = menuDesc;
		this.view = view;
		this.brandName = brandName;
	}

	public Menu(int menuNo, String menuName, int menuPrice, String menuCategory, int brandNo, String menuDesc,
			String img, int view) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
		this.menuCategory = menuCategory;
		this.brandNo = brandNo;
		this.menuDesc = menuDesc;
		this.Img = img;
		this.view = view;
	}
	
	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}

	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

	public String getMenuCategory() {
		return menuCategory;
	}

	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
	}

	public int getBrandNo() {
		return brandNo;
	}

	public void setBrandNo(int brandNo) {
		this.brandNo = brandNo;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "Menu [menuNo=" + menuNo + ", menuName=" + menuName + ", menuPrice=" + menuPrice + ", menuCategory="
				+ menuCategory + ", brandNo=" + brandNo + ", menuDesc=" + menuDesc + ", Img=" + Img + ", view=" + view
				+ ", brandName=" + brandName + "]";
	}

}
    
	