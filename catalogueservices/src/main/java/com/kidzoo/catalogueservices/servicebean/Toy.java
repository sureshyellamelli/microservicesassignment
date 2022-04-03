package com.kidzoo.catalogueservices.servicebean;




public class Toy {
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private Float price;
	private Long age;
	private String name;
	private String imageurl;
	private String status;
	
	@Override
	  public String toString() {
	    return String.format(
	        "Toys[id=%d, name='%s', price=%f, age=%d, imageurl='%s', status= '%s']",
	        id, name, price,age,imageurl,status);
	  }
}
