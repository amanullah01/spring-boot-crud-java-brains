package com.springboot.courseapi.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring","Spring Framework", "Details of spring framework."),
            new Topic("java","Java 8", "Details of Java 8."),
            new Topic("javaScript","javaScript lang", "Details of javaScript."),
            new Topic("php","PHP", "Details of PHP.")
    ));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic singleTopic(String id){
        return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topics.add(topic);
    }
}
