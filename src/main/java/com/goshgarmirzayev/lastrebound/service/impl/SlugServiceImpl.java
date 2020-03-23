package com.goshgarmirzayev.lastrebound.service.impl;

import com.github.slugify.Slugify;
import com.goshgarmirzayev.lastrebound.service.inter.SlugServiceInter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SlugServiceImpl implements SlugServiceInter {
    @Override
    public String generateSlug(String fromString) {
        Slugify slugify = new Slugify();
        String generated = slugify.slugify(fromString);
        String randomUUID = UUID.randomUUID().toString().substring(0, 5);
        return generated + "-" + randomUUID;
    }
}
