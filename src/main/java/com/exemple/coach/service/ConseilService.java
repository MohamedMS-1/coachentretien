package com.exemple.coach.service;
import com.exemple.coach.tools.CoachTools;
import java.util.regex.Pattern;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.stereotype.Service;
@Service
public class ConseilService {
    private static final Pattern ID_VALIDE = Pattern.compile("[A-Za-z0-9_-]{1,50}");
    private final ChatClient chatClient;
    private final CoachTools tools;
    public ConseilService(ChatClient.Builder builder, CoachTools tools) {
        ChatMemory memoire = MessageWindowChatMemory.builder()
                .maxMessages(20)
                .build();
        this.chatClient = builder
                .defaultSystem("""
                    Tu es un coach d'entretien technique bienveillant. Tu réponds en français,
                    de façon concise. Avant de conseiller un thème à réviser, consulte les
                    outils pour connaître la progression réelle du candidat. N'invente jamais
                    de notes.
                    """)
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(memoire).build())
                .build();
        this.tools = tools;
    }
    public String conseiller(String conversationId, String message) {
        if (conversationId == null || !ID_VALIDE.matcher(conversationId).matches()) {
            throw new IllegalArgumentException("Identifiant de conversation invalide");
        }
        return chatClient.prompt()
                .user(message)
                .tools(tools)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, conversationId))
                .call()
                .content();
    }
}
