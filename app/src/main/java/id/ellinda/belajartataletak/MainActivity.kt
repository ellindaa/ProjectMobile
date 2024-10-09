package id.ellinda.belajartataletak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import id.ellinda.belajartataletak.ui.theme.BelajarTataletakTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarTataletakTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {
    // Pemanggilan fungsi untuk menampilkan gambar dan tombol
    DiceWithButtonAndImage(
        modifier = Modifier
            .fillMaxSize() // Mengatur ukuran penuh layar
            .wrapContentSize(Alignment.Center) // Mengatur tata letak di tengah
    )
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    val result = remember { mutableStateOf(1) } // Menyimpan state dalam fungsi, nilai awal adalah 1 ketika nilai berubah maka akan di recompose

    val imageResource = when (result.value) { // when digunakan untuk menentukan gambar yang akan ditampilkan
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }

    val descriptionResource = when (result.value) { // when digunakan untuk menentukan deskripsi yang akan ditampilkan
        1 -> R.string.tap_lemon_tree
        2 -> R.string.keep_tapping
        3 -> R.string.tap_lemonade
        else -> R.string.tap_empty_glass
    }

    Column( // Column digunakan untuk menampilkan gambar dan tombol secara vertikal
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Box digunakan untuk menampilkan gambar dan tombol
        Box(
            modifier = Modifier
                .clickable { result.value = (1..4).random() }  // Saat gambar di klik akan mengubah nilai
                .size(150.dp)  // Menentukan ukuran kotak
                .background(Color(0xFFC8E6C9))  // Latar belakang kotak
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(imageResource), // painter resource digunakan untuk mendapatkan gambar berdasarkan resource id
                contentDescription = stringResource(descriptionResource), // content description digunakan untuk memberikan deskripsi gambar
                modifier = Modifier.fillMaxSize()  // Mengatur gambar
            )
        }
        Spacer(modifier = Modifier.height(16.dp)) // Menambahkan jarak vertikal
        Text(text = stringResource(descriptionResource)) // Menampilkan teks yang sesuai dengan deskripsi gambar
    }
}
