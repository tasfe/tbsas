/*
 * http://www.digione.cn
 */
package com.esuper.tbsas.product.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.esuper.tbsas.agent.entity.Agent;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 成本价
 * 
 * @author liaozc@digione.com
 * @date 2013-4-16
 */
@Entity
public class CostPrice extends BaseEntity {
	
	private static final long serialVersionUID = -6995268654721559860L;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 供应商/代理商
	 */
	private Agent agent;
	
	/**
	 * 产品
	 */
	private Product product;
	
	/**
	 * 价格
	 */
	private Double price;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
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
	
	
	public Double getPrice() {
		return price;
	}
	
	
	public void setPrice(Double price) {
		this.price = price;
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
		CostPrice other = (CostPrice) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
