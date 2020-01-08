package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.dao.UserDataInter;
import com.goshgarmirzayev.lastrebound.dto.LinkDTO;
import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import com.goshgarmirzayev.lastrebound.entity.User;
import com.goshgarmirzayev.lastrebound.service.inter.LinkServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import jdk.nashorn.internal.parser.JSONParser;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UpdateController {
    @Autowired
    MatchServiceInter matchServiceInter;
    @Autowired
    LinkServiceInter linkServiceInter;
    @Autowired
    UserDataInter userDataInter;

    @RequestMapping("/match/{id}")
    public String getMatchDetails(@PathVariable("id") Integer id) {
        Match match = matchServiceInter.findById(id);

        return "{[" + match.getHeader() + "," + match.getBeginDate() + "]}";
    }

    @RequestMapping("/getMatchData/{id}")
    public List<LinkDTO> getLinksForGameİd(@PathVariable("id") Integer id) {
        Match match = matchServiceInter.findById(id);
        List<LinkDTO> linkList = new ArrayList<>();
        System.out.println(match.getLinkList());


        for (Link link : match.getLinkList()) {
            linkList.add(new LinkDTO(link.getId(),link.getHeader(), link.getUrl()));
        }
        return ResponseEntity.ok(linkList).getBody();
    }

    @RequestMapping("/link/{id}")
    public String getLink(@PathVariable("id") Integer id) {
        Link link = linkServiceInter.findById(id);
        return link.getHeader() + "," + link.getUrl() + "," + link.getIframeWidth() + "," + link.getIframeHeight();
    }

    @RequestMapping("/checkUser/{email}")
    public String checkUser(@PathVariable("email") String email) {
        User user = userDataInter.findByEmail(email);
        if (user != null) {
            return "-1";
        } else {
            return "0";
        }
    }
}
