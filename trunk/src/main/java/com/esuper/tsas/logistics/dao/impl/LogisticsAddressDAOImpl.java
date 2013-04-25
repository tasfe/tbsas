/*
 * http://www.digione.cn
 */
package com.esuper.tsas.logistics.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.esuper.tsas.commons.dao.AbstractBaseRepositorySupport;
import com.esuper.tsas.logistics.dao.LogisticsAddressDAO;
import com.esuper.tsas.logistics.entity.ConsigneeAddress;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozc@digione.com
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
