package com.exemple.coach.service;
import com.exemple.coach.dto.ProgressionTheme;
import com.exemple.coach.model.Resultat;
import com.exemple.coach.repository.ResultatRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProgressionService {
    private final ResultatRepository repository;
    public ProgressionService(ResultatRepository repository) {
        this.repository = repository;
    }
    public void enregistrer(String theme, String question, int note) {
        repository.save(new Resultat(theme, question, note));
    }
    public List<ProgressionTheme> progression() {
        return repository.progressionParTheme();
    }
    public Optional<String> themeLePlusFaible() {
        return progression().stream().findFirst().map(ProgressionTheme::theme);
    }
}
