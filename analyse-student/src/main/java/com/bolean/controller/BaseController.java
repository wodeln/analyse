package com.bolean.controller;

import com.bolean.AnalyseStudentApplication;
import com.bolean.entity.User;
import com.github.pagehelper.PageInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpServletRequest;

public class BaseController<T> {
    protected static final Logger logger = LogManager.getLogger(AnalyseStudentApplication.class);

    @Value("${page-size}")
    protected static int pageSize;
    protected User getSessionUser(){
        return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }

    protected String makePageHtml(PageInfo pageInfo){
        String htmlStr="<ul class='pagination'>";
        if(pageInfo.getPages()<=0) return "";


        return null;
    }
}
