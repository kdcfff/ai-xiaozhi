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
        String hello = openAiChatModel.chat("你好，你是deepseek吗");
        System.out.println(hello);
    }
    @Autowired
    private QwenChatModel qwenChatModel;
    @Test
    public void qweniApi(){
        String chat = qwenChatModel.chat("你好,你是谁");
        System.out.println(chat);
    }

    @Autowired
    private Environment env;
    @Test
    public void dashApi(){
        System.out.println(env.getProperty("langchain4j.community.dashscope.chat-model.apikey"));
    }
    @Test
    public void wanxApi(){
        WanxImageModel wanxImageModel = WanxImageModel.builder()
                .apiKey(env.getProperty("langchain4j.community.dashscope.chat-model.apikey"))
                .modelName("wanx2.1-t2i-turbo")
                .build();
        Response<Image> imageResponse = wanxImageModel.generate("奇幻森林精灵：在一片弥漫着轻柔薄雾的古老森林深处，阳光透过茂密枝叶洒下金色光斑。一位身材娇小、长着透明薄翼的精灵少女站在一朵硕大的蘑菇上。她有着海藻般的绿色长发，发间点缀着蓝色的小花，皮肤泛着珍珠般的微光。身上穿着由翠绿树叶和白色藤蔓编织而成的连衣裙，手中捧着一颗散发着柔和光芒的水晶球，周围环绕着五彩斑斓的蝴蝶，脚下是铺满苔藓的地面，蘑菇和蕨类植物丛生，营造出神秘而梦幻的氛围。");
        System.out.println(imageResponse.content().url());
    }

}
