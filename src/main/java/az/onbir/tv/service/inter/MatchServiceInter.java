package az.onbir.tv.service.inter;

import az.onbir.tv.entity.Match;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

}
