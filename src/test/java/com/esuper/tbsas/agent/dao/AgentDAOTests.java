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
package com.esuper.tbsas.agent.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.esuper.tbsas.AbstractTests;
import com.esuper.tbsas.agent.entity.Agent;
import com.jqd.framework.core.exception.DAOException;

/**
 * TODO
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-25
 */
public class AgentDAOTests extends AbstractTests {
	
	@Resource
	private AgentDAO agentDAO;
	
	
	@Test
	public void canSaveAgent() throws DAOException {
		Agent agent = new Agent();
		agent.setName("测试代理商");
		
		agentDAO.saveEntity(agent);
	}
	
}
