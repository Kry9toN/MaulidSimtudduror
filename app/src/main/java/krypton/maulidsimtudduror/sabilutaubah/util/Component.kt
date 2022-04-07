package krypton.maulidsimtudduror.sabilutaubah.util

import android.graphics.BitmapFactory
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import krypton.maulidsimtudduror.sabilutaubah.main.MainActivity.Companion.appContext

@Composable
fun MainButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
    ) {
        Text(text = text)
    }
}

@Composable
fun viewImage(index: Int) {
    val list = appContext.assets.list(index.toString())

    list?.forEach {
        Card(
            elevation = 5.dp
        ) {
            val img = appContext.assets.open("$index/$it")
            val bitmap = BitmapFactory.decodeStream(img)
            Image(
                bitmap.asImageBitmap(),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.size(3.dp))
    }
}