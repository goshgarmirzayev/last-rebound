package az.onbir.tv.dao;

import az.onbir.tv.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

//@Service
@Repository
public interface MatchDaoInter extends JpaRepository<Match, Integer> {
    List<Match> findAllByHeaderLike(String header);
    List<Match> findAllByOrderByBeginDateDesc();
}
