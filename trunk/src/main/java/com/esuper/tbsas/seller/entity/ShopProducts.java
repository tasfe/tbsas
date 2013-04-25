/*
 * http://www.digione.cn
 */
package com.esuper.tbsas.seller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.esuper.tbsas.product.entity.Product;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 产品和店铺的关联关系管理
 * 
 * @author liaozc@digione.com
 * @date 2013-4-25
 */
@Entity
public class ShopProducts extends BaseEntity {
	
	private static final long serialVersionUID = 590828729595967981L;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 店铺
	 */
	private Shop shop;
	
	/**
	 * 产品
	 */
	private Product product;
	
	/**
	 * 销售价格
	 */
	private Double salePrice;
	
	/**
	 * 商家编码
	 */
	private String sellerProudctNo;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "shopId")
	public Shop getShop() {
		return shop;
	}
	
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId")
	public Product getProduct() {
		return product;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	@Column(length = 8, precision = 2, nullable = false)
	public Double getSalePrice() {
		return salePrice;
	}
	
	
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	
	@Column(length = 20, nullable = false)
	public String getSellerProudctNo() {
		return sellerProudctNo;
	}
	
	
	public void setSellerProudctNo(String sellerProudctNo) {
		this.sellerProudctNo = sellerProudctNo;
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
		ShopProducts other = (ShopProducts) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
