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
package com.esuper.tbsas.commons.entity;

import com.esuper.tbsas.commons.Selectedable;

/**
 * 操作人
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-15
 * @since 1.0
 */
public enum OperatorEnum implements Selectedable<String, String> {
	
	LZC("廖志成"), WSZ("王素珍");
	
	private final String text;
	
	
	private OperatorEnum(String text) {
		this.text = text;
	}
	
	
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
}
