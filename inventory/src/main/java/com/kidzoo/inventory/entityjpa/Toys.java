
package com.kidzoo.inventory.entityjpa;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Toys {

	@Id
	private Long id;
	private Float price;
	private Long age;
	private String name;
	private String imageurl;
	private String status;
	
	protected Toys() {}

	public Toys(Long id, Float price, Long age, String name, String imageurl, String status) {
		super();
		this.id = id;
		this.price = price;
		this.age = age;
		this.name = name;
		this.imageurl = imageurl;
		this.status = status;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the age
	 */
	public Long getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Long age) {
		this.age = age;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the imageurl
	 */
	public String getImageurl() {
		return imageurl;
	}

	/**
	 * @param imageurl the imageurl to set
	 */
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	  public String toString() {
	    return String.format(
	        "Toys[id=%d, name='%s', price=%f, age=%d, imageurl='%s', status= '%s']",
	        id, name, price,age,imageurl,status);
	  }

}
