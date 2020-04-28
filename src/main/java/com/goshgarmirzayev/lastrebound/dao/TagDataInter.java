package com.goshgarmirzayev.lastrebound.dao;

import com.goshgarmirzayev.lastrebound.entity.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagDataInter extends CrudRepository<Tag, Integer> {
    
}
