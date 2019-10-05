package com.amyliascarlet.javademo.kafka;

import kafka.producer.KeyedMessage;
import kafka.producer.Producer;
import kafka.producer.ProducerConfig;
import scala.collection.Seq;

import java.util.Date;
import java.util.Properties;

public class kfkProducer extends Thread {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("metadata.broker.list", "127.0.0.1:2189");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("key.serializer.class", "kafka.serializer.StringEncoder");
        props.put("request.required.acks", "1");

        //配置key的序列化类
        ProducerConfig config = new ProducerConfig(props);
        Producer<String, String> producer = new Producer<>(config);
        long runtime = new Date().getTime();

        String msg = String.valueOf(runtime);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>("test", "test-key",msg);
        producer.send((Seq<KeyedMessage<String, String>>) data);
    }
}