package id.ellinda.affirmations.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation(
    // StringRes menandakan bahwa parameter yang terkait adalah referensi ke resurce string
    @StringRes val stringResourceId: Int, // Sebuah properti yang menyimpan id resource string, digunakan untuk mengacu pada teks afirmasi yang di tampilkan di UI
    // DrawableRes menandakan bahwa parameter yang terkait adalah referensi ke resource gambar
    @DrawableRes val imageResourceId: Int // Sebuah properti yang menyimpan id resource gambar, digunakan untuk mengacu pada gambar yang terkait dengan afirmasi
)
