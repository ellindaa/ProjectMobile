package id.ellinda.myschedule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.unit.sp
// Data Layer
import id.ellinda.myschedule.data.Schedule
import id.ellinda.myschedule.data.schedules
import id.ellinda.myschedule.ui.theme.MyScheduleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyScheduleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ScheduleApp()
                }
            }
        }
    }
}

@Composable
fun ScheduleApp() {
    // Scaffold dalam fungsi ini untuk menampilkan struktur aplikasi yang memiliki TopAppBar
    Scaffold(topBar = { ScheduleTopAppBar() }) { paddingValues ->
        // Lazycolumn digunakan untuk menampilkan daftar jadwal yang bisa di gulir secara vertikal
        LazyColumn(contentPadding = paddingValues) {
            items(schedules) { schedule ->
                ScheduleItem(
                    schedule = schedule,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
fun ScheduleItem(schedule: Schedule, modifier: Modifier = Modifier) {
    // remember { mutableStateOf(false) } untuk mengelola status ekspansi jadwal di dalam Scheduleitem
    var expanded by remember { mutableStateOf(false) }
    // untuk membuat tampilan kartu pada setiap jadwal
    Card(modifier = modifier) {
        // Kolom untuk menata elemen dalam bentuk vertikal
        Column(
            modifier = Modifier.animateContentSize( // animateContentSize digunakan untuk memberikan efek animasi ketika ukuran konten di daalam kolom berubah
                animationSpec = spring( // jenis animasi yang  adalah spring
                    dampingRatio = Spring.DampingRatioNoBouncy, // tidak ada efek pantulan ketika animasi selesai
                    stiffness = Spring.StiffnessMedium // mengontrol kekakuan dari animasi
                )
            )
        ) {
            // Row untuk menata ikon, informasi jadwal dan tombol secara horizontal
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                ScheduleIcon(schedule.imageResourceId) // Menampilkan ikon jadwal berdasarkan id gambar yang ada dalam objek schedule
                ScheduleInformation(schedule.name, schedule.sks, schedule.room) // menampilkan informasi mengenai jadwal
                Spacer(Modifier.weight(1f))
                ScheduleItemButton(expanded = expanded, onClick = { expanded = !expanded })  // state expanded digunakan untuk menentukan apakah detail jadwal sedang diperluas atau tidak
            }
            if (expanded) {
                ScheduleDetails(
                    schedule = schedule,
                    modifier = Modifier.padding(
                        start = dimensionResource(R.dimen.padding_medium),
                        top = dimensionResource(R.dimen.padding_small),
                        bottom = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@Composable

private fun ScheduleItemButton(expanded: Boolean, onClick: () -> Unit) {
    // untuk menangani klik dan memperluas atau menyembunyikan detail jadwal
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = MaterialTheme.colorScheme.secondary
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
// komponen AppBar digunakan dengan elemen judul yang terdiri dari gambar logo dan judul aplikasi
fun ScheduleTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            // Row untuk menata ikon aplikasi dan teks judul secara horizontal
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    modifier = Modifier
                        .size(dimensionResource(R.dimen.image_size))
                        .padding(dimensionResource(R.dimen.padding_small)),
                    painter = painterResource(R.drawable.logo),
                    contentDescription = null // Deskripsi dari konten
                )
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge.copy(fontSize = dimensionResource(R.dimen.font_size_display_large).value.sp)
                )
            }
        },
        modifier = modifier
    )
}

@Composable
// menampilkan ikon dari schedule
fun ScheduleIcon(@DrawableRes scheduleIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(scheduleIcon),
        contentDescription = null
    )
}

@Composable
// untuk menampilkan informasi 
fun ScheduleInformation(@StringRes name: Int, sks: Int, room: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displayMedium.copy(
                fontSize = dimensionResource(R.dimen.font_size_display_medium).value.sp
            ),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.total_sks, sks),
            style = MaterialTheme.typography.bodyLarge.copy(
                fontSize = dimensionResource(R.dimen.font_size_body_large).value.sp
            )
        )
    }
}

@SuppressLint("ResourceType") // Anotasi untuk menonaktifkan peringatan lint tertentu
@Composable
fun ScheduleDetails(schedule: Schedule, modifier: Modifier = Modifier) {
     // Kolom untuk menata elemen dalam bentuk vertikal
    Column(modifier = modifier) {
        Text(text = "Schedule Details", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))
        val subjects = stringArrayResource(schedule.timeArray)
        subjects.forEach { subject ->
            Text(text = subject, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview
@Composable
fun ThemeSchedulePreview() {
    MyScheduleTheme(darkTheme = false) {
        ScheduleApp()
    }
}

@Preview
@Composable
fun SchedulePreview() {
    MyScheduleTheme(darkTheme = true) {
        ScheduleApp()
    }
}

