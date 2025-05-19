package com.itkd;

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
}
