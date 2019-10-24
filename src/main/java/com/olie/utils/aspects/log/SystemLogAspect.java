package com.olie.utils.aspects.log;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.deploy.net.HttpResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class SystemLogAspect {

    private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);

    @Pointcut("@annotation(com.olie.utils.aspects.log.SystemLog)")
    public void pointcut() {

    }

    @Around("pointcut()")
    public Object doInvoke(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        Object result = null;
        printBeforeLog(pjp);

        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            logger.error(throwable.getMessage(), throwable);
            throw new RuntimeException(throwable);
        } finally {
            long end = System.currentTimeMillis();
            long elapsedTime = end - start;
            printAftertLog(pjp, result, elapsedTime);
        }

        return result;
    }

    /**
     * 打印日志
     *
     * @param pjp
     * @return : null
     * @author niexianglin mail:niexianglin@imdada.cn
     * @date 2019/10/19 12:05
     */
    private void printBeforeLog(ProceedingJoinPoint pjp) {
        try {
            SystemLogStrategy strategy = getFocus(pjp);
            if (null != strategy) {
                if (strategy.isAsync()) {
                    new Thread(() -> logger.info(strategy.beforeFormat(), strategy.beforeArgs())).start();
                } else {
                    logger.info(strategy.beforeFormat(), strategy.beforeArgs());
                }
            }
        } catch (Exception e) {
            logger.error("构建日志实体出错", e);
        }
    }

    /**
     * 打印日志
     *
     * @param pjp         连接点
     * @param result      方法调用返回结果
     * @param elapsedTime 方法调用花费时间
     */
    private void printAftertLog(ProceedingJoinPoint pjp, Object result, long elapsedTime) {

        try {
            SystemLogStrategy strategy = getFocus(pjp);

            if (null != strategy) {
                strategy.setResult(JSON.toJSONString(result, SerializerFeature.DisableCircularReferenceDetect));
                strategy.setElapsedTime(elapsedTime);
                if (strategy.isAsync()) {
                    new Thread(() -> logger.info(strategy.format(), strategy.args())).start();
                } else {
                    logger.info(strategy.format(), strategy.args());
                }
            }
        } catch (Exception e) {
            logger.error("构建日志实体出错", e);
        }
    }

    /**
     * 获取注解
     */
    private SystemLogStrategy getFocus(ProceedingJoinPoint pjp) {

        SystemLogStrategy strategy = new SystemLogStrategy();
        Signature signature = pjp.getSignature();
        SystemLog systemLog = getMethodAnnotation(pjp);

        strategy.setClassName(signature.getDeclaringTypeName());
        strategy.setMethodName(signature.getName());
        strategy.setArguments(JSON.toJSONString(getArgs(pjp.getArgs())));
        strategy.setDescription(systemLog.description());
        strategy.setThreadId(Thread.currentThread().getName());
        strategy.setAsync(systemLog.async());

        return strategy;
    }

    private List getArgs(Object[] args) {
        List result = new ArrayList();
        for (Object arg : args) {
            if (arg instanceof ServletRequest || arg instanceof ServletResponse || arg instanceof File) {
                continue;
            }
            result.add(arg);
        }
        return result;
    }

    private SystemLog getMethodAnnotation(ProceedingJoinPoint pjp) {
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        return method.getAnnotation(SystemLog.class);
    }

}