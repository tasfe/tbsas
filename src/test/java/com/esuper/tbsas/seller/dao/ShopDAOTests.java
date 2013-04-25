/*
 * http://www.digione.cn
 */
package com.esuper.tbsas.seller.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.esuper.tbsas.AbstractTests;
import com.esuper.tsas.seller.dao.ShopDAO;
import com.esuper.tsas.seller.entity.Seller;
import com.esuper.tsas.seller.entity.Shop;
import com.esuper.tsas.seller.entity.ShopType;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozc@digione.com
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
