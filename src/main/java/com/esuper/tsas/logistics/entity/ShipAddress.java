/*
 * http://www.digione.cn
 */
package com.esuper.tsas.logistics.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 发货地址
 * 
 * @author liaozc@digione.com
 * @date 2013-4-17
 */
@Entity
@DiscriminatorValue("S")
public class ShipAddress extends LogisticsAddress {
	
	private static final long serialVersionUID = -4304542380411452561L;
	
}
