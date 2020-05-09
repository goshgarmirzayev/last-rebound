package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.service.inter.PostServiceInter;
import com.goshgarmirzayev.lastrebound.service.inter.TagServiceInter;
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
    @Autowired
    TagServiceInter tagServiceInter;

    @RequestMapping("/posts")
    public ModelAndView postIndex(ModelAndView modelAndView) {
        modelAndView.addObject("tags", tagServiceInter.findAll());
        modelAndView.addObject("posts", postServiceInter.findAll());
        modelAndView.setViewName("post/index");
        return modelAndView;
    }

    @RequestMapping("/posts/{slug}")
    public ModelAndView postDetails(@PathVariable("slug") String slug, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("tags", tagServiceInter.findAll());
        modelAndView.addObject("posts",postServiceInter.findAll().subList(0,postServiceInter.findAll().size()/2));
        modelAndView.addObject("post", postServiceInter.findBySlug(slug));
        modelAndView.setViewName("post/details");
        return modelAndView;
    }

}
