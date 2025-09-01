package com.yousof.athan.data.repo

enum class RefreshFrequency {
    DAILY,
    WEEKLY,
    MONTHLY,
    NEVER,
    CUSTOM_DAYS,
    YEARLY,
}

data class CachePolicy(
    val frequency: RefreshFrequency,
    val customDays: Int? = null,
)
