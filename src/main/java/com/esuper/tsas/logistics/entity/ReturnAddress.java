/*
 * http://www.digione.cn
 */
package com.esuper.tsas.logistics.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 退货地址
 * 
 * @author liaozc@digione.com
 * @date 2013-4-17
 */
@Entity
@DiscriminatorValue("R")
public class ReturnAddress extends LogisticsAddress {
	
	private static final long serialVersionUID = -480024411677053758L;
	
}
