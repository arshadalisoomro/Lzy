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
package pers.lzy.rest.advice;

import javax.ws.rs.core.Response;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import pers.lzy.common.Code;
import pers.lzy.common.FailResult;
import pers.lzy.log.Logger;
import pers.lzy.service.exception.ServiceException;

/**
 * Common AOP
 * 		异常统一处理AOP
 */
@Aspect
@Component
public class ExceptionAdvice {
	
	private static final Logger REST_ERROR_LOGGER = Logger.getRestErrorLogger();

	private static final Logger BUSINESS_FAIL_LOGGER = Logger.getBusinessFailLogger();

	@Around(value = "execution(public * free.lzy.rest.*.*(..))")
	public Response around(ProceedingJoinPoint pjp) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		Code code = Code.BUSINESS_FAIL;

		String repsonse = null;
		try {
			return (Response) pjp.proceed();
		} catch (ServiceException e) {
			BUSINESS_FAIL_LOGGER.error(e.getMessage(), e);
			
			code = e.getCode() == null ? code : e.getCode();
			
			repsonse = FailResult.toJson(Code.BUSINESS_FAIL, e.getMessage());
		} catch (Throwable e) {
			REST_ERROR_LOGGER.error(e.getMessage(), e);

			repsonse = FailResult.toJson(Code.ERROR, e.getMessage());
		}

		return Response.status(status.value()).entity(repsonse).build();
	}
}
