package krypton.maulidsimtudduror.sabilutaubah.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import krypton.maulidsimtudduror.sabilutaubah.R
import krypton.maulidsimtudduror.sabilutaubah.info.AboutUs
import krypton.maulidsimtudduror.sabilutaubah.ui.theme.appTheme
import krypton.maulidsimtudduror.sabilutaubah.util.MainButton
import krypton.maulidsimtudduror.sabilutaubah.view.ViewImage
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    companion object {
        lateinit var appContext: Context
        var IndexImage by Delegates.notNull<Int>()
        val LIST_JUDUL = arrayListOf(
            "1. Ya Robbi Sholli",
            "2.",
            "3. Innafatahna",
            "4. Alhamdulillahi",
            "5. Tajallal Haqqu",
            "6. Wa Ashadu",
            "7. Amma Ba'du",
            "8. Wa Qad Aana",
            "9. Wa Mundzu",
            "10. Fahiina Qoruba",
            "11. Mahalul Qiyam",
            "12. Wahiina Baraza",
            "13. Wa Laqodittasofa"
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        appContext = this

        setContent {
            appTheme {
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent,
                        darkIcons = useDarkIcons
                    )
                }
                ProvideWindowInsets {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.app_name),
                                            style = MaterialTheme.typography.subtitle2,
                                            fontSize = 18.sp,
                                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                        )
                                        Text(
                                            text = stringResource(id = R.string.app_name_summary),
                                            style = MaterialTheme.typography.caption,
                                            modifier = Modifier.align(Alignment.CenterHorizontally)
                                        )
                                    }
                                },
                                backgroundColor = Color.Transparent,
                                elevation = 0.dp,
                                contentPadding = rememberInsetsPaddingValues(
                                    LocalWindowInsets.current.statusBars,
                                    applyBottom = false,
                                ),
                                modifier = Modifier.fillMaxWidth()
                            )
                        },
                        bottomBar = {
                            Spacer(
                                Modifier
                                    .navigationBarsHeight()
                                    .fillMaxWidth()
                            )
                        }
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier
                                    .verticalScroll(rememberScrollState())
                                    .widthIn(max = 600.dp)
                                    .padding(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 16.dp)
                                    .navigationBarsPadding()
                            ) {
                                LIST_JUDUL.forEachIndexed { index, s ->
                                    MainButton(
                                        text = s,
                                        onClick = {
                                            val i = Intent(appContext, ViewImage::class.java)
                                            startActivity(i)
                                            IndexImage = index
                                        }
                                    )
                                    Spacer(modifier = Modifier.size(10.dp))
                                }
                                Spacer(modifier = Modifier.size(20.dp))
                                MainButton(
                                    text = stringResource(id = R.string.about_app),
                                    onClick = {
                                        val i = Intent(appContext, AboutUs::class.java)
                                        startActivity(i)
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}