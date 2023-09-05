package krypton.maulidsimtudduror.sabilutaubah.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.*
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import krypton.maulidsimtudduror.sabilutaubah.main.MainActivity.Companion.IndexImage
import krypton.maulidsimtudduror.sabilutaubah.main.MainActivity.Companion.LIST_JUDUL
import krypton.maulidsimtudduror.sabilutaubah.utils.viewImage
import krypton.maulidsimtudduror.sabilutaubah.ui.theme.appTheme

class ViewImage : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

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
                            com.google.accompanist.insets.ui.TopAppBar(
                                title = {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Text(
                                            text = LIST_JUDUL[IndexImage],
                                            style = MaterialTheme.typography.subtitle2,
                                            color = MaterialTheme.colors.primary,
                                            modifier = Modifier.align(Alignment.CenterHorizontally),
                                            fontSize = 18.sp
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
                                viewImage(IndexImage)
                            }
                        }
                    }
                }
            }
        }
    }
}