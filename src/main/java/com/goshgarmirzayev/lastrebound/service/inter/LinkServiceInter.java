package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LinkServiceInter {
    List<Link> findAll();

    Link findById(Integer id);

    Link save(Link link);

    int deleteById(Integer id);

    void deleteAllByMatchId(Match match);

    Link findBySlug(String slug);
}
