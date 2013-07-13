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
package com.esuper.tbsas.logistics.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.esuper.tbsas.commons.dao.AbstractBaseRepositorySupport;
import com.esuper.tbsas.logistics.dao.LogisticsAddressDAO;
import com.esuper.tbsas.logistics.entity.ConsigneeAddress;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-18
 */
@Repository()
public class LogisticsAddressDAOImpl extends AbstractBaseRepositorySupport implements
		LogisticsAddressDAO {
	
	public List<ConsigneeAddress> listBuyerConsigneeAddress(Long buyerId) throws DAOException {
		Assert.notNull(buyerId);
		
		try {
			String jpql = "select o from ConsigneeAddress o where o.buyer.id = :buyerId";
			
			Map<String, Object> filter = new HashMap<String, Object>();
			filter.put("buyerId", buyerId);
			
			return listByJpql(jpql, filter, ConsigneeAddress.class);
		}
		catch (Exception e) {
			throw new DAOException(e);
		}
	}
	
}
