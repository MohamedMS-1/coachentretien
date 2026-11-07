package com.exemple.coach.tools;
import com.exemple.coach.dto.ProgressionTheme;
import com.exemple.coach.service.ProgressionService;
import java.util.List;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class CoachTools {
    private final ProgressionService progression;
    public CoachTools(ProgressionService progression) {
        this.progression = progression;
    }
    @Tool(description = "Retourne, pour chaque thème, la moyenne des notes sur 10 "
            + "et le nombre de réponses déjà évaluées")
    public List<ProgressionTheme> progression() {
        return progression.progression();
    }
    @Tool(description = "Retourne le thème où le candidat a la moyenne la plus faible, "
            + "ou 'aucun' s'il n'a encore répondu à aucune question")
    public String prochainTheme() {
        return progression.themeLePlusFaible().orElse("aucun");
    }
}
