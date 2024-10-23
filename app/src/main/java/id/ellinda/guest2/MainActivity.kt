package id.ellinda.guest2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.ui.unit.dp
import id.ellinda.guest2.data.Guest
import id.ellinda.guest2.data.guests
import id.ellinda.guest2.ui.theme.Guest2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Guest2Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GuestApp()
                }
            }
        }
    }
}

/**
 * Composable that displays an app bar and a list of guests.
 */
@Composable
fun GuestApp() {
    // Scaffold, layout untuk aplikasi dengan appbar, floating action button, dan konten utama.
    Scaffold(
        topBar = { GuestTopAppBar() }
    ) { innerPadding ->
        // Lazycolumn, untuk menampilkan daftar tamu secara scrollable.
        LazyColumn(contentPadding = innerPadding) {
            items(guests) { guest ->
                GuestItem(
                    guest = guest,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

/**
 * Composable that displays a list item containing a guest's information.
 */
 // Function compossable sebagai UI Layer untuk mendefinisikan tampilan UI 
 // Data layer mengambil data tamu dari guests yang merupakan koleksi dari objek guest. 
@Composable
fun GuestItem(
    guest: Guest,
    modifier: Modifier = Modifier
) {
    // remember { mutableStateOf(false) sebagai state digunakan untuk menyimpan status apakah informasi diperluas atau tidak
    var expanded by remember { mutableStateOf(false) }
    // Card, untuk membungkus setiap item tamu dalam daftar, memberikan tampilan yang terpisah.
    Card(
        modifier = modifier
    ) {
        // Column, untuk menumpuk informasi tamu dan catatan secara vertikal
        Column(
            modifier = Modifier
                .animateContentSize()
        ) {
            // Row, untuk menemoatkan ikon tamu, informasi, dan tombol disatu baris
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                GuestIcon(guest.imageResourceId)
                GuestInformation(guest.name, guest.address)
                Spacer(Modifier.weight(1f))
                GuestItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }
            if (expanded) {
                GuestNote(
                    guest.note,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

/**
 * Composable that displays a button that is clickable and displays an expand more or an expand less
 * icon.
 */
@Composable
private fun GuestItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) { // iconButton untuk menampilkan tombol yang dapat di klik untuk memperluas atau menyusutkan informasi tertentu.
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

/**
 * Composable that displays a Top Bar with an icon and text.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
// Appbar dihasilkan oleh centeraligntopbar dalam guesttopappbar yang menampilkan logo dan nama aplikasi
fun GuestTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Image, menampilkan logo dan gambar foto tamu
                Image(
                    modifier = Modifier.size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.logo), // Ganti dengan logo tamu
                    contentDescription = null
                )
                // Text, untuk menampilkan teks seperti nama tamu, alamat daalam GuestInformation.
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge
                )
            }
        },
        modifier = modifier
    )
}

/**
 * Composable that displays a photo of a guest.
 */
@Composable
fun GuestIcon(@DrawableRes guestIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small)),
        painter = painterResource(guestIcon),
        contentDescription = null
    )
}

/**
 * Composable that displays a guest's name and address.
 */
@Composable
fun GuestInformation(
    @StringRes guestName: Int,
    @StringRes guestAddress: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(guestName),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(guestAddress),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * Composable that displays a guest's note.
 */
@Composable
fun GuestNote(
    @StringRes guestNote: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.about),
            style = MaterialTheme.typography.labelSmall
        )
        Text(
            text = stringResource(guestNote),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

/**
 * Composable that displays a preview of the app.
 */
@Preview
@Composable
fun GuestPreview() {
    Guest2Theme(darkTheme = false) {
        GuestApp()
    }
}

/**
 * Composable that displays a dark theme preview of the app.
 */
@Preview
@Composable
fun GuestDarkThemePreview() {
    Guest2Theme(darkTheme = true) {
        GuestApp()
    }
}
