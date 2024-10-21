//package id.ellinda.guest.viewmodel
//
//import androidx.compose.runtime.mutableStateListOf
//import androidx.lifecycle.ViewModel
//import id.ellinda.guest.R
//import id.ellinda.guest.model.GuestBook
//import id.ellinda.guest.model.Guestbooks
//
//class GuestBookViewModel : ViewModel() {
//    private val _guestList = mutableStateListOf<GuestBook>()
//    val guestList: List<GuestBook> = _guestList
//
//    init {
//        // Initialize with predefined guests if needed
//        _guestList.addAll(Guestbooks)
//    }
//
//    fun addGuest(nameResourceId: Int, messageResourceId: Int) {
//        val newGuest = GuestBook(id = _guestList.size + 1, name = nameResourceId, message = messageResourceId)
//        _guestList.add(newGuest)
//    }
//}


package id.ellinda.guest.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import id.ellinda.guest.R
import id.ellinda.guest.model.GuestBook
import id.ellinda.guest.model.Guestbooks // Make sure this is defined correctly

class GuestBookViewModel : ViewModel() {
    private val _guestList = mutableStateListOf<GuestBook>()
    val guestList: List<GuestBook> = _guestList

    init {
        // Initialize with predefined guests if needed
        _guestList.addAll(Guestbooks)
    }

    fun addGuest(nameResourceId: Int, messageResourceId: Int) {
        val newGuest = GuestBook(id = _guestList.size + 1, name = nameResourceId, message = messageResourceId)
        _guestList.add(newGuest)
    }
}
