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

    @RequestMapping(value = "/games")
    public ModelAndView index(ModelAndView modelAndView, @RequestParam(name = "id", required = false) Integer id) {

        modelAndView.addObject("leagues", leagueServiceInter.getAll());
        if (id != null) {
            League league = leagueServiceInter.findById(id);
            modelAndView.addObject("leagueSelected", league);
            modelAndView.addObject("matchList", league.getMatchList());
        } else {
            modelAndView.addObject("matchList", matchServiceInter.findAll());
        }
        modelAndView.setViewName("match/link");
        return modelAndView;
    }

    @RequestMapping(value = "/watch/{slug}")
    public ModelAndView watch(ModelAndView modelAndView, @PathVariable("slug") String slug) {
        modelAndView.addObject("leagues", leagueServiceInter.getAll());
        modelAndView.addObject("link", linkServiceInter.findBySlug(slug));
        modelAndView.setViewName("match/detail");
        return modelAndView;
    }
}