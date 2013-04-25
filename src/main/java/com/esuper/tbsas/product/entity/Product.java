/*
 * http://www.digione.cn
 */
package com.esuper.tbsas.product.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.esuper.tbsas.agent.entity.Agent;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 产品
 * 
 * @author liaozc@digione.com
 * @date 2013-4-12
 */
@Entity
public class Product extends BaseEntity {
	
	private static final long serialVersionUID = 7991375547523580591L;
	
	/**
	 * 实体的主键
	 */
	private Long id;
	
	/**
	 * 产品ID，对应产品在淘宝系统的ID
	 */
	private String productId;
	
	/**
	 * 产品名称
	 */
	private String productName;
	
	/**
	 * 产品商家编号，该编号为主店铺的商家编码
	 */
	private String productSellerNo;
	
	/**
	 * 产品编号，该编号为当前产品在主供应商处的编号
	 */
	private String productNo;
	
	/**
	 * 产品主图路径
	 */
	private String mainPhotoLocation;
	
	/**
	 * 产品销售价格
	 */
	private Double salePrice;
	
	/**
	 * 产品的成本价格，该价格为产品对应主供应商的成本价
	 */
	private Double costPrcie;
	
	/**
	 * 每产品都会存在一个主要的供应商
	 */
	private Agent defaultAgent;
	
	/**
	 * 一个产品，可以由多个供应商供货
	 */
	private Set<Agent> agents = new HashSet<Agent>();
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(length = 25)
	public String getProductId() {
		return productId;
	}
	
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
	@Column(length = 30, nullable = false)
	public String getProductName() {
		return productName;
	}
	
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	@Column(length = 20)
	public String getProductSellerNo() {
		return productSellerNo;
	}
	
	
	public void setProductSellerNo(String productSellerNo) {
		this.productSellerNo = productSellerNo;
	}
	
	
	@Column(length = 20)
	public String getProductNo() {
		return productNo;
	}
	
	
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	
	
	@Column(length = 150)
	public String getMainPhotoLocation() {
		return mainPhotoLocation;
	}
	
	
	public void setMainPhotoLocation(String mainPhotoLocation) {
		this.mainPhotoLocation = mainPhotoLocation;
	}
	
	
	@Column(length = 8, precision = 2)
	public Double getSalePrice() {
		return salePrice;
	}
	
	
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	
	@Column(length = 8, precision = 2)
	public Double getCostPrcie() {
		return costPrcie;
	}
	
	
	public void setCostPrcie(Double costPrcie) {
		this.costPrcie = costPrcie;
	}
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "defaultAgentId")
	public Agent getDefaultAgent() {
		return defaultAgent;
	}
	
	
	public void setDefaultAgent(Agent defaultAgent) {
		this.defaultAgent = defaultAgent;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
	public Set<Agent> getAgents() {
		return agents;
	}
	
	
	public void setAgents(Set<Agent> agents) {
		this.agents = agents;
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
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
