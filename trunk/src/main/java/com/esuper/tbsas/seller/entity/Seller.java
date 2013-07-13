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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jqd.framework.core.entity.BaseEntity;

/**
 * 卖家
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-15
 */
@Entity
public class Seller extends BaseEntity {
	
	private static final long serialVersionUID = -8698678434207049570L;
	
	/**
	 * 实体的主键
	 */
	private Long id;
	
	/**
	 * 卖家名称
	 */
	private String sellerName;
	
	/**
	 * 卖家手机号
	 */
	private String sellerMobile;
	
	/**
	 * 卖家拥有的店铺
	 */
	private Set<Shop> ownShops = new HashSet<Shop>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(length = 20, nullable = false)
	public String getSellerName() {
		return sellerName;
	}
	
	
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	
	@Column(length = 15)
	public String getSellerMobile() {
		return sellerMobile;
	}
	
	
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "seller")
	public Set<Shop> getOwnShops() {
		return ownShops;
	}
	
	
	public void setOwnShops(Set<Shop> ownShops) {
		this.ownShops = ownShops;
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
		Seller other = (Seller) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
