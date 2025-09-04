
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.yousof.athan.data.local.PrayerTimeEntity
import java.time.LocalDate

@Dao
interface PrayerTimesDao {
    @Query(
        """
        SELECT * FROM prayer_times
        WHERE locationKey = :loc AND date BETWEEN :from AND :to
        ORDER BY date ASC
    """,
    )
    suspend fun getRange(
        loc: String,
        from: LocalDate,
        to: LocalDate,
    ): List<PrayerTimeEntity>

    @Query(
        """
        SELECT * FROM prayer_times
        WHERE locationKey = :loc AND date = :date
        LIMIT 1
    """,
    )
    suspend fun getByDate(
        loc: String,
        date: LocalDate,
    ): PrayerTimeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAll(items: List<PrayerTimeEntity>)
}
