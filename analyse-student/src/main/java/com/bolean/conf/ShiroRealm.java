package com.bolean.conf;

import com.bolean.AnalyseStudentApplication;
import com.bolean.entity.*;
import com.bolean.service.RoleFolderService;
import com.bolean.service.RoleService;
import com.bolean.service.UserRoleService;
import com.bolean.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    private static final Logger log = LogManager.getLogger(AnalyseStudentApplication.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleFolderService roleFolderService;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("doGetAuthorizationInfo+"+principalCollection.toString());

        User user = userService.selectByUserName((String) principalCollection.getPrimaryPrincipal());
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getUserId()),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        /*//赋予角色
        for(Role userRole:user.getRoles()){
            info.addRole(userRole.getRoleName());
        }*/
        info.addRole(user.getRole().getRoleName());

        //赋予权限
//        RoleFolder roleFolder = new RoleFolder();
//        roleFolder.setRoleId(user.getRole().getRoleId());
//        for (RoleFolder folder:roleFolderService.selectByInfo(roleFolder)){
//            info.addStringPermission(folder.getFolderName());
//        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        log.info(userName+token.getPassword());

        User user = userService.selectByUserName(token.getUsername());
        if (user != null) {
//            byte[] salt = Encodes.decodeHex(user.getSalt());
//            ShiroUser shiroUser=new ShiroUser(user.getId(), user.getLoginName(), user.getName());
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(userName,user.getPassword(),getName());
        } else {
            return null;
        }
    }
}
