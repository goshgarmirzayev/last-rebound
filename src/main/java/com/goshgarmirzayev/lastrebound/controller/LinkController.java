package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.service.inter.LinkServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.SupportServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LinkController {
    @Autowired
    MatchServiceInter matchServiceInter;
    @Autowired
    LinkServiceInter linkServiceInter;
    @Autowired
    SupportServiceInter supportServiceInter;

    @RequestMapping(value = "/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("matchList", matchServiceInter.findAll());
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