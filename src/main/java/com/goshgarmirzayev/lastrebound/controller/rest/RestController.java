package com.goshgarmirzayev.lastrebound.controller.rest;

import com.goshgarmirzayev.lastrebound.dao.UserDataInter;
import com.goshgarmirzayev.lastrebound.dto.LeagueDTO;
import com.goshgarmirzayev.lastrebound.dto.LinkDTO;
import com.goshgarmirzayev.lastrebound.dto.MatchDTO;
import com.goshgarmirzayev.lastrebound.dto.UserDTO;
import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import com.goshgarmirzayev.lastrebound.service.inter.LeagueServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value = "/rest")
public class RestController {
    @Autowired
    LeagueServiceInter leagueServiceInter;
    @Autowired
    MatchServiceInter matchServiceInter;
    @Autowired
    UserDataInter userDataInter;

    @RequestMapping(value = "/getUserData/{id}")
    public UserDTO getUserData(@PathVariable("id") Integer id) {
        UserDTO userDTO=new UserDTO(userDataInter.findById(id).get().getEmail(),userDataInter.findById(id).get().getPassword());
        return ResponseEntity.ok(userDTO).getBody();
    }
    @RequestMapping("/getLeagueData/{id}")
    public LeagueDTO getLeaugeDate(@PathVariable("id") Integer id) {
        League league = leagueServiceInter.findById(id);
        return ResponseEntity.ok(new LeagueDTO(league.getId(), league.getName(), league.getLogoUrl())).getBody();
    }

    @RequestMapping(value = "/getAllLeagues")
    public List<LeagueDTO> getAllLeagues() {
        List<LeagueDTO> leagueDTOS = new ArrayList<>();
        for (League league : leagueServiceInter.getAll()) {
            leagueDTOS.add(new LeagueDTO(league.getId(), league.getName(), league.getLogoUrl()));
        }
        return ResponseEntity.ok(leagueDTOS).getBody();
    }

    @RequestMapping(value = "/filterByLeague/{leagueId}")
    public List<MatchDTO> filterByLeague(@PathVariable("leagueId") Integer leagueId) {
        System.out.println("leagueID " + leagueId);
        List<Match> matches = new ArrayList<>();
        League league = null;
        if (leagueId == 0) {
            matches = matchServiceInter.findAll();
        } else {

            league = leagueServiceInter.findById(leagueId);
            matches = matchServiceInter.filterByLeague(league);
        }
        List<MatchDTO> matchDTOS = new ArrayList<>();
        for (Match match : matches) {
            matchDTOS.add(new MatchDTO(match.getId(), match.getHeader(), match.getBeginDate()));
        }
        return ResponseEntity.ok(matchDTOS).getBody();
    }
}
