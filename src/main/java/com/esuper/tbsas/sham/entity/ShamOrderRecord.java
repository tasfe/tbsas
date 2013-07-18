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
package com.esuper.tbsas.sham.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.esuper.tbsas.commons.entity.OperatorEnum;
import com.jqd.framework.core.entity.BaseEntity;

/**
 * 刷单记录
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-15
 * @since 1.0
 */
@Entity
public class ShamOrderRecord extends BaseEntity {
	
	private static final long serialVersionUID = -843980898166061185L;
	
	/**
	 * 实体的主键
	 */
	private Long id;
	
	/**
	 * 刷单小号ID
	 */
	private String accountId;
	
	/**
	 * 刷单小号信誉等级
	 */
	private String accountLevel;
	
	/**
	 * 刷单日期
	 */
	private Date shamDate;
	
	/**
	 * 产品商家编号
	 */
	private String productSellerNo;
	
	/**
	 * 刷单来源
	 */
	private ShamOriginEnum shamOrigin;
	
	/**
	 * 联系人QQ
	 */
	private String linkmanQQ;
	
	/**
	 * 联系人QT编号
	 */
	private String linkmanQTNo;
	
	/**
	 * 收货地址
	 */
	private String consigneeAddress;
	
	/**
	 * 操作人
	 */
	private OperatorEnum operator;
	
	/**
	 * 备注
	 */
	private String remark;
	
	
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
	public String getAccountId() {
		return accountId;
	}
	
	
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	
	public String getAccountLevel() {
		return accountLevel;
	}
	
	
	public void setAccountLevel(String accountLevel) {
		this.accountLevel = accountLevel;
	}
	
	
	public Date getShamDate() {
		return shamDate;
	}
	
	
	public void setShamDate(Date shamDate) {
		this.shamDate = shamDate;
	}
	
	
	public String getProductSellerNo() {
		return productSellerNo;
	}
	
	
	public void setProductSellerNo(String productSellerNo) {
		this.productSellerNo = productSellerNo;
	}
	
	
	public ShamOriginEnum getShamOrigin() {
		return shamOrigin;
	}
	
	
	public void setShamOrigin(ShamOriginEnum shamOrigin) {
		this.shamOrigin = shamOrigin;
	}
	
	
	public String getLinkmanQQ() {
		return linkmanQQ;
	}
	
	
	public void setLinkmanQQ(String linkmanQQ) {
		this.linkmanQQ = linkmanQQ;
	}
	
	
	public String getLinkmanQTNo() {
		return linkmanQTNo;
	}
	
	
	public void setLinkmanQTNo(String linkmanQTNo) {
		this.linkmanQTNo = linkmanQTNo;
	}
	
	
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	
	
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	
	
	public OperatorEnum getOperator() {
		return operator;
	}
	
	
	public void setOperator(OperatorEnum operator) {
		this.operator = operator;
	}
	
	
	public String getRemark() {
		return remark;
	}
	
	
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
