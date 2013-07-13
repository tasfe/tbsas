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
package com.esuper.tbsas.buyer.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.esuper.tbsas.logistics.entity.ConsigneeAddress;
import com.esuper.tbsas.sale.entity.Order;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 买家
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-16
 */
@Entity
public class Buyer extends BaseEntity {
	
	private static final long serialVersionUID = 4676353382041305212L;
	
	/**
	 * 实体的主键
	 */
	private Long id;
	
	/**
	 * 买家的旺旺ID
	 */
	private String wwId;
	
	/**
	 * 默认收货地址
	 */
	private ConsigneeAddress defaultConsigneeAddress;
	
	/**
	 * 买家下的订单
	 */
	private Set<Order> orders = new HashSet<Order>();
	
	
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
	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "defConAddId")
	public ConsigneeAddress getDefaultConsigneeAddress() {
		return defaultConsigneeAddress;
	}
	
	
	public void setDefaultConsigneeAddress(ConsigneeAddress defaultConsigneeAddress) {
		this.defaultConsigneeAddress = defaultConsigneeAddress;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "buyer")
	public Set<Order> getOrders() {
		return orders;
	}
	
	
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
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
		Buyer other = (Buyer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
