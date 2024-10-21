//package id.ellinda.guest
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import id.ellinda.guest.viewmodel.GuestBookViewModel // Ensure the import path is correct
//import id.ellinda.guest.model.GuestBook
//import androidx.compose.ui.res.stringResource
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            GuestBookApp()
//        }
//    }
//}
//
//@Composable
//fun GuestBookApp() {
//    val viewModel = remember { GuestBookViewModel() }
//    var name by remember { mutableStateOf(TextFieldValue()) }
//    var message by remember { mutableStateOf(TextFieldValue()) }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(title = {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_launcher_foreground), // Update with your drawable ID
//                        contentDescription = "Logo",
//                        modifier = Modifier.size(40.dp)
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Text("Buku Tamu")
//                }
//            })
//        }
//    ) { innerPadding ->
//        Column(modifier = Modifier.padding(innerPadding)) {
//            Row(modifier = Modifier.padding(16.dp)) {
//                TextField(
//                    value = name,
//                    onValueChange = { name = it },
//                    label = { Text("Nama") },
//                    modifier = Modifier.weight(1f)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                TextField(
//                    value = message,
//                    onValueChange = { message = it },
//                    label = { Text("Pesan") },
//                    modifier = Modifier.weight(2f)
//                )
//            }
//            Button(
//                onClick = {
//                    // Assuming you have corresponding string resource IDs for name and message
//                    viewModel.addGuest(R.string.guest_name_placeholder, R.string.guest_message_placeholder) // Replace with actual resource IDs
//                    name = TextFieldValue()
//                    message = TextFieldValue()
//                },
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text("Tambah")
//            }
//            LazyColumn {
//                items(viewModel.guestList) { guest ->
//                    GuestCard(guest)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun GuestCard(guest: GuestBook) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .height(100.dp),
//        elevation = 4.dp
//    ) {
//        Row(modifier = Modifier.padding(16.dp)) {
//            Image(
//                painter = painterResource(id = R.drawable.ic_launcher_foreground), // Update with your drawable ID
//                contentDescription = "User Avatar",
//                modifier = Modifier.size(40.dp)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Column {
//                Text(text = stringResource(guest.name), style = MaterialTheme.typography.h6) // Use stringResource for displaying name
//                Text(text = stringResource(guest.message), style = MaterialTheme.typography.body2) // Use stringResource for displaying message
//            }
//        }
//    }
//}




//package id.ellinda.guest
//
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.text.input.TextFieldValue
//import androidx.compose.ui.unit.dp
//import id.ellinda.guest.viewmodel.GuestBookViewModel
//import id.ellinda.guest.model.GuestBook
//import androidx.compose.ui.res.stringResource
//import id.ellinda.guest.ui.theme.GuestTheme
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            GuestTheme {
//                Surface (
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    GuestBookApp()
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun GuestBookApp() {
//    val viewModel = remember { GuestBookViewModel() }
//    var name by remember { mutableStateOf(TextFieldValue()) }
//    var message by remember { mutableStateOf(TextFieldValue()) }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(title = {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Image(
//                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
//                        contentDescription = "Logo",
//                        modifier = Modifier.size(40.dp)
//                    )
//                    Spacer(modifier = Modifier.width(8.dp))
//                    Text("Buku Tamu")
//                }
//            }
//            )
//        }
//    ) { innerPadding ->
//        Column(modifier = Modifier.padding(innerPadding)) {
//            Row(modifier = Modifier.padding(16.dp)) {
//                TextField(
//                    value = name,
//                    onValueChange = { name = it },
//                    label = { Text("Nama") },
//                    modifier = Modifier.weight(1f)
//                )
//                Spacer(modifier = Modifier.width(8.dp))
//                TextField(
//                    value = message,
//                    onValueChange = { message = it },
//                    label = { Text("Pesan") },
//                    modifier = Modifier.weight(2f)
//                )
//            }
//            Button(
//                onClick = {
//                    // Assuming you have actual resource IDs for name and message
//                    viewModel.addGuest(R.string.guest_name_1, R.string.guest_address_1) // Replace with actual resource IDs
//                    name = TextFieldValue() // Reset input
//                    message = TextFieldValue() // Reset input
//                },
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text("Tambah")
//            }
//            LazyColumn {
//                items(viewModel.guestList) { guest ->
//                    GuestCard(guest)
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun GuestCard(guest: GuestBook) {
//    Card(
//        modifier = Modifier
//            .padding(8.dp)
//            .fillMaxWidth()
//            .height(100.dp),
//        elevation = 4.dp
//    ) {
//        Row(modifier = Modifier.padding(16.dp)) {
//            Image(
//                painter = painterResource(id = R.drawable.doraemon), // Update with your drawable ID
//                contentDescription = "User Avatar",
//                modifier = Modifier.size(40.dp)
//            )
//            Spacer(modifier = Modifier.width(8.dp))
//            Column {
//                Text(text = stringResource(guest.name), style = MaterialTheme.typography.h6)
//                Text(text = stringResource(guest.message), style = MaterialTheme.typography.body2)
//            }
//        }
//    }
//}



package id.ellinda.guest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import id.ellinda.guest.viewmodel.GuestBookViewModel
import id.ellinda.guest.model.GuestBook
import androidx.compose.ui.res.stringResource
import id.ellinda.guest.ui.theme.GuestTheme
import androidx.compose.animation.core.spring
import androidx.compose.animation.animateContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GuestTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GuestBookApp()
                }
            }
        }
    }
}

@Composable
fun GuestBookApp() {
    val viewModel = remember { GuestBookViewModel() }
    var name by remember { mutableStateOf(TextFieldValue()) }
    var message by remember { mutableStateOf(TextFieldValue()) }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = "Logo",
                        modifier = Modifier.size(40.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Buku Tamu")
                }
            })
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Row(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Nama") },
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.width(8.dp))
                TextField(
                    value = message,
                    onValueChange = { message = it },
                    label = { Text("Pesan") },
                    modifier = Modifier.weight(2f)
                )
            }
            Button(
                onClick = {
                    // Assuming you have actual resource IDs for name and message
                    viewModel.addGuest(R.string.guest_name_1, R.string.guest_address_1) // Replace with actual resource IDs
                    name = TextFieldValue() // Reset input
                    message = TextFieldValue() // Reset input
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text("Tambah")
            }
            LazyColumn {
                items(viewModel.guestList) { guest ->
                    GuestCard(guest)
                }
            }
        }
    }
}

@Composable
fun GuestCard(guest: GuestBook) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .animateContentSize(animationSpec = spring())
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.doraemon), // Update with your drawable ID
                    contentDescription = "User Avatar",
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = stringResource(guest.name), style = MaterialTheme.typography.h6)
                    Text(text = stringResource(guest.message), style = MaterialTheme.typography.body2)
                }
                IconButton(onClick = { expanded = !expanded }) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand/Collapse"
                    )
                }
            }
            if (expanded) {
                // Display additional details, like guest's hobbies or any extra info
                Text(
                    text = "Additional Info Here", // Replace with actual data if needed
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
                )
            }
        }
    }
}

