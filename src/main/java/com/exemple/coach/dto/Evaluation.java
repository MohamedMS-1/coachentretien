package com.exemple.coach.dto;
import java.util.List;
public record Evaluation(int note, List<String> pointsForts,
                         List<String> pointsManquants, String correction) {}
