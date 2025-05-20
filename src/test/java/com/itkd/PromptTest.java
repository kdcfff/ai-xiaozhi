package com.itkd;

import com.itkd.assistant.ChatMemoryAssistant;
import com.itkd.assistant.SeparateChatAssistant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PromptTest {
    @Autowired
    SeparateChatAssistant separateChatAssistant;
    @Test
    public void testPrompt() {
        String answer = separateChatAssistant.chat(3, "你好,我有鼻窦炎");
        System.out.println(answer);
    }
    @Test
    public void testPrompt1() {
        String answer = separateChatAssistant.chat(4, "现在什么时间");
        System.out.println(answer);
    }
    @Test
    public void testPrompt2() {
        String answer = separateChatAssistant.chat(5, "现在什么时间，我有点头疼挂什么科室");
        System.out.println(answer);
    }
    @Autowired
    ChatMemoryAssistant chatMemoryAssistant;
    @Test
    public void testUserPrompt() {
        String answer = chatMemoryAssistant.chat("现在什么时间");
        System.out.println(answer);
    }

    @Test
    public void testUserInfo() {
        String answer = separateChatAssistant.chat3(20, "我是谁， 我多大了", "翠花", 18);
        System.out.println(answer);
    }
}
