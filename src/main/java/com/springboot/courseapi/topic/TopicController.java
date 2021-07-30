package com.springboot.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> allTopics(){
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id){
        return topicService.singleTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topics")
    public String crateTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
        return topic.getId();
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id){
        topicService.updateTopic(id,topic);
    }
}
