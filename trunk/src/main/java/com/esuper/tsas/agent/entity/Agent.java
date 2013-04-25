/*
 * http://www.digione.cn
 */
package com.esuper.tsas.agent.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.esuper.tsas.logistics.entity.ReturnAddress;
import com.esuper.tsas.logistics.entity.ShipAddress;
import com.esuper.tsas.product.entity.Product;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 代理商/代销商
 * 
 * @author liaozc@digione.com
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
	 * 代理商所有的产品
	 */
	private Set<Product> products = new HashSet<Product>();
	
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
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "agent_product", joinColumns = @JoinColumn(name = "agentId"), inverseJoinColumns = @JoinColumn(name = "productId"))
	public Set<Product> getProducts() {
		return products;
	}
	
	
	public void setProducts(Set<Product> products) {
		this.products = products;
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
