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
import javax.persistence.ManyToOne;

import com.esuper.tbsas.product.entity.Product;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 供应商产品关联关系
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-25
 */
@Entity
public class AgentProducts extends BaseEntity {
	
	private static final long serialVersionUID = -7642747676746341421L;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 供应商
	 */
	private Agent agent;
	
	/**
	 * 产品
	 */
	private Product product;
	
	/**
	 * 成本价
	 */
	private Double costPrice;
	
	/**
	 * 商家编码
	 */
	private String productNo;
	
	
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
	@JoinColumn(name = "agentId")
	public Agent getAgent() {
		return agent;
	}
	
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productId")
	public Product getProduct() {
		return product;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	@Column(length = 8, precision = 2)
	public Double getCostPrice() {
		return costPrice;
	}
	
	
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	
	
	@Column(length = 20)
	public String getProductNo() {
		return productNo;
	}
	
	
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	
}
