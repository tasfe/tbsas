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
package com.esuper.tbsas.logistics.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;

import com.esuper.tbsas.AbstractTests;
import com.esuper.tbsas.buyer.entity.Buyer;
import com.esuper.tbsas.logistics.entity.ConsigneeAddress;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozhicheng.cn@gmail.com
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
