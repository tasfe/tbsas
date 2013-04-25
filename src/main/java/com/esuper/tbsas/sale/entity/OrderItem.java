/*
 * http://www.digione.cn
 */
package com.esuper.tbsas.sale.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.esuper.tsas.product.entity.Product;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 订单项
 * 
 * @author liaozc@digione.com
 * @date 2013-4-16
 */
@Entity
public class OrderItem extends BaseEntity {
	
	private static final long serialVersionUID = -2793478803840526090L;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 对应的产品
	 */
	private Product product;
	
	/**
	 * 数量
	 */
	private Integer quantity = Integer.valueOf(1);
	
	/**
	 * 所属订单
	 */
	private Order order;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	public Product getProduct() {
		return product;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	@Column(length = 5, nullable = false)
	public Integer getQuantity() {
		return quantity;
	}
	
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderId")
	public Order getOrder() {
		return order;
	}
	
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
