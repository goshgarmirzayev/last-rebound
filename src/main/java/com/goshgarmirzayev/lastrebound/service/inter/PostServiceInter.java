package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.Post;


import java.util.List;

public interface PostServiceInter {

    List<Post> findAll();

    List<Post> findApprovedPosts();

    Post findById(Integer id);

    Post save(Post post);

    int deleteById(Integer id);

}
