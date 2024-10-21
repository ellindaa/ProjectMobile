package id.ellinda.guest.model

import id.ellinda.guest.R

data class GuestBook(
    val id: Int,
    val name: Int,
    val message: Int
)

val Guestbooks = listOf(
    GuestBook(R.drawable.nobita, R.string.guest_name_1, R.string.guest_address_1),
    GuestBook(R.drawable.shizuka, R.string.guest_name_2, R.string.guest_address_2),
    GuestBook(R.drawable.suneo, R.string.guest_name_3, R.string.guest_address_3),
    GuestBook(R.drawable.giant, R.string.guest_name_4, R.string.guest_address_4),
    GuestBook(R.drawable.doraemon, R.string.guest_name_5, R.string.guest_address_5),
    GuestBook(R.drawable.tamako, R.string.guest_name_6, R.string.guest_address_6),
    GuestBook(R.drawable.guru, R.string.guest_name_7, R.string.guest_address_7),
    GuestBook(R.drawable.nobisuke, R.string.guest_name_8, R.string.guest_address_8)
)