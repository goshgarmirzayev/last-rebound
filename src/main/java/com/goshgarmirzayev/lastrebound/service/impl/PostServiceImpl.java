package com.goshgarmirzayev.lastrebound.service.impl;


import com.goshgarmirzayev.lastrebound.dao.PostDataInter;
import com.goshgarmirzayev.lastrebound.entity.Post;
import com.goshgarmirzayev.lastrebound.service.inter.PostServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.SlugServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostServiceInter {


    @Autowired
    PostDataInter postDataInter;
    @Autowired
    SlugServiceInter slugServiceInter;

    @Override
    public List<Post> findAll() {
        return (List<Post>) postDataInter.findAll();
    }

    @Override
    public List<Post> findApprovedPosts() {
        return postDataInter.findAllByApprovedOrderByInsertDateTime((short) 1);
    }

    @Override
    public Post findById(Integer id) {
        return postDataInter.findById(id).get();
    }

    @Override
    public Post save(Post post) {
        post.setApproved((short) 1);
        post.setInsertDateTime(new Date());
        post.setSlug(slugServiceInter.generateSlug(post.getTitle()));
        return postDataInter.save(post);
    }

    @Override
    public int deleteById(Integer id) {
        postDataInter.deleteById(id);
        return 1;
    }
}
