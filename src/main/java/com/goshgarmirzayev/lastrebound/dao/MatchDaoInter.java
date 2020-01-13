package com.goshgarmirzayev.lastrebound.dao;

import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Service
@Repository
public interface MatchDaoInter extends JpaRepository<Match, Integer> {
    List<Match> findAllByHeaderLike(String header);

    List<Match> findAllByOrderByBeginDateDesc();

    void deleteAllByLeagueId(League id);
}
