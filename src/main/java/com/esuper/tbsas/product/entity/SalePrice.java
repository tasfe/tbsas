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
package com.esuper.tbsas.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esuper.tbsas.seller.entity.ShopProducts;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 销售价
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-16
 */
@Entity
public class SalePrice extends BaseEntity {
	
	private static final long serialVersionUID = 1658908915553856095L;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 店铺产品
	 */
	private ShopProducts shopProduct;
	
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
	@JoinColumn(name = "spId")
	public ShopProducts getShopProduct() {
		return shopProduct;
	}
	
	
	public void setShopProduct(ShopProducts shopProduct) {
		this.shopProduct = shopProduct;
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
