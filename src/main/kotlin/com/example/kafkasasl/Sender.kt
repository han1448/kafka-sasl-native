package com.example.kafkasasl

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class Sender(
    private val producer: KafkaTemplate<String, String>
) {

    @PostConstruct
    fun send() {
        producer.send("testkafka-v1", "data")
        println("send completed")
    }
}
