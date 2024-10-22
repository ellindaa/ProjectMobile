package id.ellinda.guest2.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import id.ellinda.guest2.R

/**
 * Data class untuk merepresentasikan informasi tamu
 */
data class Guest(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val address: Int,
    @StringRes val note: Int
)

// Daftar tamu dengan data yang diambil dari strings.xml
val guests = listOf(
    Guest(R.drawable.avatar1, R.string.guest_name_1, R.string.guest_address_1, R.string.guest_note_1),
    Guest(R.drawable.avatar2, R.string.guest_name_2, R.string.guest_address_2, R.string.guest_note_2),
    Guest(R.drawable.avatar3, R.string.guest_name_3, R.string.guest_address_3, R.string.guest_note_3),
    Guest(R.drawable.avatar4, R.string.guest_name_4, R.string.guest_address_4, R.string.guest_note_4),
    Guest(R.drawable.avatar5, R.string.guest_name_5, R.string.guest_address_5, R.string.guest_note_5),
    Guest(R.drawable.avatar6, R.string.guest_name_6, R.string.guest_address_6, R.string.guest_note_6),
    Guest(R.drawable.avatar7, R.string.guest_name_7, R.string.guest_address_7, R.string.guest_note_7),
    Guest(R.drawable.avatar8, R.string.guest_name_8, R.string.guest_address_8, R.string.guest_note_8),
    Guest(R.drawable.avatar9, R.string.guest_name_9, R.string.guest_address_9, R.string.guest_note_9)
)
