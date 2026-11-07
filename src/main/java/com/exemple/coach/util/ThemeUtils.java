package com.exemple.coach.util;

import java.util.Locale;
import java.util.regex.Pattern;

public final class ThemeUtils {
    private static final Pattern VALIDE = Pattern.compile("[a-z0-9-]{1,30}");
    private ThemeUtils() {}
    /** Normalise un thème (minuscules) et refuse tout caractère inattendu. */
    public static String normaliser(String theme) {
        if (theme == null) {
            throw new IllegalArgumentException("Le thème est obligatoire");
        }
        String t = theme.trim().toLowerCase(Locale.ROOT);
        if (!VALIDE.matcher(t).matches()) {
            throw new IllegalArgumentException(
                "Thème invalide : 1 à 30 caractères parmi a-z, 0-9 et -");
        }
        return t;
    }
}