package id.ellinda.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import id.ellinda.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace() // memanggil fungsi komposable yang akan membuat UI
                }
            }
        }
    }
}

@Composable
// fungsi yang mengatur layout utama untuk tampilan
fun ArtSpace() {
    DiceWithButtonAndImage(
        modifier = Modifier.fillMaxSize()
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    // menyimpan referensi gambar
    val images = listOf(
        R.drawable.raden_saleh,
        R.drawable.badai,
        R.drawable.perburuan,
        R.drawable.nyi,
        R.drawable.alisadikin,
        R.drawable.theruins,
        R.drawable.megamendung,
        R.drawable.pasukan,
        R.drawable.lukisanbali,
        R.drawable.pandawadadu
    )
    // menyimpan referensi judul
    val titles = listOf(
        R.string.raden_saleh,
        R.string.badai,
        R.string.perburuan,
        R.string.nyi,
        R.string.alisadikin,
        R.string.theruins,
        R.string.megamendung,
        R.string.pasukan,
        R.string.lukisanbali,
        R.string.pandawadadu
    )
    // menyimpan referensi deskripsi
    val descriptions = listOf(
        R.string.raden_saleh_description,
        R.string.badai_description,
        R.string.perburuan_description,
        R.string.nyi_description,
        R.string.alisadikin_description,
        R.string.theruins_description,
        R.string.megamendung_description,
        R.string.pasukan_description,
        R.string.lukisanbali_description,
        R.string.pandawadadu_description
    )

    val result = remember { mutableStateOf(0) }

    // mengatur elemen di dalam kolom vertikal agar terpusat di tengah secara vertikal dan horizontal
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // digunakan untuk menampung gambar
        Box(
            modifier = Modifier
                .size(200.dp) // mengatur ukuran kotak gambar
                .clip(RoundedCornerShape(8.dp)) // memotong sudut kotak menjadi rounded
        ) {
            // menampilkan gambar berdasarkan indeks saat ini
            Image(
                painter = painterResource(images[result.value]),
                contentDescription = stringResource(titles[result.value]),
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(16.dp)) // Jarak antara gambar dan teks
        // menampilkan judul dan deskripsi berdasarkan indeks saat ini
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(titles[result.value]),
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(4.dp)) // Jarak antara judul dan deskripsi

            Text(
                text = stringResource(descriptions[result.value]),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Jarak antara deskripsi dan tombol
        // menyusun tombol secara horizontal
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // tombol untuk PREVIOUS
            Button(
                // mengubah nilai result untuk berpindah gambar
                onClick = {
                    if (result.value > 0) {
                        result.value -= 1
                    }
                },
                enabled = result.value > 0
            ) {
                Text(text = "Previous")
            }

            Spacer(modifier = Modifier.width(32.dp))
            // tombol untuk NEXT
            Button(
                onClick = {
                    if (result.value < images.size - 1) {
                        result.value += 1
                    }
                },
                enabled = result.value < images.size - 1
            ) {
                Text(text = "Next")
            }
        }
    }
}
