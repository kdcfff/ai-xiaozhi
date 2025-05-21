# 智康医助 项目介绍

这是一个基于 Java 的 AI 助手后端服务，使用 LangChain4J 框架构建。该项目旨在提供一个可扩展的架构，支持与 AI 模型进行交互，并实现诸如对话记忆、工具调用等功能。

## 项目特点

- **模块化设计**：项目采用清晰的分层结构，包括控制器、服务、数据访问层等，便于维护和扩展。
- **AI 集成**：通过 LangChain4J 集成了 AI 模型，支持自然语言处理和智能响应生成。
- **对话管理**：支持会话状态管理和多轮对话，确保用户体验流畅。
- **工具调用**：集成了多种实用工具，如预约系统、计算器等，增强 AI 的功能性。
- **持久化支持**：使用 MongoDB 存储聊天记录，确保数据的安全性和可恢复性。

## 技术栈

- **Java**：作为主要开发语言。
- **LangChain4J**：用于集成 AI 模型并处理自然语言。
- **Spring Boot**：提供快速开发框架，简化配置和部署。
- **MongoDB**：用于存储聊天记录和其他非结构化数据。
- **MyBatis**：用于数据库操作。

## 项目结构概览
```
.
├── src
│   ├── main
│   │   ├── java/com/itkd
│   │   │   ├── assistant
│   │   │   │   ├── Assistant.java
│   │   │   │   ├── ChatMemoryAssistant.java
│   │   │   │   ├── SeparateChatAssistant.java
│   │   │   │   └── XiaozhiAgent.java
│   │   │   ├── bean
│   │   │   │   ├── ChatForm.java
│   │   │   │   └── ChatMessages.java
│   │   │   ├── config
│   │   │   │   ├── ChatMemoryConfig.java
│   │   │   │   ├── SeparateChatAssistantConfig.java
│   │   │   │   └── XiaozhiAgentConfig.java
│   │   │   ├── controller
│   │   │   │   ├── HealthController.java
│   │   │   │   └── XiaozhiController.java
│   │   │   ├── entity
│   │   │   │   └── Appointment.java
│   │   │   ├── mapper
│   │   │   │   └── AppointmentMapper.java
│   │   │   ├── service
│   │   │   │   ├── impl
│   │   │   │   │   └── AppointmentServiceImpl.java
│   │   │   │   └── AppointmentService.java
│   │   │   ├── store
│   │   │   │   └── MongoChatMemoryStore.java
│   │   │   ├── tools
│   │   │   │   ├── AppointmentTools.java
│   │   │   │   └── CalculatorTools.java
│   │   │   └── AiBackendApplication.java
│   │   └── resources
│   │       ├── mapper
│   │       │   └── AppointmentMapper.xml
│   │       ├── application.yml
│   │       ├── my-prompt-template.txt
│   │       ├── my-prompt-template3.txt
│   │       └── zhaozhi-prompt-template.txt
│   └── test/java/com/itkd
│       ├── AiServiceTest.java
│       ├── AppointmentServiceTest.java
│       ├── ChatMemoryTest.java
│       ├── MongoCrudTest.java
│       ├── PromptTest.java
│       ├── ToolsTest.java
│       └── testLangchainApi.java
└── pom.xml