package az.onbir.tv.controller;

import az.onbir.tv.entity.Support;
import az.onbir.tv.service.inter.LinkServiceInter;
import az.onbir.tv.service.inter.MatchServiceInter;
import az.onbir.tv.service.inter.SupportServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

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

//    @RequestMapping(value = "/support")
//    public ModelAndView support(ModelAndView modelAndView, @RequestParam("fullname") String fullname
//            , @RequestParam("email") String email
//            , @RequestParam("phone") String phone
//            , @RequestParam("content") String content) {
//        Support support = new Support();
//        support.setContent(content);
//        support.setEmail(email);
//        support.setPhone(phone);
//        support.setFullname(fullname);
//
////        System.out.println(support.getFullname()+support.getContent()+support.getEmail()+support.getPhone());
//        supportServiceInter.save(support);
//
//        return index(modelAndView);
//    }

}