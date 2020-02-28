package com.goshgarmirzayev.lastrebound.dao;

import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface LinkDaoInter extends JpaRepository<Link, Integer> {
    void deleteAllByMatchId(Match id);

    Link findBySlug(String slug);
}

