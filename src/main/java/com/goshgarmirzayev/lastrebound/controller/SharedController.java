package com.goshgarmirzayev.lastrebound.controller;

import com.goshgarmirzayev.lastrebound.service.inter.PostServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SharedController {
    @Autowired
    PostServiceInter postServiceInter;

    @RequestMapping("/post/index")
    public ModelAndView postIndex(ModelAndView modelAndView) {
        modelAndView.addObject("posts", postServiceInter.findAll());
        modelAndView.setViewName("post/index");
        return modelAndView;
    }

    @RequestMapping("/post/details/{id}")
    public ModelAndView postDetails(@PathVariable("id") Integer postId, ModelAndView modelAndView) {
        modelAndView.addObject("post", postServiceInter.findById(postId));
        modelAndView.setViewName("post/details");
        return modelAndView;
    }

}
