/*
 * http://www.digione.cn
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
 * @author liaozc@digione.com
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
