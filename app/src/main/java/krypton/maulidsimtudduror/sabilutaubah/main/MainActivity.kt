package krypton.maulidsimtudduror.sabilutaubah.main

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.google.accompanist.insets.*
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import krypton.maulidsimtudduror.sabilutaubah.R
import krypton.maulidsimtudduror.sabilutaubah.info.AboutUs
import krypton.maulidsimtudduror.sabilutaubah.lottie.MainAnimation
import krypton.maulidsimtudduror.sabilutaubah.ui.theme.appTheme
import krypton.maulidsimtudduror.sabilutaubah.utils.MainButton
import krypton.maulidsimtudduror.sabilutaubah.utils.openActivity
import krypton.maulidsimtudduror.sabilutaubah.view.ViewImage
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    companion object {
        lateinit var appContext: Context
        var IndexImage by Delegates.notNull<Int>()
        val LIST_JUDUL = arrayListOf(
            "1. Ya Robbi Sholli",
            "2. Assalamualaik",
            "3. Isyfa Lana",
            "4. Yallah Biha",
            "5. Innafatahna",
            "6. Alhamdulillahi",
            "7. Tajallal Haqqu",
            "8. Wa Ashadu",
            "9. Amma Ba'du",
            "10. Wa Qad Aana",
            "11. Wa Mundzu",
            "12. Fahiina Qoruba",
            "13. Mahalul Qiyam",
            "14. Wahiina Baraza",
            "15. Wa Laqodittasofa"
        )
    }

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
                                            color = MaterialTheme.colors.primary,
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
                                    .padding(
                                        start = 16.dp,
                                        end = 16.dp,
                                        top = 12.dp,
                                        bottom = 16.dp
                                    )
                                    .navigationBarsPadding()
                            ) {
                                MainAnimation()
                                LIST_JUDUL.forEachIndexed { index, s ->
                                    MainButton(
                                        text = s,
                                        onClick = {
                                            openActivity(this@MainActivity, ViewImage::class.java)
                                            IndexImage = index
                                        }
                                    )
                                    Spacer(modifier = Modifier.size(10.dp))
                                }
                                Spacer(modifier = Modifier.size(20.dp))
                                MainButton(
                                    text = stringResource(id = R.string.about_app),
                                    onClick = {
                                        openActivity(this@MainActivity, AboutUs::class.java)
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