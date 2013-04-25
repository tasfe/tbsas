/*
 * http://www.digione.cn
 */
package com.esuper.tbsas.agent.entity;

import javax.persistence.Entity;

import com.esuper.tbsas.product.entity.Product;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * TODO
 * 
 * @author liaozc@digione.com
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
	
	
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Agent getAgent() {
		return agent;
	}
	
	
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	
	
	public Product getProduct() {
		return product;
	}
	
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	public Double getCostPrice() {
		return costPrice;
	}
	
	
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	
	
	public String getProductNo() {
		return productNo;
	}
	
	
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	
}
