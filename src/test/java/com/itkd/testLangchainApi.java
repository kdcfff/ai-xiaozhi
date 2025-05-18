package com.itkd;

import dev.langchain4j.community.model.dashscope.QwenChatModel;
import dev.langchain4j.community.model.dashscope.WanxImageModel;
import dev.langchain4j.data.image.Image;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.output.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

@SpringBootTest
public class testLangchainApi {
    /**
     * 测试类中的主方法，用于演示如何使用OpenAiChatModel进行聊天
     * 此方法构建了一个OpenAiChatModel实例，并使用该实例发送一个简单的问候消息
     *
     * @param args 命令行参数，本例中未使用
     */
    @Test
    public void main(String[] args) {
        // 构建一个OpenAiChatModel实例，配置必要的参数
        OpenAiChatModel model = OpenAiChatModel.builder()
                .baseUrl("http://langchain4j.dev/demo/openai/v1") // 设置基础URL
                .apiKey("demo") // 设置API密钥
                .modelName("gpt-4o-mini") // 设置模型名称
                .build();

        // 使用构建好的模型实例进行聊天，发送一个"Hello"消息
        String message = model.chat("Hello");

        // 打印模型返回的消息
        System.out.println(message);
    }


    @Autowired
    private OpenAiChatModel openAiChatModel;

    @Test
    public void testLangchainApi() {
        String hello = openAiChatModel.chat("你好，你是deepseek吗");
        System.out.println(hello);
    }

    @Autowired
    private QwenChatModel qwenChatModel;

    @Test
    public void qweniApi() {
        String chat = qwenChatModel.chat("你好,你是谁");
        System.out.println(chat);
    }

    @Autowired
    private Environment env;

    @Test
    public void dashApi() {
        System.out.println(env.getProperty("langchain4j.community.dashscope.chat-model.apikey"));
    }

    @Test
    public void wanxApi() {
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .apiKey(env.getProperty("langchain4j.community.dashscope.chat-model.apikey"))
                .modelName("wanx2.1-t2i-turbo")
                .build();
        Response<Image> imageResponse = wanxImageModel.generate("奇幻森林精灵：在一片弥漫着轻柔薄雾的古老森林深处，阳光透过茂密枝叶洒下金色光斑。一位身材娇小、长着透明薄翼的精灵少女站在一朵硕大的蘑菇上。她有着海藻般的绿色长发，发间点缀着蓝色的小花，皮肤泛着珍珠般的微光。身上穿着由翠绿树叶和白色藤蔓编织而成的连衣裙，手中捧着一颗散发着柔和光芒的水晶球，周围环绕着五彩斑斓的蝴蝶，脚下是铺满苔藓的地面，蘑菇和蕨类植物丛生，营造出神秘而梦幻的氛围。");
        System.out.println(imageResponse.content().url());
    }

}
