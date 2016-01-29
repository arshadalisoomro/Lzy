/**
 * Copyright (c) 2015, adar.w (adar.w@outlook.com) 
 * 
 * http://www.adar-w.me
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pers.adar.lzy.rest.advice;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import pers.adar.lzy.common.Code;
import pers.adar.lzy.common.FailResult;
import pers.adar.lzy.log.Logger;
import pers.adar.lzy.service.exception.ServiceException;

/**
 * Common AOP
 * 		异常统一处理AOP
 */
@Aspect
@Component
public class ExceptionAdvice {
	
	private static final Logger REST_ERROR_LOGGER = Logger.getRestErrorLogger();

	private static final Logger BUSINESS_FAIL_LOGGER = Logger.getBusinessFailLogger();
	
	@Around(value = "execution(public * pers.adar.lzy.rest.*.*(..))")
	public Response around(ProceedingJoinPoint pjp) {
		try {
			return (Response) pjp.proceed();
		} catch (ServiceException exception) {
			BUSINESS_FAIL_LOGGER.error(exception.getMessage(), exception);
			
			return Response.status(Status.BAD_REQUEST).entity(failEntity(exception)).build();
		} catch (Throwable throwable) {
			REST_ERROR_LOGGER.error(throwable.getMessage(), throwable);
			
			return Response.serverError().entity(failEntity(throwable)).build();
		}
	}
	
	private String failEntity(Throwable throwable) {
		Code code = Code.ERROR;
		String message = StringUtils.EMPTY;
		if (throwable instanceof ServiceException) {
			ServiceException serviceException = (ServiceException) throwable;
			
			code = serviceException.getCode() == null ? Code.BUSINESS_FAIL : serviceException.getCode();
			message = serviceException.getMessage();
		}
		
		return FailResult.toJson(code, message);
	}
}
