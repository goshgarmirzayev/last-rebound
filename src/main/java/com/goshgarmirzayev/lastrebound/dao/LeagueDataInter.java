package com.goshgarmirzayev.lastrebound.dao;

import com.goshgarmirzayev.lastrebound.entity.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueDataInter extends CrudRepository<League, Integer> {
    public League findByName(String name);
}
