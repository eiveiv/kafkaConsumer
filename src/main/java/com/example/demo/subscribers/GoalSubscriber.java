package com.example.demo.subscribers;

import com.example.demo.db.GoalDao;
import com.example.demo.model.GoalUpdate;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Properties;

@Component
public class GoalSubscriber {

    @Autowired
    private GoalDao goalDao;

    @Value("${broker.server}")
    private String server;

    @Value("${kafka.serializer}")
    private String serializer;

    @PostConstruct
    public void init() {

        Gson gson = new Gson();

        System.out.println("Started this shit");

        Properties props = new Properties();
        props.put("bootstrap.servers", server);
        props.put("key.deserializer", serializer);
        props.put("value.deserializer", serializer);
        props.put("group.id", "test");

        KafkaConsumer myConsumer = new KafkaConsumer(props);

        ArrayList<String> topics = new ArrayList<String>();
        topics.add("goal_topic");

        myConsumer.subscribe(topics);

        try {
            while (true) {
                ConsumerRecords<String, String> records = myConsumer.poll(10);
                for (ConsumerRecord<String, String> record : records) {
                    GoalUpdate goalUpdate = gson.fromJson(record.value().replace("GoalUpdate", ""), GoalUpdate.class);
                    goalDao.addGoal(goalUpdate);
                }

            }
        } catch (Exception e) {
            System.out.println("Some error" + e);
        } finally {
            myConsumer.close();
        }

    }
}
