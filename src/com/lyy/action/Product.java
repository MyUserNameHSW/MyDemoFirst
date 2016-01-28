package com.lyy.action;

public class Product {
	private int p_id;
	private String name;
	private String depict;
	private String type;
	private double price;
	private String img;
	private int buy_num;
	private int col_num;
	private String phone;
    private int PS2_id;
	public Product(int p_id, String name, String depict, String type, double price, String img, int buy_num,
			int col_num, String phone,int PS2_id) {
		super();
		this.p_id = p_id;
		this.name = name;
		this.depict = depict;
		this.type = type;
		this.price = price;
		this.img = img;
		this.buy_num = buy_num;
		this.col_num = col_num;
		this.phone = phone;
		this.PS2_id = PS2_id;
	}



	public int getPS2_id() {
		return PS2_id;
	}



	public void setPS2_id(int pS2_id) {
		PS2_id = pS2_id;
	}



	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepict() {
		return depict;
	}

	public void setDepict(String depict) {
		this.depict = depict;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public int getCol_num() {
		return col_num;
	}

	public void setCol_num(int col_num) {
		this.col_num = col_num;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
