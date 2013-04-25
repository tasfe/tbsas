/*
 * http://www.digione.cn
 */
package com.esuper.tsas.commons.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.jqd.framework.core.persistence.jpa2.EntityManagerProvider;

/**
 * TODO
 * 
 * @author liaozc@digione.com
 * @date 2013-4-19
 */
@Component
public class Jpa2EntityManagerProvider implements EntityManagerProvider {
	
	@PersistenceContext(name = "mysql.persistence")
	private EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}
