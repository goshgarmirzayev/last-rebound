package com.goshgarmirzayev.lastrebound.controller.rest;

import com.goshgarmirzayev.lastrebound.dto.LeagueDTO;
import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.service.inter.LeagueServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    LeagueServiceInter leagueServiceInter;

    @RequestMapping("/getLeagueData/{id}")
    public LeagueDTO getLeaugeDate(@PathVariable("id") Integer id) {
        League league = leagueServiceInter.findById(id);
        return ResponseEntity.ok(new LeagueDTO(league.getId(), league.getName(), league.getLogoUrl())).getBody();
    }
}
