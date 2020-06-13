package com.goshgarmirzayev.lastrebound.service.impl;


import com.goshgarmirzayev.lastrebound.dao.PostDataInter;
import com.goshgarmirzayev.lastrebound.entity.Post;
import com.goshgarmirzayev.lastrebound.service.inter.PostServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.SlugServiceInter;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostServiceInter {


    @Autowired
    PostDataInter postDataInter;
    @Autowired
    SlugServiceInter slugServiceInter;
    @Autowired
    ImageService imageService;

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
    public Post findBySlug(String slug) {
        return postDataInter.findBySlug(slug);
    }

    @Override
    public Post save(Post post) {
        if (post.getScheduleTime() != null) {
            post.setInsertDateTime(post.getScheduleTime());
        } else {
            post.setInsertDateTime(new Date());
        }
        //Get post content without html :)
        post.setCleanContent(Jsoup.parse(post.getContent()).text());
        post.setSlug(slugServiceInter.generateSlug(post.getTitle()));
        return postDataInter.save(post);
    }

    @Override
    public int deleteById(Integer id) {
        Post post = findById(id);

        postDataInter.deleteById(id);
        try {
            imageService.delete(post.getThumbnailPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
