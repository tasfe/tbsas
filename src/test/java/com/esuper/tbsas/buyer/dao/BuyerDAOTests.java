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
package com.esuper.tbsas.buyer.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuper.tbsas.AbstractTests;
import com.esuper.tbsas.buyer.entity.Buyer;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozhicheng.cn@gmail.com
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
