package CodewallaApi.Topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>( Arrays.asList(
            new Topic(1,"topic 1","Topic 1 description"),
            new Topic(2,"topic 2","Topic 2 description"),
            new Topic(3,"topic 3","Topic 3 description")
    ));

    public List<Topic> getAllTopics(){
        return topics;
    }

    public  Topic getTopic(int id){
        return topics.stream().filter(t -> t.getId() == id).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, int id) {

        for (int i = 0; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if(t.getId() == id){
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(int id) {
        topics.removeIf(t -> t.getId() == id);
    }

    public void addMultipleTopics(List<Topic> topics) {

        this.topics.addAll(topics);

    }
}
