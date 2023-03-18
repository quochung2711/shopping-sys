package com.dqh.shopping.Entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name="order_id", nullable = false)
	private int orderId;
	
	@Column(name="order_product_id", nullable = false)
	private int productId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public OrderPk(int orderId, int productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(orderId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderPk other = (OrderPk) obj;
		return orderId == other.orderId && productId == other.productId;
	}
	
	
}