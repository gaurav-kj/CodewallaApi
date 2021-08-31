package CodewallaApi.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicControler {
    @Autowired
    private TopicService topicService;

    @RequestMapping(method = RequestMethod.GET,value = "/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }
    @RequestMapping(method = RequestMethod.GET ,value="/topics/{id}")
    public Topic getTopic(@PathVariable int id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topic")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable int id){
        topicService.updateTopic(topic,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void updateTopic(@PathVariable int id){
        topicService.deleteTopic(id);
    }

    @PostMapping("/topics")
    public void addTopics(@RequestBody List<Topic> topics){
        topicService.addMultipleTopics(topics);
    }


}
