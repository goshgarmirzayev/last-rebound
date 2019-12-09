package az.onbir.tv.service.impl;


import az.onbir.tv.dao.UserDataInter;
import az.onbir.tv.entity.AuthGroup;
import az.onbir.tv.entity.User;
import az.onbir.tv.service.inter.SecurityServiceInter;
import az.onbir.tv.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInter {
    @Autowired
    UserDataInter userDataInter;

    @Autowired
    private SecurityServiceInter securityServiceInter;

    @Autowired
    @Qualifier("pwdEncoder")
    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(Integer id) {
        return userDataInter.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userDataInter.findAll();
    }

    @Override
    public int save(User user) {
        user.setEmail(user.getEmail().trim().toLowerCase());

        User alreadyExist = userDataInter.findByEmail(user.getEmail());
        if (alreadyExist != null) {
            return -1;
        }

        user.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        user.setGroupId(new AuthGroup(1));
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword().trim()));
        userDataInter.save(user);

        return user.getId();
    }

    @Override
    public User update(az.onbir.tv.bean.User user) {
        User newUser = securityServiceInter.getLoggedInUserDetails().getUser();
        newUser = userDataInter.getOne(newUser.getId());


        newUser.setEmail(user.getEmail().trim().toLowerCase());
        newUser.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
        if (user.getPassword() != null && !user.getPassword().trim().isEmpty()) {
            newUser.setPassword(passwordEncoder.encode(user.getPassword().trim()));
        }

        return userDataInter.save(newUser);
    }

}
