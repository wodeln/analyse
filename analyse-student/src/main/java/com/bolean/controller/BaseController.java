package com.bolean.controller;

import com.bolean.AnalyseStudentApplication;
import com.bolean.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;

import javax.servlet.http.HttpServletRequest;

public class BaseController<T> {
    protected static final Logger logger = LogManager.getLogger(AnalyseStudentApplication.class);

    protected User getSessionUser(){
        return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }
}
