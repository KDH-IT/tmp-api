package com.kdh.tmp.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Pointcut
import org.aspectj.lang.reflect.MethodSignature
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes

@Aspect
@Component
class ApiLoggingAspect {

    @Pointcut("execution(* com.kdh.tmp.controller.crud..*(..))")
    fun crudApis() {
    }

    @Around("@annotation(ApiLogging) || crudApis()")
    fun loggingApi(pjp: ProceedingJoinPoint): Any {
        val request = (RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes).request
        val logger = LoggerFactory.getLogger(pjp.target.javaClass)

        var str = StringBuilder()
            .append(request.requestURL, " ")
            .append(pjp.signature.name, " ")

        val methodSignature = pjp.signature as MethodSignature
        val paramAnnotations = methodSignature.method.parameterAnnotations

        for ((idx, arg) in pjp.args.withIndex()) {
            paramAnnotations[idx].forEach {
                if (it is org.springframework.web.bind.annotation.PathVariable)
                    str.append(it.value, "=", arg, " ")
                if (it is RequestBody)
                    str.append("body=", arg, " ")
            }
        }
        logger.info("{}", str)
        return pjp.proceed().apply {
            logger.info("result: {}", this)
        }
    }
}