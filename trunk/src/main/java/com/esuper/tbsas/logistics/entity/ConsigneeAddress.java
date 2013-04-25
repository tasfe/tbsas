/*
 * http://www.digione.cn
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
 * @author liaozc@digione.com
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
