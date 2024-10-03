package id.ellinda.belajarteks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import id.ellinda.belajarteks.ui.theme.BelajarTeksTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BelajarTeksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday Mama!",
                        from = "From Ellinda"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)
    Box(modifier) {
        Image(
            painter = image,
            // Deskripsi gambar
            contentDescription = null,
            // Mengatur ukuran gambar
            contentScale = ContentScale.Crop,
            // Mengatur opacity gambar
            alpha = 0.5F
        )
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}

// Membuat fungsi GreetingText dengan parameter massage jenis string,
// parameter from jenis string, dan parameter modifier jenis Modifier
@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Mengatur elemen teks dalam kolom dengan tata letak vertikal di tengah
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            // Mengatur teks dengan parameter
            text = message,
            // Mengubah ukuran font
            fontSize = 100.sp,
            // Mengatur tinggi baris
            lineHeight = 116.sp,
            // Mengatur textAlign
            textAlign = TextAlign.Center
        )
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(16.dp)
                .align(alignment = Alignment.End)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BelajarTeksTheme(       ) {
        // Memanggil fungsi GreetingText untuk di tampilkan pada pratinjau,
        GreetingImage(
            message = "Happy Birthday Mama!",
            from = "From Ellinda")
    }
}


