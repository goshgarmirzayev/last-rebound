package com.goshgarmirzayev.lastrebound.service.impl;

import com.github.slugify.Slugify;
import com.goshgarmirzayev.lastrebound.dao.LinkDaoInter;
import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import com.goshgarmirzayev.lastrebound.service.inter.LinkServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.SlugServiceInter;
import net.bytebuddy.build.ToStringPlugin;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

@Service
public class LinkServiceImpl implements LinkServiceInter {
    @Autowired
    LinkDaoInter linkDaoInter;
    @Autowired
    SlugServiceInter slugServiceInter;

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
        link.setSlug(slugServiceInter.generateSlug(link.getHeader()));
        return linkDaoInter.save(link);
    }

    @Override
    public int deleteById(Integer id) {
        linkDaoInter.deleteById(id);
        return 0;
    }

    @Override
    public void deleteAllByMatchId(Match id) {
        linkDaoInter.deleteAllByMatchId(id);
    }

    @Override
    public Link findBySlug(String slug) {
        return linkDaoInter.findBySlug(slug);
    }
}
