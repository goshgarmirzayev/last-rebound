package com.goshgarmirzayev.lastrebound.service.inter;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SlugServiceInter {
    public String generateSlug(String fromString);
}
