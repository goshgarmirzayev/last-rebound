package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.service.inter.PostServiceInter;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SharedController {
    @Autowired
    PostServiceInter postServiceInter;

    @RequestMapping("/post")
    public ModelAndView postIndex(ModelAndView modelAndView) {
        modelAndView.addObject("posts", postServiceInter.findApprovedPosts());
        modelAndView.setViewName("post/index");
        return modelAndView;
    }

    @RequestMapping("/post/{slug}")
    public ModelAndView postDetails(@PathVariable("slug") String slug, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("post", postServiceInter.findBySlug(slug));
        modelAndView.setViewName("post/details");
        return modelAndView;
    }

}
