package com.common.kafka.producer;

import com.common.kafka.IKafkaConstants;
import com.common.kafka.MessageUnit;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class ProducerApp {
    static private Producer<Integer, MessageUnit> producer = ProducerCreator.createProducer();
    static private String version = "2";

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                version = br.readLine();
                System.out.println("received command");
                if (!StringUtils.isEmpty(version) || null == version) {
                    runProducer();
                } else
                    break;
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void runProducer() {

        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
            // Put the span in "scope" so that downstream code such as loggers can see trace IDs

            publish(ProducerCreator.createProducer(), index);

        }
    }

    static void publish(Producer<Integer, MessageUnit> tracingProducer, int index) {
        MessageUnit messageUnit = new MessageUnit();
//        messageUnit.setName("sutao_test_wf_1");
//        messageUnit.setVersion(version);
        HashMap input = new HashMap<>();
//        messageUnit.setInput(input);
        ProducerRecord<Integer, MessageUnit> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, index, messageUnit);
        try {
            RecordMetadata metadata = tracingProducer.send(record).get();
            System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                    + " with offset " + metadata.offset());
            Thread.sleep(2000l);
        } catch (ExecutionException e) {
            System.out.println("Error in sending record");
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println("Error in sending record");
            System.out.println(e);
        }
    }
}
