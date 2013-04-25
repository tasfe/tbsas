/*
 * http://www.digione.cn
 */
package com.esuper.tsas.logistics.dao;

import java.util.List;

import com.esuper.tsas.logistics.entity.ConsigneeAddress;
import com.jqd.framework.core.exception.DAOException;
import com.jqd.framework.core.persistence.BaseRepository;

/**
 * TODO
 * 
 * @author liaozc@digione.com
 * @date 2013-4-18
 */
public interface LogisticsAddressDAO extends BaseRepository {
	
	/**
	 * 通过买家 ID 查找买家的收货地址
	 * @param buyerId 买家ID
	 * @return
	 * @throws DAOException
	 */
	List<ConsigneeAddress> listBuyerConsigneeAddress(Long buyerId) throws DAOException;
	
}
