package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.Post;


import java.util.List;

public interface PostServiceInter {

    List<Post> findAll();
    Post findById(Integer id);
}
