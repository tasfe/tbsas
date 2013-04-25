/*
 * http://www.digione.cn
 */
package com.esuper.tsas;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * TODO
 * 
 * @author liaozc@digione.com
 * @date 2013-4-12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:beans.xml")
public class IntegrationTests {
	
	@PersistenceContext(name = "mysql.persistence")
	private EntityManager entityManager;
	
	
	@Test
	public void springJapIntegrationTest() {
		Assert.assertNotNull(entityManager);
	}
	
}
