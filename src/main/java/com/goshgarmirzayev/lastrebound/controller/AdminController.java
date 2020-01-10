package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.dao.UserDataInter;
import com.goshgarmirzayev.lastrebound.entity.League;
import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import com.goshgarmirzayev.lastrebound.entity.User;
import com.goshgarmirzayev.lastrebound.service.inter.LeagueServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.LinkServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/adminPanel")

public class AdminController {
    @Autowired
    MatchServiceInter matchServiceInter;
    @Autowired
    LinkServiceInter linkServiceInter;
    @Autowired
    UserServiceInter userServiceInter;
    @Autowired
    UserDataInter userDataInter;
    @Autowired
    LeagueServiceInter leagueServiceInter;

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView) {
        List<Match> matchList = matchServiceInter.findAll();
        modelAndView.addObject("matchList", matchList);
        modelAndView.addObject("leagueList", leagueServiceInter.getAll());
        modelAndView.addObject("service", matchServiceInter);
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/delete")
    public ModelAndView delete(ModelAndView modelAndView, @RequestParam("matchId") Integer id) {
        for (Link l : matchServiceInter.findById(id).getLinkList()) {
            linkServiceInter.deleteById(l.getId());
        }
        matchServiceInter.deleteById(id);
        modelAndView.setViewName("redirect:/adminPanel");
        return modelAndView;
    }

    @RequestMapping(value = "/addMatch")
    public ModelAndView addMatch(ModelAndView modelAndView, @RequestParam("header") String header, @RequestParam("beginDate") String beginDate) {
        String datetimearr[] = beginDate.split(" ");
        String date = datetimearr[1];

        String time = datetimearr[0];
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        String month = date.split("/")[0];
        String day = date.split("/")[1];
        String year = date.split("/")[2];
        int openedMinute = 0;
        int openedHour = 0;
        if (Integer.valueOf(minute) == 0) {
            openedMinute = 60 - 15;
            if (Integer.valueOf(hour) == 0) {
                openedHour = 24 - 1;
            } else {
                openedHour = Integer.valueOf(hour) - 1;
            }

        } else if (Integer.valueOf(minute) < 15) {
            openedMinute = 60 + Integer.valueOf(minute) - 15;
            if (Integer.valueOf(hour) == 0) {
                openedHour = 24 - 1;
            } else {
                openedHour = Integer.valueOf(hour) - 1;
            }
        } else {
            openedMinute = Integer.valueOf(minute) - 15;
            openedHour = Integer.valueOf(hour);
        }

        Calendar dateSql = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));
        Calendar openedTime = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day), openedHour, openedMinute);
        Match match = new Match(header, dateSql.getTime(), openedTime.getTime());

        matchServiceInter.save(match);
        modelAndView.setViewName("redirect:/adminPanel");
        return modelAndView;
    }

    @RequestMapping(value = "/updateMatch")
    public ModelAndView updateMatch(ModelAndView modelAndView, @RequestParam("header") String header,
                                    @RequestParam("beginDate") String beginDate,
                                    @RequestParam("matchId") Integer matchId) {
        String datetimearr[] = beginDate.split(" ");
        String date = datetimearr[1];

        String time = datetimearr[0];
        String hour = time.split(":")[0];
        String minute = time.split(":")[1];
        String month = date.split("/")[0];
        String day = date.split("/")[1];
        String year = date.split("/")[2];
        int openedMinute = 0;
        int openedHour = 0;
        if (Integer.valueOf(minute) == 0) {
            openedMinute = 60 - 15;
            if (Integer.valueOf(hour) == 0) {
                openedHour = 24 - 1;
            } else {
                openedHour = Integer.valueOf(hour) - 1;
            }

        } else if (Integer.valueOf(minute) < 15) {
            openedMinute = 60 + Integer.valueOf(minute) - 15;
            if (Integer.valueOf(hour) == 0) {
                openedHour = 24 - 1;
            } else {
                openedHour = Integer.valueOf(hour) - 1;
            }
        } else {
            openedMinute = Integer.valueOf(minute) - 15;
            openedHour = Integer.valueOf(hour);
        }
        Calendar dateSql = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day), Integer.parseInt(hour), Integer.parseInt(minute));
        Calendar openedTime = new GregorianCalendar(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(day), openedHour, openedMinute);
        System.out.println(dateSql.getTime());
        Match match = new Match(header, dateSql.getTime(), openedTime.getTime());
        match.setId(matchId);
        matchServiceInter.save(match);
        modelAndView.setViewName("redirect:/adminPanel");
        return modelAndView;
    }

    @RequestMapping(value = "/addMatchLink")
    public ModelAndView addLink(ModelAndView modelAndView,
                                @RequestParam("matchId") Integer id,
                                @RequestParam("url") String url, @RequestParam("header") String header,
                                @RequestParam("width") Integer width, @RequestParam("height") Integer height) {
        Link link = new Link();
        link.setMatchId(matchServiceInter.findById(id));
        link.setHeader(header);
        link.setUrl(url);
        if (width != null) {
            link.setIframeWidth(width);
        } else {
            link.setIframeWidth(700);
        }
        if (height != null) {
            link.setIframeHeight(height);
        } else {
            link.setIframeHeight(500);
        }
        linkServiceInter.save(link);
        modelAndView.setViewName("redirect:/adminPanel/details/" + id);
        return modelAndView;
    }

    @RequestMapping(value = "/search")
    public ModelAndView search(ModelAndView modelAndView, @RequestParam("query") String query) {
        List<Match> matchList = new ArrayList<>();
        if (query.trim() != null) {
            matchList = matchServiceInter.findByHeader(query);
        } else {
            matchList = matchServiceInter.findAll();
        }
        modelAndView.addObject("matchList", matchList);
        modelAndView.setViewName("admin/admin");
        return modelAndView;
    }

    @RequestMapping(value = "/details/{matchId}")
    public ModelAndView details(ModelAndView modelAndView, @PathVariable("matchId") Integer id) {
        modelAndView.addObject("match", matchServiceInter.findById(id));
        modelAndView.setViewName("admin/matchdetail");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteLink")
    public ModelAndView deleteMatchLink(ModelAndView modelAndView, @RequestParam("linkId") Integer linkId) {
        System.out.println("linkId:" + linkId);
        Link link = linkServiceInter.findById(linkId);
        linkServiceInter.deleteById(linkId);
        return details(modelAndView, link.getMatchId().getId());
    }

    @RequestMapping(value = "/updateLink")
    public ModelAndView updateMatchLink(ModelAndView modelAndView, @RequestParam("linkId") Integer linkId,
                                        @RequestParam("header") String header,
                                        @RequestParam("url") String url,
                                        @RequestParam("width") Integer width, @RequestParam("height") Integer height) {
        Link link = linkServiceInter.findById(linkId);
        link.setHeader(header);
        link.setUrl(url);
        if (width != null) {
            link.setIframeWidth(width);
        } else {
            link.setIframeWidth(700);
        }
        if (height != null) {
            link.setIframeHeight(height);
        } else {
            link.setIframeHeight(500);
        }
        link.setId(linkId);
        linkServiceInter.save(link);
        return details(modelAndView, link.getMatchId().getId());
    }

    @RequestMapping(value = "/addNewUser")
    public ModelAndView addSubUser(ModelAndView modelAndView) {
        modelAndView.setViewName("admin/addUser");
        return modelAndView;
    }

    @RequestMapping(value = "/addUser")
    public ModelAndView addUser(ModelAndView modelAndView, @Valid User user, BindingResult result) {
        int r = userServiceInter.save(user);
        if (r == -1) {
            result.rejectValue("email", "email", "exist");
        }
        modelAndView.setViewName("redirect:/adminPanel");
        return modelAndView;
    }

    @PostMapping(value = "/addLeague")
    public ModelAndView addLeague(ModelAndView modelAndView, @RequestParam("name") String name, @RequestParam("logoUrl") String logoUrl) {
        leagueServiceInter.save(new League(name, logoUrl));
        modelAndView.setViewName("redirect:/adminPanel");
        return modelAndView;
    }

    @PostMapping(value = "/updateLeague")
    public ModelAndView updateLeague(ModelAndView modelAndView, @RequestParam("name") String name, @RequestParam("logoUrl") String logoUrl, @RequestParam("leagueId") Integer id) {
        leagueServiceInter.save(new League(id, name, logoUrl));
        modelAndView.setViewName("redirect:/adminPanel");
        return modelAndView;
    }

    @GetMapping(value = "/deleteLeague")
    public ModelAndView deleteLeague(ModelAndView modelAndView, @RequestParam("leagueId") Integer id) {
        leagueServiceInter.deleteById(id);
        modelAndView.setViewName("redirect:/adminPanel");
        return modelAndView;
    }

}