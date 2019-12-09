package az.onbir.tv.service.impl;

import az.onbir.tv.dao.MatchDaoInter;
import az.onbir.tv.entity.Match;
import az.onbir.tv.service.inter.MatchServiceInter;
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

    @Override
    public List<Match> findAll() {
        return  matchDaoInter.findAllByOrderByBeginDateDesc();
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
}
