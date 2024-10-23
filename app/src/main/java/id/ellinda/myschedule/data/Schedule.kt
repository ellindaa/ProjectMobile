package id.ellinda.myschedule.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import id.ellinda.myschedule.R

data class Schedule(
    @DrawableRes val imageResourceId: Int, // Menyimpan gambar
    @StringRes val name: Int, // Nama mata kuliah
    val room: String, // Ruangan
    val sks: Int,  // SKS
    @StringRes val timeArray: Int // Menggunakan Int untuk merujuk ke string array resource
)

val schedules = listOf(
    Schedule(R.drawable.monday, R.string.hari_1, "T.3.2", 3, R.array.monday_schedule),
    Schedule(R.drawable.tuesday, R.string.hari_2, "S.2.2", 8, R.array.tuesday_schedule),
    Schedule(R.drawable.wednesday, R.string.hari_3, "S.3.1", 6, R.array.wednesday_schedule),
    Schedule(R.drawable.thursday, R.string.hari_4, "S.2.3", 6, R.array.thursday_schedule),
    Schedule(R.drawable.friday, R.string.hari_5, "T.3.1", 1, R.array.friday_schedule)
)
