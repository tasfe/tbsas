/*
 * http://www.digione.cn
 */
package com.esuper.tsas.logistics.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.esuper.tsas.AbstractTests;
import com.esuper.tsas.buyer.entity.Buyer;
import com.esuper.tsas.logistics.entity.ConsigneeAddress;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozc@digione.com
 * @date 2013-4-18
 */
public class LogisticsAddressDAOTests extends AbstractTests {
	
	@Resource
	private LogisticsAddressDAO logisticsAddressDAO;
	
	
	@Test
	public void saveEntityTest() throws DAOException {
		ConsigneeAddress address = new ConsigneeAddress();
		address.setLinkman("test man");
		address.setMobile("13800138000");
		address.setBuyer(logisticsAddressDAO.loadEntity(Buyer.class, 1L));
		
		logisticsAddressDAO.saveEntity(address);
	}
	
	
	@Test
	public void findEntityTest() throws DAOException {
		ConsigneeAddress address = logisticsAddressDAO.findEntity(ConsigneeAddress.class, 1L);
		System.out.println(address.getLinkman());
	}
	
	
	@Test
	public void listBuyerConsigneeAddressTest() throws DAOException {
		Assert.assertNotNull(logisticsAddressDAO);
		
		List<ConsigneeAddress> addressList = logisticsAddressDAO.listBuyerConsigneeAddress(1L);
		System.out.println(addressList.size());
		System.out.println(addressList);
	}
	
}
