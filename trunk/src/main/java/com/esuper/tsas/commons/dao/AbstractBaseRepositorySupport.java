/*
 * http://www.digione.cn
 */
package com.esuper.tsas.commons.dao;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import com.jqd.framework.core.persistence.jpa2.EntityManagerProvider;
import com.jqd.framework.core.persistence.jpa2.Jpa2BaseRepositorySupport;

/**
 * TODO
 * 
 * @author liaozc@digione.com
 * @date 2013-4-19
 */
@Repository
public abstract class AbstractBaseRepositorySupport extends Jpa2BaseRepositorySupport implements
		ApplicationContextAware {
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		EntityManagerProvider emp = applicationContext.getBean(EntityManagerProvider.class);
		super.setEntityManagerProvider(emp);
	}
	
}
