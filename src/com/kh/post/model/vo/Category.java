package com.kh.post.model.vo;

public class Category {

		private int postCatNo; //	POST_CAT_NO	NUMBER(10,0)
		private	String categoryName;	//	CATEGORY_NAME	VARCHAR2(50 BYTE)
		
		

		
		public Category(int postCatNo, String categoryName) {
			super();
			this.postCatNo = postCatNo;
			this.categoryName = categoryName;
		}
		

		public int getPostCatNo() {
			return postCatNo;
		}
		public void setPostCatNo(int postCatNo) {
			this.postCatNo = postCatNo;
		}
		public String getCategoryName() {
			return categoryName;
		}
		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}


		@Override
		public String toString() {
			return "Category [postCatNo=" + postCatNo + ", categoryName=" + categoryName + "]";
		}
		
		
		
}
