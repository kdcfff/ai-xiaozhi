package com.itkd;

import com.itkd.assistant.Assistant;
import com.itkd.assistant.ChatMemoryAssistant;
import com.itkd.assistant.SeparateChatAssistant;
import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.service.AiServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * 测试ChatMemory
 */
@SpringBootTest
public class ChatMemoryTest {
    @Autowired
    private Assistant assistant;

    /**
     * 通过Assistant调用ChatMemory
     */
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
     * 简单实现ChatMemory 不用assistant即AiService
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

    @Test
    public void testChatMemory3() {
        //创建chatMemory
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        //创建AIService
        Assistant assistant = AiServices
                .builder(Assistant.class)
                .chatLanguageModel(qwenChatModel)
                .chatMemory(chatMemory)
                .build();
        //调用service的接口
        String answer1 = assistant.chat("我是环环");
        System.out.println(answer1);
        String answer2 = assistant.chat("我是谁");
        System.out.println(answer2);
    }

    /**
     * 测试ChatMemoryAssistant，测试是否有聊天记录
     */
    @Autowired
    ChatMemoryAssistant chatMemoryAssistant;
    @Test
    public void testChatMemory4() {
        String chat = chatMemoryAssistant.chat("我是环环");
        System.out.println(chat);
        String chat1 = chatMemoryAssistant.chat("我是谁");
        System.out.println(chat1);
    }

    @Autowired
    SeparateChatAssistant separateChatAssistant;
    @Test
    public void testChatMemory5() {
        String chat = separateChatAssistant.chat(1, "我是环环");
        System.out.println(chat);
        String chat1 = separateChatAssistant.chat(1, "我是谁");
        System.out.println(chat1);

        //其他用户
        String chat2 = separateChatAssistant.chat(2, "我是谁");
        System.out.println(chat2);
    }

}