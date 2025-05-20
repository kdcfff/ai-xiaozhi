package com.itkd.config;


import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatMemoryConfig {

    @Bean
    public MessageWindowChatMemory chatMemory(){
        return MessageWindowChatMemory.withMaxMessages(10);
    }
}
