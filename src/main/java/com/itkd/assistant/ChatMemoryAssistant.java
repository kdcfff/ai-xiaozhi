package com.itkd.assistant;

import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

/**
 * 单用户聊天记忆
 */
@AiService(
        wiringMode = EXPLICIT,
        chatModel = "qwenChatModel",
        chatMemory = "chatMemory")
public interface ChatMemoryAssistant {
    @UserMessage("你是我的好朋友， 请用上海话回答问题， 并且添加一些表情符号。 {{it}}") //{{it}}表示这里
    String chat(String userMessage);
}
