/*
 * http://www.digione.cn
 */
package com.esuper.tsas.seller.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.esuper.tsas.product.entity.Product;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 店铺
 * 
 * @author liaozc@digione.com
 * @date 2013-4-15
 */
@Entity
public class Shop extends BaseEntity {
	
	private static final long serialVersionUID = 4306982378976395475L;
	
	/**
	 * 实体的主键
	 */
	private Long id;
	
	/**
	 * 店铺对应的旺旺ID
	 */
	private String wwId;
	
	/**
	 * 店铺名称
	 */
	private String shopName;
	
	/**
	 * 店铺ID，淘宝系统的ID
	 */
	private String shopId;
	
	/**
	 * 店铺类型，集市/天猫
	 */
	private ShopType shopType;
	
	/**
	 * 店铺的访问地址
	 */
	private String linkAddress;
	
	/**
	 * 该店铺对应的卖家
	 */
	private Seller seller;
	
	/**
	 * 店铺所有的产品（包括上架下架）
	 */
	private Set<Product> products = new HashSet<Product>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(length = 20, nullable = false, unique = true)
	public String getWwId() {
		return wwId;
	}
	
	
	public void setWwId(String wwId) {
		this.wwId = wwId;
	}
	
	
	@Column(length = 20, nullable = false)
	public String getShopName() {
		return shopName;
	}
	
	
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	
	
	@Column(length = 30)
	public String getShopId() {
		return shopId;
	}
	
	
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	
	
	@Enumerated(EnumType.STRING)
	@Column(length = 2)
	public ShopType getShopType() {
		return shopType;
	}
	
	
	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}
	
	
	@Column(length = 50)
	public String getLinkAddress() {
		return linkAddress;
	}
	
	
	public void setLinkAddress(String linkAddress) {
		this.linkAddress = linkAddress;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sellerId")
	public Seller getSeller() {
		return seller;
	}
	
	
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "shop_product", joinColumns = @JoinColumn(name = "shopId"), inverseJoinColumns = @JoinColumn(name = "productId"))
	public Set<Product> getProducts() {
		return products;
	}
	
	
	public void setProducts(Set<Product> products) {
		this.products = products;
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
		Shop other = (Shop) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
