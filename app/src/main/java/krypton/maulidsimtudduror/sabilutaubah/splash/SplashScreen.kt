package krypton.maulidsimtudduror.sabilutaubah.splash

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import androidx.lifecycle.lifecycleScope
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import krypton.maulidsimtudduror.sabilutaubah.lottie.SplashAnimation
import krypton.maulidsimtudduror.sabilutaubah.main.MainActivity
import krypton.maulidsimtudduror.sabilutaubah.ui.theme.appTheme
import krypton.maulidsimtudduror.sabilutaubah.utils.openActivity

class SplashScreen : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
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
                        bottomBar = {
                            Spacer(
                                Modifier
                                    .navigationBarsHeight()
                                    .fillMaxWidth()
                            )
                        }
                    ) {
                        SplashAnimation()
                    }
                }
            }
        }
        lifecycleScope.launchWhenCreated {
            delay(3000)

            openActivity(this@SplashScreen, MainActivity::class.java)
            finish()
        }
    }
}