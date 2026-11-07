package com.exemple.coach.repository;
import com.exemple.coach.dto.ProgressionTheme;
import com.exemple.coach.model.Resultat;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface ResultatRepository extends JpaRepository<Resultat, Long> {
    @Query("""
           select new com.exemple.coach.dto.ProgressionTheme(
                  r.theme, avg(r.note), count(r))
           from Resultat r
           group by r.theme
           order by avg(r.note) asc
           """)
    List<ProgressionTheme> progressionParTheme();
}