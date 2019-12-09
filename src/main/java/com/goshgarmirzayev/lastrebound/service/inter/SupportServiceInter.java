package com.goshgarmirzayev.lastrebound.service.inter;

import com.goshgarmirzayev.lastrebound.entity.Support;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface SupportServiceInter {
    List<Support> findAll();

    Support findById(Integer id);

    Support save(Support support);

    Support update(Support support);

    void deleteById(Integer id);
}
