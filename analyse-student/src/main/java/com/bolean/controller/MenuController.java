package com.bolean.controller;

import com.bolean.entity.Folder;
import com.bolean.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private FolderService folderService;

    @RequestMapping("/index.html")
    public String index(){
        return "/menu/index.html";
    }

    @ResponseBody
    @RequestMapping("/ajax_index")
    public String ajaxIndex(){
        List<Folder> folders = folderService.selectAll();
        String str="";

        return str;
    }

}
