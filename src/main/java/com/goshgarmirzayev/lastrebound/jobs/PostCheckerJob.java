package com.goshgarmirzayev.lastrebound.jobs;

import com.goshgarmirzayev.lastrebound.dao.PostDataInter;
import com.goshgarmirzayev.lastrebound.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class PostCheckerJob {

    @Autowired
    PostDataInter postDataInter;

    @Scheduled(fixedDelay = 10)
    public void postScheduledNews() {
        checkScheduledPosts();
    }

    public void checkScheduledPosts() {
        List<Post> posts = postDataInter.findAllByScheduleTimeLessThan(new Date());
        posts.forEach(p -> p.setApproved(true));
        posts.forEach(p -> p.setInsertDateTime(p.getScheduleTime()));
        posts.forEach(p -> p.setScheduleTime(null));
        posts.forEach(p -> p.setScheduled(false));
        posts.forEach((p -> postDataInter.save(p)));
    }
}
