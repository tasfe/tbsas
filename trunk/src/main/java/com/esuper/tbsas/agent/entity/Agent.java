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
package com.esuper.tbsas.agent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.esuper.tbsas.logistics.entity.ReturnAddress;
import com.esuper.tbsas.logistics.entity.ShipAddress;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 代理商/代销商
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-16
 */
@Entity
public class Agent extends BaseEntity {
	
	private static final long serialVersionUID = -5723469870848073496L;
	
	/**
	 * 实体的主键
	 */
	private Long id;
	
	/**
	 * 代理商名称
	 */
	private String name;
	
	/**
	 * 发货地址
	 */
	private ShipAddress shipAddress;
	
	/**
	 * 退货地址
	 */
	private ReturnAddress returnAddress;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(length = 50)
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shipAddId")
	public ShipAddress getShipAddress() {
		return shipAddress;
	}
	
	
	public void setShipAddress(ShipAddress shipAddress) {
		this.shipAddress = shipAddress;
	}
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "returnAddId")
	public ReturnAddress getReturnAddress() {
		return returnAddress;
	}
	
	
	public void setReturnAddress(ReturnAddress returnAddress) {
		this.returnAddress = returnAddress;
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
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
