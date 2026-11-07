package com.exemple.coach.service;
import com.exemple.coach.dto.IngestionResponse;
import com.exemple.coach.util.ThemeUtils;
import java.util.List;
import java.util.Map;
import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;
@Service
public class DocumentService {
    private final VectorStore vectorStore;
    public DocumentService(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }
    
    public IngestionResponse ingerer(String theme, String texte) {
        String t = ThemeUtils.normaliser(theme);
        Document document = new Document(texte, Map.of("theme", t));
        List<Document> morceaux = new TokenTextSplitter().apply(List.of(document));
        vectorStore.add(morceaux);
        return new IngestionResponse(t, morceaux.size());
    }
}