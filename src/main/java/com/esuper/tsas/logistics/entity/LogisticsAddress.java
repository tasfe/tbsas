/*
 * http://www.digione.cn
 */
package com.esuper.tsas.logistics.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.jqd.framework.core.entity.BaseEntity;

/**
 * 物流地址
 * 
 * @author liaozc@digione.com
 * @date 2013-4-17
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "addressType", discriminatorType = DiscriminatorType.STRING, length = 1)
public class LogisticsAddress extends BaseEntity {
	
	private static final long serialVersionUID = 8300985066438104977L;
	
	/**
	 * 主键
	 */
	private Long id;
	
	/**
	 * 联系人（收货人/发货人）
	 */
	private String linkman;
	
	/**
	 * 手机号
	 */
	private String mobile;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length = 20)
	public Long getId() {
		return id;
	}
	
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	@Column(length = 30, nullable = false)
	public String getLinkman() {
		return linkman;
	}
	
	
	public void setLinkman(String linkman) {
		this.linkman = linkman;
	}
	
	
	@Column(length = 15)
	public String getMobile() {
		return mobile;
	}
	
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogisticsAddress other = (LogisticsAddress) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		}
		else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
