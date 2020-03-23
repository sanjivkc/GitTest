package com.vihaans.core.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vihaans.core.dao.model.Audit;
import com.vihaans.core.dao.service.AuditService;

@Configuration
@Aspect
public class AuditingAspect {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private AuditService auditService;

	@Around("@annotation(auditable)")
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Object logAuditActivity(ProceedingJoinPoint jp, Auditable auditable)
			throws Exception {

		logger.debug(" auditable aspect called... args " + jp.getArgs()
				+ " signature " + jp.getSignature());

		Object result = null;
		try {

			result = jp.proceed();
			
			auditService.add(new Audit(auditable.actionType().getDescription(),
					new Timestamp(new java.util.Date().getTime()),
					getAuditData(jp.getArgs()), getCompanyCode(jp.getArgs()),
					getEntityName(jp.getArgs())));

			return result;
		} catch (Throwable e) {
			auditService.add(new Audit(auditable.failedActionType()
					.getDescription(), new Timestamp(new java.util.Date()
					.getTime()), StringUtils.substring(e.getMessage(), 0, 1000), getCompanyCode(jp
					.getArgs()), getEntityName(jp.getArgs())));
			throw (Exception) e;
		}
		
	}

	private String getEntityName(Object[] objArray) {
		for (Object obj : objArray) {
			if (obj != null && !StringUtils.isEmpty(obj.getClass().getName())) {
				logger.debug("Entity Object " + obj.getClass().getName());
				return obj.getClass().getName();
			}
		}
		return "";
	}

	private String getCompanyCode(Object[] objArray) {
		for (Object obj : objArray) {
			if (obj != null && !StringUtils.isEmpty(obj.getClass().getName())) {
				logger.debug("Entity Object " + obj.getClass().getName());
				try {
					return BeanUtils.getProperty(obj, "companyCode");
				} catch (IllegalAccessException | InvocationTargetException
						| NoSuchMethodException e) {
					return "MITS";
				}
			}
		}
		return "MITS";
	}

	private String getAuditData(Object[] objArray) {
		StringBuilder sb = new StringBuilder();
		for (Object obj : objArray) {
			if (obj != null && !StringUtils.isEmpty(obj.getClass().getName())) {
				try {
					sb.append("id: " + BeanUtils.getProperty(obj, "id")
							+ " data [" + obj.toString() + "]");
				} catch (IllegalAccessException | InvocationTargetException
						| NoSuchMethodException e) {
				}
			}
		}
		logger.debug("Audit Data : " + sb.toString());
		return StringUtils.substring(sb.toString(), 0, 1000);
	}
}
