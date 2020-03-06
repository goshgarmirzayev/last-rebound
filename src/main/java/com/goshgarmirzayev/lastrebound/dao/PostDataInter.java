package com.goshgarmirzayev.lastrebound.dao;

import com.goshgarmirzayev.lastrebound.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostDataInter extends CrudRepository<Post, Integer> {

}
