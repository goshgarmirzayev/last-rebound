package az.onbir.tv.service.impl;

import az.onbir.tv.dao.SupportDaoInter;
import az.onbir.tv.entity.Support;
import az.onbir.tv.service.inter.SupportServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportServiceImpl implements SupportServiceInter {
    @Autowired
    SupportDaoInter supportDaoInter;

    @Override
    public List<Support> findAll() {
        return (List<Support>) supportDaoInter.findAll();
    }

    @Override
    public Support findById(Integer id) {
        return supportDaoInter.findById(id).get();
    }

    @Override
    public Support save(Support support) {
        return supportDaoInter.save(support);
    }

    @Override
    public Support update(Support support) {
        return supportDaoInter.save(support);
    }

    @Override
    public void deleteById(Integer id) {
        supportDaoInter.deleteById(id);
    }
}
