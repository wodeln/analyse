package com.bolean.controller;

import bolean.RSTFul.RSTFulBody;
import com.bolean.entity.Folder;
import com.bolean.entity.User;
import com.bolean.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController{
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
        model.addAttribute("top_menus",folders);
        return "/menu/add_menu.html";
    }

    @ResponseBody
    @RequestMapping("add_menu")
    public RSTFulBody addMenu(Folder folder){
        User sessionUser = getSessionUser();
        folder.setCreateId(sessionUser.getUserId());
        folder.setCreateName(sessionUser.getRealName());
        int res=folderService.insertSelective(folder);
        RSTFulBody rstFulBody=new RSTFulBody();
        if(res>0) rstFulBody.success("添加成功！");
        else  rstFulBody.fail("添加失败！");
        return rstFulBody;
    }
}
