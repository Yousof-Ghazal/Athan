package com.yousof.athan.data.repo

import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Locale

/**
 * Versucht typische Zeit-Formate zu parsen:
 * - "04:18"
 * - "4:18"
 * - "04:18 AM" / "4:18 pm"
 * - "04:18 (CEST)" -> Klammern werden ignoriert
 */
private fun parseLocalTimeFlexible(input: String): LocalTime {
    val clean =
        input
            .replace(Regex("\\(.*?\\)"), "") // Dinge in Klammern entfernen
            .trim()
            .replace("  ", " ")

    val patterns =
        listOf(
            DateTimeFormatter.ofPattern("H:mm", Locale.US),
            DateTimeFormatter.ofPattern("HH:mm", Locale.US),
            DateTimeFormatter.ofPattern("h:mm a", Locale.US),
            DateTimeFormatter.ofPattern("hh:mm a", Locale.US),
        )

    for (fmt in patterns) {
        runCatching { return LocalTime.parse(clean.uppercase(Locale.US), fmt) }
    }
    // Letzter Versuch: ISO
    return LocalTime.parse(clean)
}

/**
 * Versucht typische Datums-Formate zu parsen:
 * - "2025-08-14" (ISO)
 * - "14-08-2025"
 * - "08/14/2025"
 */
private fun parseLocalDateFlexible(input: String): LocalDate {
    val candidates =
        listOf(
            null,
            DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.US),
            DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.US),
        )

    // Erst versuchen wir ISO
    runCatching { return LocalDate.parse(input) }

    // Dann die bekannten Muster
    candidates.filterNotNull().forEach { fmt ->
        runCatching { return LocalDate.parse(input, fmt) }
    }

    throw DateTimeParseException("Unbekanntes Datumsformat", input, 0)
}
