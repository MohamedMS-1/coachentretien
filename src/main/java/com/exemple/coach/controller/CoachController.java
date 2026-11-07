package com.exemple.coach.controller;
import com.exemple.coach.dto.Evaluation;
import com.exemple.coach.dto.ProgressionTheme;
import com.exemple.coach.dto.Question;
import com.exemple.coach.dto.ReponseRequest;
import com.exemple.coach.service.CoachService;
import com.exemple.coach.service.ConseilService;
import com.exemple.coach.service.ProgressionService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.*;
@RestController
public class CoachController {
    private final CoachService coachService;
    private final ProgressionService progressionService;
    private final ConseilService conseilService;
    public CoachController(CoachService coachService,
                           ProgressionService progressionService,
                           ConseilService conseilService) {
        this.coachService = coachService;
        this.progressionService = progressionService;
        this.conseilService = conseilService;
    }
    @GetMapping("/question")
    public Question question(@RequestParam String theme) {
        return coachService.genererQuestion(theme);
    }
    @PostMapping("/reponse")
    public Evaluation reponse(@Valid @RequestBody ReponseRequest requete) {
        return coachService.evaluer(requete.theme(), requete.question(), requete.reponse());
    }
    @GetMapping("/progression")
    public List<ProgressionTheme> progression() {
        return progressionService.progression();
    }
    @GetMapping("/conseil/{id}")
    public String conseil(@PathVariable String id, @RequestParam String message) {
        return conseilService.conseiller(id, message);
    }
}