package az.onbir.tv.dao;

import az.onbir.tv.entity.Support;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportDaoInter extends CrudRepository<Support, Integer> {
}
