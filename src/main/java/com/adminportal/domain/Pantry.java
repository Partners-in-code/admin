//package com.myPantry.domain;
//
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="pantry")
//public class Pantry {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private Long userProductId;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="user_id")
//	private User user;
//	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="product_id")
//	private Product product;
//	
//	public Pantry(){}
//	
//	public Pantry(User user, Product product) {
//		this.user = user;
//		this.product = product;
//	}
//
//
//	public Long getPantryId() {
//		return userProductId;
//	}
//
//
//	public void setPantryId(Long userProductId) {
//		this.userProductId = userProductId;
//	}
//
//
//	public User getUser() {
//		return user;
//	}
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//
//	public Product getProduct() {
//		return product;
//	}
//
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}
//	
//	
//}
