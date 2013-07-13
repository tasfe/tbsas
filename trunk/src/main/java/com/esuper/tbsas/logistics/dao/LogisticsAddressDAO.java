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

import com.esuper.tbsas.logistics.entity.ConsigneeAddress;
import com.jqd.framework.core.exception.DAOException;
import com.jqd.framework.core.persistence.BaseRepository;

/**
 * TODO
 * 
 * @author liaozhicheng.cn@gmail.com
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
