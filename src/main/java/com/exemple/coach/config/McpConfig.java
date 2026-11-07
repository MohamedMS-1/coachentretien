package com.exemple.coach.config;
import com.exemple.coach.tools.CoachTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("mcp")
public class McpConfig {
    @Bean
    ToolCallbackProvider coachToolsProvider(CoachTools tools) {
        return MethodToolCallbackProvider.builder().toolObjects(tools).build();
    }
}