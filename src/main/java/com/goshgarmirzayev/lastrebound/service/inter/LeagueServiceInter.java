package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.League;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LeagueServiceInter {
    public List<League> getAll();

    public League findById(Integer id);

    public int deleteById(Integer id);

    public int deleteAll();

    public League findByName(String name);


}
