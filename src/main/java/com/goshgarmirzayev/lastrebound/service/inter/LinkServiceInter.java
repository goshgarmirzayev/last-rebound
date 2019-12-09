package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.Link;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LinkServiceInter {
    List<Link> findAll();

    Link findById(Integer id);

    Link save(Link link);

    int deleteById(Integer id);

}
