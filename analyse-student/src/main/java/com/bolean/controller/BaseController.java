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

        if(pageInfo.getPageNum()>5){
            htmlStr+="<li class='paginate_button previous'><a class='num' data-p='1' href='javascript:void(0)'>首页</a></li>";
        }
        if(pageInfo.isHasPreviousPage()){
            htmlStr+="<li class='paginate_button previous'><a class='num' data-p='"+pageInfo.getPrePage()+"' href='javascript:void(0)'>上一页</a></li>";
        }

        for (int i=0;i<pageInfo.getNavigatepageNums().length;i++){
            if(pageInfo.getPageNum()==pageInfo.getNavigatepageNums()[i]){
                htmlStr+="<li class='paginate_button active'><a tabindex='0' data-dt-idx='1' aria-controls='example1' data-p='"+pageInfo.getNavigatepageNums()[i]+"' href='javascript:void(0)'>"+pageInfo.getNavigatepageNums()[i]+"</a></li>";
            }else{
                htmlStr+="<li class='paginate_button'><a class='num' data-p='"+pageInfo.getNavigatepageNums()[i]+"' href='javascript:void(0)'>"+pageInfo.getNavigatepageNums()[i]+"</a></li>";
            }
        }

        if(pageInfo.isHasNextPage()){
            htmlStr+="<li class='paginate_button next'><a class='num' data-p='"+pageInfo.getNextPage()+"' href='javascript:void(0)'>下一页</a></li>";
        }
        if(pageInfo.getPages()-pageInfo.getPageNum()>3){
            htmlStr+="<li class='paginate_button next'><a class='num' data-p='"+pageInfo.getPages()+"' href='javascript:void(0)'>尾页</a></li>";
        }
        htmlStr+="<li class='paginate_button next'><a>共"+pageInfo.getTotal()+"条数据</a></li>";
        htmlStr+="</ul>";
        return htmlStr;
    }
}
