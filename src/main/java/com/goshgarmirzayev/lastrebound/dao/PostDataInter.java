package com.goshgarmirzayev.lastrebound.dao;

import com.goshgarmirzayev.lastrebound.entity.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PostDataInter extends CrudRepository<Post, Integer> {
    List<Post> findAllByScheduleTimeLessThan(Date date);

    List<Post> findAllByApprovedOrderByInsertDateTime(Short aShort);
}
