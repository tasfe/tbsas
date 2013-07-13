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
package com.esuper.tbsas.seller.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.esuper.tbsas.AbstractTests;
import com.esuper.tbsas.seller.entity.Seller;
import com.esuper.tbsas.seller.entity.Shop;
import com.esuper.tbsas.seller.entity.ShopType;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-19
 */
public class ShopDAOTests extends AbstractTests {
	
	@Resource
	private ShopDAO shopDAO;
	
	
	@Test
	public void saveEntityTest() throws DAOException {
		Shop shop = new Shop();
		shop.setLinkAddress("http://test.com");
		shop.setSeller(shopDAO.loadEntity(Seller.class, 1L));
		shop.setShopId("xxx");
		shop.setShopName("test");
		shop.setShopType(ShopType.JS);
		shop.setWwId("test");
		
		shopDAO.saveEntity(shop);
	}
	
	
	@Test
	public void findEntityTest() throws DAOException {
		Shop shop = shopDAO.findEntity(Shop.class, 5L);
		System.out.println(shop.getShopType());
	}
	
}
