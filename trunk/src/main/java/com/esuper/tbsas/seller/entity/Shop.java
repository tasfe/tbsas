/*
 * Copyright 2012-2015 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.esuper.tbsas.seller.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jqd.framework.core.entity.BaseEntity;

/**
 * 店铺
 * 
 * @author liaozhicheng.cn@gmail.com
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
