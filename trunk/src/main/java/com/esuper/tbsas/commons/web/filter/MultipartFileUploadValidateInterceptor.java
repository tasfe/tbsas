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
package com.esuper.tbsas.commons.web.filter;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * TODO
 * 
 * @author liaozhicheng.cn@gmail.com
 * @date 2013-4-15
 * @since 1.0
 */
public class MultipartFileUploadValidateInterceptor implements HandlerInterceptor {
	
	private static final long _1M = 1024 * 1024;
	
	private static final long SINGLE_FILE_MAX_SIZE = 20 * _1M;
	
	
	// private static final String MULTIPART_FILE_UPLOAD_VALIDATION_FAILED_CODE =
	// "_MULTIPART_FILE_UPLOAD_VALIDATION_FAILED";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
			Iterator<String> inputNamesInterator = mpRequest.getFileNames();
			while (inputNamesInterator.hasNext()) {
				// 获取前台页面上定义的上传文件输入框DOM对象的name属性
				String inputName = inputNamesInterator.next();
				
				// 如果是多文件上传组件，这里返回的是这个组件上传的所有文件列表
				List<MultipartFile> fileList = mpRequest.getFiles(inputName);
				for (int i = 0; i < fileList.size(); i++) {
					MultipartFile file = fileList.get(i);
					if (!file.isEmpty() && !doValidation(file)) {
						
						// TODO handle error
						
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	
	private boolean doValidation(MultipartFile file) {
		// TODO 1）加入文件类型的检验；2）如果有必要将该方法抽取为接口，由客户端自由配置检验规则
		return file.getSize() <= SINGLE_FILE_MAX_SIZE;
	}
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// do nothing
	}
	
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) throws Exception {
		// do nothing
	}
}
