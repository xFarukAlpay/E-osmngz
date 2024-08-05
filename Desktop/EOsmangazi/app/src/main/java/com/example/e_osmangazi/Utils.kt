package com.example.e_osmangazi

import org.apache.commons.text.similarity.LevenshteinDistance

fun findBestMatch(input: String, responses: Map<String, String>): String {
    val levenshtein = LevenshteinDistance()
    var bestMatch = ""
    var minDistance = Int.MAX_VALUE

    // Girdi metnini normalize et
    val cleanedInput = input.lowercase().trim()

    for (key in responses.keys) {
        // Anahtar kelimeyi normalize et
        val cleanedKey = key.lowercase().trim()
        // Levenshtein mesafesini hesapla
        val distance = levenshtein.apply(cleanedInput, cleanedKey)

        if (distance < minDistance) {
            minDistance = distance
            bestMatch = key
        }
    }

    // En yakın eşleşmeyi bul
    return responses[bestMatch] ?: "Üzgünüm, anlayamadım."
}
