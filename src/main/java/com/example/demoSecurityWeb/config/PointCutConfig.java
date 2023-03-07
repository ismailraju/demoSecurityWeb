package com.example.demoSecurityWeb.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class PointCutConfig {


    @Before("execution(public * hi*())")
    public void adviceBefore(){
        System.out.println("good morning!!");
    }

    @After("execution(public * hi*())")
    public void adviceAfter(){
        System.out.println("good Nighht!!");
    }

}
