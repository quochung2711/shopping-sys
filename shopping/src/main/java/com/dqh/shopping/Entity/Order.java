package com.dqh.shopping.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="orderproduct")
public class Order {
	/**
	 * 
	 */


	@EmbeddedId
	private OrderPk orderPk;
	
	@Column(name="order_username")
	private String orderUsername;
	
	@Column(name="address")
	private String address;
	
	@Column(name="order_quantity")
	private int orderQuantity;

	@OneToOne
	@JoinColumn(name="order_product_id", referencedColumnName="product_id",insertable=false, updatable=false)
	@MapsId("product_id")
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	public OrderPk getOrderPk() {
		return orderPk;
	}

	public void setOrderPk(OrderPk orderPk) {
		this.orderPk = orderPk;
	}

	public String getOrderUsername() {
		return orderUsername;
	}

	public void setOrderUsername(String orderUsername) {
		this.orderUsername = orderUsername;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	
}

