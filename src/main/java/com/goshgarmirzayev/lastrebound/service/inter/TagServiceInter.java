package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TagServiceInter {
    List<Tag> findAll();

    Tag findById(Integer id);

    Tag save(Tag vTag);

    int deleteById(Integer id);
}