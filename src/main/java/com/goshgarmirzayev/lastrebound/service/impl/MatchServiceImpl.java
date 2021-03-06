package com.goshgarmirzayev.lastrebound.service.impl;

import com.goshgarmirzayev.lastrebound.dao.MatchDaoInter;
import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.entity.Match;
import com.goshgarmirzayev.lastrebound.service.inter.LinkServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MatchServiceImpl implements MatchServiceInter {
    @Autowired
    MatchDaoInter matchDaoInter;
    @Autowired
    LinkServiceInter linkServiceInter;

    @Override
    public List<Match> findAll() {
        return matchDaoInter.findAllByOrderByBeginDateDesc();
    }

    @Override
    public Match findById(Integer id) {
        return matchDaoInter.findById(id).get();
    }

    @Override
    public Match save(Match match) {
        return matchDaoInter.save(match);
    }

    @Override
    public Match update(Match match) {
        return matchDaoInter.save(match);
    }

    @Override
    public int deleteById(Integer id) {
        linkServiceInter.deleteAllByMatchId(findById(id));
        matchDaoInter.deleteById(id);
        return 0;
    }

    @Override
    public List<Match> findByHeader(String query) {
        return matchDaoInter.findAllByHeaderLike(query);
    }

    @Override
    public List<Match> todayMatch(Date date) {
        return null;
    }

    @Override
    public List<Match> filterByLeague(League league) {
        return (List<Match>) matchDaoInter.findAllByLeagueId(league);
    }

    @Override
    public void deleteAllByLeagueId(League id) {
        for (Match match : id.getMatchList()) {
            deleteById(match.getId());
        }
        matchDaoInter.deleteAllByLeagueId(id);
    }
}
