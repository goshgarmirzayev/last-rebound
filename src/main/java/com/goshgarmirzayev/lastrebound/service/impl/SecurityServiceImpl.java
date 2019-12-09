package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.bean.CustomUserDetail;
import com.goshgarmirzayev.lastrebound.dao.AuthGroupRoleDaoInter;
import com.goshgarmirzayev.lastrebound.dao.UserDataInter;
import com.goshgarmirzayev.lastrebound.entity.AuthGroup;
import com.goshgarmirzayev.lastrebound.entity.AuthGroupRole;
import com.goshgarmirzayev.lastrebound.entity.User;
import com.goshgarmirzayev.lastrebound.service.inter.SecurityServiceInter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SecurityServiceImpl implements SecurityServiceInter {

    @Autowired
    private UserDataInter userDao;

    @Autowired
    private AuthGroupRoleDaoInter authGroupRoleDaoInter;


    @Override
    public CustomUserDetail getLoggedInUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
//        System.out.println(authentication.getPrincipal());
        if( !(authentication.getPrincipal() instanceof  CustomUserDetail)) return null;
        CustomUserDetail principal = (CustomUserDetail) authentication.getPrincipal();
        return principal;
    }


    @Override
    public void reloadRoles(){
        if(getLoggedInUserDetails()==null) return;
        User loggedInUser = getLoggedInUserDetails().getUser();
        User user = userDao.getOne(loggedInUser.getId());

        AuthGroup group =  user.getGroupId();
//        System.out.println(group);
        List<AuthGroupRole> authGroupRoleList = authGroupRoleDaoInter.findByGroupId(group);
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>();
        for(int i=0;i<authGroupRoleList.size();i++){
            AuthGroupRole groupRole = authGroupRoleList.get(i);
            updatedAuthorities.add(new SimpleGrantedAuthority(groupRole.getRoleId().getName()));
        }

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Authentication newAuth = new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);

        SecurityContextHolder.getContext().setAuthentication(newAuth);
    }

}
