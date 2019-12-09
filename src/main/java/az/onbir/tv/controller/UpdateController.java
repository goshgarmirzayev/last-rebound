package az.onbir.tv.controller;

import az.onbir.tv.dao.UserDataInter;
import az.onbir.tv.entity.Link;
import az.onbir.tv.entity.Match;
import az.onbir.tv.entity.User;
import az.onbir.tv.service.inter.LinkServiceInter;
import az.onbir.tv.service.inter.MatchServiceInter;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
