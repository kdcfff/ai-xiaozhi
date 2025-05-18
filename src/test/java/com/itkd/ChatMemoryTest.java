package com.itkd;

import com.itkd.assistant.Assistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.response.ChatResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
public class ChatMemoryTest {
    @Autowired
    private Assistant assistant;

    @Test
    public void testChatMemory() {
        String answer1 = assistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }

    @Autowired
    private QwenChatModel qwenChatModel;

    /**
     * 简单实现ChatMemory
     */
    @Test
    public void testChatMemory2() {
        UserMessage userMessage = UserMessage.userMessage("我是环环");
        ChatResponse chatResponse = qwenChatModel.chat(userMessage);
        AiMessage aiMessage = chatResponse.aiMessage();
        System.out.println(aiMessage.text());

        //第二轮对话
        UserMessage userMessage2 = UserMessage.userMessage("我是谁");
        ChatResponse chatResponse2 = qwenChatModel.chat(Arrays.asList(userMessage, aiMessage, userMessage2));
        System.out.println(chatResponse2.aiMessage().text());
    }

}