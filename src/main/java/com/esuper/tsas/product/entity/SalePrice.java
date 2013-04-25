/*
 * http://www.digione.cn
 */
package com.esuper.tsas.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jqd.framework.core.entity.BaseEntity;

/**
 * 销售价
 * 
 * @author liaozc@digione.com
 * @date 2013-4-16
 */
public class SalePrice extends BaseEntity {
	
	private static final long serialVersionUID = 1658908915553856095L;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 产品
	 */
	private Product product;
	
	/**
	 * 价格，销售价格
	 */
	private Double price;
	
	/**
	 * 开始时间，以这个价格销售的开始时间
	 */
	private Date beginTime;
	
	
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
	
	
	@Column(length = 6, precision = 2)
	public Double getPrice() {
		return price;
	}
	
	
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBeginTime() {
		return beginTime;
	}
	
	
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
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
		SalePrice other = (SalePrice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
