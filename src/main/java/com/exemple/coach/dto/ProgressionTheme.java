// ProgressionTheme.java  (wrappers Double/Long exigés par la requête JPQL)
package com.exemple.coach.dto;
public record ProgressionTheme(String theme, Double moyenne, Long nombre) {}