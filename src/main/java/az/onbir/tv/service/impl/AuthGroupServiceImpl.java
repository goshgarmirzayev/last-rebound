package az.onbir.tv.service.impl;

import az.onbir.tv.dao.AuthGroupDataInter;
import az.onbir.tv.entity.AuthGroup;
import az.onbir.tv.service.inter.AuthGroupServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthGroupServiceImpl implements AuthGroupServiceInter {
    @Autowired
    AuthGroupDataInter authGroupDataInter;

    @Override
    public AuthGroup findById(Integer id) {
        return authGroupDataInter.findById(id).get();
    }
}
