package com.bolean.controller;

import com.bolean.entity.Folder;
import com.bolean.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private FolderService folderService;

    @RequestMapping("/index.html")
    public String index(){
        return "zzzd";
    }

    @RequestMapping("/ajax_index.html")
    public List<Folder> ajaxIndex(){
        List<Folder> folders = folderService.selectAll();
        return folders;
    }

    @ResponseBody
    @RequestMapping("/test.html")
    public String test(){
        Folder folder = new Folder();
        folder.setFolderName("这是什么鬼");
        folder.setKeyName("key_name");
        return "123";
    }

}
