package com.bolean.controller;

import com.bolean.entity.Folder;
import com.bolean.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private FolderService folderService;

    @RequestMapping("/index.html")
    public String index(Model model){
        //获取所有顶级菜单
        List<Folder> folders=folderService.selectByParentId(0);

        for (int i = 0; i < folders.size(); i++) {
            List<Folder> childFolders = folderService.selectByParentId(folders.get(i).getFolderId());
            if(childFolders.size()>0) folders.get(i).setChildFolders(childFolders);
        }
        model.addAttribute("menus",folders);
        return "/menu/index.html";
    }

    @RequestMapping("add_menu.html")
    public String addUI(Model model){
        List<Folder> folders=folderService.selectByParentId(0);
        model.addAttribute("top_menu",folders);
        return "/menu/add_menu.html";
    }
}
