package az.onbir.tv.service.inter;

import az.onbir.tv.entity.Link;
import az.onbir.tv.entity.Match;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LinkServiceInter {
    List<Link> findAll();

    Link findById(Integer id);

    Link save(Link link);

    int deleteById(Integer id);

}
