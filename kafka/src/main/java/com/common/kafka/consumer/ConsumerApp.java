package com.common.kafka.consumer;

import com.common.kafka.IKafkaConstants;
import com.common.kafka.MessageUnit;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConsumerApp {

    private static Logger logger = LoggerFactory.getLogger(ConsumerApp.class);

    public static void main(String[] args) {
        runConsumer();
    }

    static void runConsumer() {
        Consumer<Integer, MessageUnit> consumer = ConsumerCreator.createConsumer();

        int noMessageFound = 0;
        while (true) {
            ConsumerRecords<Integer, MessageUnit> consumerRecords = consumer.poll(10);
            // 1000 is the time in milliseconds consumer will wait if no record is found at broker.
            if (consumerRecords.count() == 0) {
                noMessageFound++;
                if (noMessageFound > IKafkaConstants.MAX_NO_MESSAGE_FOUND_COUNT)
                    // If no message found count is reached to threshold exit loop.
                    break;
                else
                    continue;
            }
            //print each record.
            consumerRecords.forEach(ConsumerApp::process);
            // commits the offset of record to broker.
            consumer.commitAsync();
        }
        consumer.close();
    }


    static void process(ConsumerRecord record) {

        doProcess(record); // do the actual work
    }

    static void doProcess(ConsumerRecord record) {
        logger.info("Record Key " + record.key());
        logger.info("Record value " + record.value());
        logger.info("Record partition " + record.partition());
        logger.info("Record offset " + record.offset());
        MessageUnit messageUnit = (MessageUnit) record.value();

//        String id = restTemplate.postForObject(url, messageUnit, String.class);
//        logger.info("workflow id is {}", id);
    }
}
