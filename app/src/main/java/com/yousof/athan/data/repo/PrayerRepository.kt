// package com.yousof.athan.data.repo
//
//
// import com.yousof.athan.data.local.AppDatabase
// import com.yousof.athan.data.local.MetaEntity
// import com.yousof.athan.data.remote.PrayerApi
// import java.time.LocalDate
// import java.util.TimeZone
// import kotlin.math.max
//
// class PrayerRepository(
//    private val db: AppDatabase,
//    private val api: PrayerApi,
//    private val clock: () -> Long = { System.currentTimeMillis() / 1000 } // Epoch Sekunden
// ) {
//    private val prayerDao = db.prayerDao()
//    private val metaDao = db.metaDao()
//
//    // stabiler Schlüssel pro Ort + Methode (z. B. "52.5200,13.4050|MWL")
//    private fun locationKey(lat: Double, lng: Double, method: String): String =
//        "${"%.4f".format(lat)},${"%.4f".format(lng)}|$method"
//
//    // prüft anhand Policy, ob ein Refresh nötig ist
//    private fun shouldRefresh(lastSyncEpochSec: Long?, policy: CachePolicy): Boolean {
//        val now = clock()
//        val ageDays = if (lastSyncEpochSec == null) Int.MAX_VALUE
//        else max(0, ((now - lastSyncEpochSec) / 86_400).toInt())
//
//        val thresholdDays = when (policy.frequency) {
//            RefreshFrequency.DAILY -> 1
//            RefreshFrequency.WEEKLY -> 7
//            RefreshFrequency.MONTHLY -> 30
//            RefreshFrequency.YEARLY -> 365
//            RefreshFrequency.NEVER -> Int.MAX_VALUE
//            RefreshFrequency.CUSTOM_DAYS -> policy.customDays?.coerceAtLeast(1) ?: 30
//        }
//        return ageDays >= thresholdDays
//    }
//
//    /**
//     * Holt bei Bedarf (Policy/force) die Monatsdaten aus der API, speichert sie,
//     * und liefert anschließend IMMER die Daten aus Room.
//     */
//    suspend fun getMonth(
//        year: Int,
//        month: Int,
//        lat: Double,
//        lng: Double,
//        method: String,
//        policy: CachePolicy,
//        forceRefresh: Boolean = false // manueller „Jetzt aktualisieren“-Schalter
//    ) = run {
//        val key = locationKey(lat, lng, method)
//        val meta = metaDao.get(key)
//
//        val needsRefresh = forceRefresh || shouldRefresh(meta?.lastFullSyncEpochSec, policy)
//
//        if (needsRefresh) {
//            val dtos = api.getMonthlyByCity(year, month, lat.toString(), lng.toString(), method)
//            val now = clock()
//          //  val entities = dtos.map { it.toEntity(key, method, now) } // <- Extension aus Schritt 5
//
//            // upsert (Unique-Index (date, locationKey) verhindert Duplikate)
//         //   prayerDao.upsertAll(entities)
//
//            // Meta aktualisieren
//            metaDao.upsert(
//                MetaEntity(
//                    locationKey = key,
//                    timezoneId = TimeZone.getDefault().id,
//                    method = method,
//                    lastFullSyncEpochSec = now
//                )
//            )
//        }
//
//        val from = LocalDate.of(year, month, 1)
//        val to = from.withDayOfMonth(from.lengthOfMonth())
//        prayerDao.getRange(key, from, to)
//    }
//
//    suspend fun getDay(
//        date: LocalDate,
//        lat: Double,
//        lng: Double,
//        method: String,
//        policy: CachePolicy,
//        forceRefresh: Boolean = false
//    ) = getMonth(date.year, date.monthValue, lat, lng, method, policy, forceRefresh)
//        .firstOrNull { it.date == date }
// }
