package free.lzy.rest.advice;

import javax.ws.rs.core.Response;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import free.lzy.common.Code;
import free.lzy.common.FailResult;
import free.lzy.log.Logger;
import free.lzy.service.exception.ServiceException;

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
