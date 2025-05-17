package com.itkd;

import dev.langchain4j.model.openai.OpenAiChatModel;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testLangchainApi {
    @Test
    public void main(String[] args) {
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1")
                .apiKey("demo")
                .modelName("gpt-4o-mini")
                .build();
        String message = model.chat("Hello");
        System.out.println(message);
    }

    @Autowired
    private OpenAiChatModel openAiChatModel;
    @Test
    public void testLangchainApi(){
        String hello = openAiChatModel.chat("Hello");
        System.out.println(hello);
    }
}
