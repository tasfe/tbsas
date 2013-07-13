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
package com.esuper.tbsas.logistics.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.esuper.tbsas.buyer.entity.Buyer;

/**
 * 收货地址
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-17
 */
@Entity
@DiscriminatorValue("C")
public class ConsigneeAddress extends LogisticsAddress {
	
	private static final long serialVersionUID = 354665113911887923L;
	
	/**
	 * 所属买家
	 */
	private Buyer buyer;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "byerId")
	public Buyer getBuyer() {
		return buyer;
	}
	
	
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
}
