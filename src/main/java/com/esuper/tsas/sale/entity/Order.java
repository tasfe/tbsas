/*
 * http://www.digione.cn
 */
package com.esuper.tsas.sale.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.esuper.tsas.buyer.entity.Buyer;
import com.esuper.tsas.logistics.entity.ConsigneeAddress;
import com.esuper.tsas.seller.entity.Shop;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 订单
 * 
 * @author liaozc@digione.com
 * @date 2013-4-16
 */
@Entity
public class Order extends BaseEntity {
	
	private static final long serialVersionUID = 5224204288884181019L;
	
	/**
	 * 实体的主键
	 */
	private Long id;
	
	/**
	 * 销售订单号，对应淘宝系统中的卖家订单号
	 */
	private String saleOrderNo;
	
	/**
	 * 订单创建时间，指在淘宝系统的创建时间
	 */
	private Date createTime;
	
	/**
	 * 订单销售价格，买家实付价格
	 */
	private Double salePrice;
	
	/**
	 * 订单成本价格
	 */
	private Double costPrice;
	
	/**
	 * 订单子项
	 */
	private Set<OrderItem> items = new HashSet<OrderItem>();
	
	/**
	 * 下订单的买家
	 */
	private Buyer buyer;
	
	/**
	 * 卖出订单的店铺
	 */
	private Shop shop;
	
	/**
	 * 订单的收货地址
	 */
	private ConsigneeAddress consigneeAddress;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(length = 30, nullable = false, unique = true)
	public String getSaleOrderNo() {
		return saleOrderNo;
	}
	
	
	public void setSaleOrderNo(String saleOrderNo) {
		this.saleOrderNo = saleOrderNo;
	}
	
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getCreateTime() {
		return createTime;
	}
	
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	@Column(length = 8, precision = 2)
	public Double getSalePrice() {
		return salePrice;
	}
	
	
	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	
	@Column(length = 8, precision = 2)
	public Double getCostPrice() {
		return costPrice;
	}
	
	
	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
	public Set<OrderItem> getItems() {
		return items;
	}
	
	
	public void setItems(Set<OrderItem> items) {
		this.items = items;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buyerId")
	public Buyer getBuyer() {
		return buyer;
	}
	
	
	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shopId")
	public Shop getShop() {
		return shop;
	}
	
	
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consigneeAddressId")
	public ConsigneeAddress getConsigneeAddress() {
		return consigneeAddress;
	}
	
	
	public void setConsigneeAddress(ConsigneeAddress consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
