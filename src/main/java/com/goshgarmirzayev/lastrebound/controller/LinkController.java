package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.service.inter.LeagueServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.LinkServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.SupportServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LinkController {
    @Autowired
    MatchServiceInter matchServiceInter;
    @Autowired
    LinkServiceInter linkServiceInter;
    @Autowired
    SupportServiceInter supportServiceInter;
    @Autowired
    LeagueServiceInter leagueServiceInter;

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView, @RequestParam(name = "id", required = false) Integer id) {

        modelAndView.addObject("leagues", leagueServiceInter.getAll());
        if (id != null) {
            League league = leagueServiceInter.findById(id);
            modelAndView.addObject("matchList", league.getMatchList());
            Map<String, League> response = new HashMap<>();
            response.put("league", league);

        } else {
            modelAndView.addObject("matchList", matchServiceInter.findAll());
        }
        modelAndView.setViewName("match/link");
        return modelAndView;
    }

    @RequestMapping(value = "/watch/{linkId}")
    public ModelAndView watch(ModelAndView modelAndView, @PathVariable("linkId") Integer linkId) {
        modelAndView.addObject("link", linkServiceInter.findById(linkId));
        modelAndView.setViewName("match/detail");
        return modelAndView;
    }
}