package com.goshgarmirzayev.lastrebound.controller.rest;

import com.goshgarmirzayev.lastrebound.dto.LinkDTO;
import com.goshgarmirzayev.lastrebound.entity.Link;
import com.goshgarmirzayev.lastrebound.entity.Match;
import com.goshgarmirzayev.lastrebound.service.inter.MatchServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SharedRestController {
    @Autowired
    MatchServiceInter matchServiceInter;

    @RequestMapping("/getMatchLinks/{id}")
    public List<LinkDTO> getLinksForGameİd(@PathVariable("id") Integer id) {
        Match match = matchServiceInter.findById(id);
        List<LinkDTO> linkList = new ArrayList<>();
        System.out.println(match.getLinkList());

        for (Link link : match.getLinkList()) {
            linkList.add(new LinkDTO(link.getId(), link.getHeader(), link.getUrl(),link.getSlug()));
        }
        return ResponseEntity.ok(linkList).getBody();
    }
}
