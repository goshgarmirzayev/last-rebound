package com.goshgarmirzayev.lastrebound.service.impl;


import com.goshgarmirzayev.lastrebound.dao.PostDataInter;
import com.goshgarmirzayev.lastrebound.entity.Post;
import com.goshgarmirzayev.lastrebound.service.inter.PostServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostServiceInter {


    @Autowired
    PostDataInter postDataInter;

    @Override
    public List<Post> findAll() {
        return (List<Post>) postDataInter.findAll();
    }
    @Override
    public  Post findById(Integer id){
        return postDataInter.findById(id).get();
    }
}
