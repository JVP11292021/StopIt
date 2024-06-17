package org.types;

public record StatsGetResponse(
        HealthScale healthLevel,
        int currentStreak,
        int longestStreak,
        double moneySaved
) {}
