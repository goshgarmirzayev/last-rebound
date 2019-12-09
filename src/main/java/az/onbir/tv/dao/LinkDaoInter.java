package az.onbir.tv.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import az.onbir.tv.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface LinkDaoInter extends JpaRepository<Link, Integer> {
}

