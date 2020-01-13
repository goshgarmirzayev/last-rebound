package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.entity.Match;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface MatchServiceInter {
    List<Match> findAll();

    Match findById(Integer id);

    Match save(Match match);

    Match update(Match match);

    int deleteById(Integer id);

    List<Match> findByHeader(String query);

    List<Match> todayMatch(Date date);

    void deleteAllByLeagueId(League league);
}
