package az.onbir.tv.service.impl;

import az.onbir.tv.dao.LinkDaoInter;
import az.onbir.tv.entity.Link;
import az.onbir.tv.entity.Match;
import az.onbir.tv.service.inter.LinkServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LinkServiceImpl implements LinkServiceInter {
    @Autowired
    LinkDaoInter linkDaoInter;

    @Override
    public List<Link> findAll() {
        return (List<Link>) linkDaoInter.findAll();
    }

    @Override
    public Link findById(Integer id) {
        return linkDaoInter.findById(id).get();
    }

    @Override
    public Link save(Link link) {
        return linkDaoInter.save(link);
    }

    @Override
    public int deleteById(Integer id) {
        linkDaoInter.deleteById(id);
        return 0;
    }

}
