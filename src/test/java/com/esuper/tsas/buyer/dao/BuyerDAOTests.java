/*
 * http://www.digione.cn
 */
package com.esuper.tsas.buyer.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuper.tsas.AbstractTests;
import com.esuper.tsas.buyer.entity.Buyer;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozc@digione.com
 * @date 2013-4-19
 */
public class BuyerDAOTests extends AbstractTests {
	
	@Resource
	private BuyerDAO buyerDAO;
	
	
	@Test
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveEntityTest() throws DAOException {
		Buyer buyer = new Buyer();
		buyer.setWwId("test01");
		
		buyerDAO.saveEntity(buyer);
	}
	
}
