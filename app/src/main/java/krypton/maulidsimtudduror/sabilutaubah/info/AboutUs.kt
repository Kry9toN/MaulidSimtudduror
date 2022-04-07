package krypton.maulidsimtudduror.sabilutaubah.info

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.alorma.compose.settings.ui.SettingsMenuLink
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import krypton.maulidsimtudduror.sabilutaubah.BuildConfig
import krypton.maulidsimtudduror.sabilutaubah.R
import krypton.maulidsimtudduror.sabilutaubah.main.MainActivity.Companion.appContext
import krypton.maulidsimtudduror.sabilutaubah.ui.theme.appTheme
import kotlin.random.Random

class AboutUs: ComponentActivity() {
    companion object {
        var COUNT_CLICK = 0
        val dialogToastArray = listOf(
            "Ngapain...?",
            "Ga boleh gitu.",
            "Yahaha"
        )
    }

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
                            TopAppBar(
                                title = {
                                    Column(
                                        modifier = Modifier.fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                    ) {
                                        Text(
                                            text = stringResource(id = R.string.about_app),
                                            style = MaterialTheme.typography.subtitle2,
                                            fontSize = 18.sp,
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
                        Column(
                            modifier = Modifier.scrollable(
                                state = rememberScrollState(),
                                orientation = Orientation.Vertical,
                            )
                        ) {
                            Column(modifier = Modifier
                                .padding(start = 15.dp, bottom = 5.dp)
                                .fillMaxWidth()) {
                                Text(
                                    text = "Terimakasih Kepada",
                                    style = MaterialTheme.typography.overline
                                )
                            }
                            Divider()
                            SettingsMenuLink(
                                title = { Text(text = "Allah SWT") },
                                subtitle = { Text(text = "Untuk kenikmatan yang sudah di berikan kepada kita") },
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.size(10.dp))
                            Column(modifier = Modifier
                                .padding(start = 15.dp, bottom = 5.dp)
                                .fillMaxWidth()) {
                                Text(
                                    text = "Teams",
                                    style = MaterialTheme.typography.overline
                                )
                            }
                            Divider()
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Code,
                                        contentDescription = "developer"
                                    )
                                },
                                title = { Text(text = "Developer") },
                                subtitle = { Text(text = "Dhimas") },
                            ) {
                                try {
                                    startActivity(
                                        Intent(Intent.ACTION_VIEW)
                                            .setData(Uri.parse("https://github.com/Kry9toN/"))
                                    )
                                } catch (e: Throwable) {
                                }
                            }
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Collections,
                                        contentDescription = "developer"
                                    )
                                },
                                title = { Text(text = "Asset Management") },
                                subtitle = { Text(text = "Irfan") },
                                onClick = {}
                            )
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.TheaterComedy,
                                        contentDescription = "developer"
                                    )
                                },
                                title = { Text(text = "Support System") },
                                subtitle = { Text(text = "Bowo") },
                                onClick = {}
                            )
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.TheaterComedy,
                                        contentDescription = "developer"
                                    )
                                },
                                title = { Text(text = "Support System") },
                                subtitle = { Text(text = "Aji") },
                                onClick = {}
                            )
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.TheaterComedy,
                                        contentDescription = "developer"
                                    )
                                },
                                title = { Text(text = "Support System") },
                                subtitle = { Text(text = "Sarkon") },
                                onClick = {}
                            )
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.TheaterComedy,
                                        contentDescription = "developer"
                                    )
                                },
                                title = { Text(text = "Support System") },
                                subtitle = { Text(text = "Agil") },
                                onClick = {}
                            )
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.TheaterComedy,
                                        contentDescription = "developer"
                                    )
                                },
                                title = { Text(text = "Support System") },
                                subtitle = { Text(text = "Ipen") },
                                onClick = {}
                            )
                            Spacer(modifier = Modifier.size(10.dp))
                            Column(modifier = Modifier
                                .padding(start = 15.dp, bottom = 5.dp)
                                .fillMaxWidth()) {
                                Text(
                                    text = "Info App",
                                    style = MaterialTheme.typography.overline
                                )
                            }
                            Divider()
                            SettingsMenuLink(
                                icon = {
                                    Icon(
                                        imageVector = Icons.Outlined.Info,
                                        contentDescription = "app_version"
                                    )
                                },
                                title = { Text(text = "App Version") },
                                subtitle = { Text(text = "${BuildConfig.VERSION_NAME} (${BuildConfig.VERSION_CODE})") },
                                onClick = {
                                    onButtonClick2()
                                },
                            )
                        }
                    }
                }
            }
        }
    }

    private fun onButtonClick2() {
        COUNT_CLICK += 1
        when (COUNT_CLICK) {
            1 -> Toast.makeText(appContext, "Tekan 3 kali lagi....", Toast.LENGTH_SHORT).show()
            4 -> {
                val randomIndex = Random.nextInt(dialogToastArray.size)
                Toast.makeText(appContext, dialogToastArray[randomIndex], Toast.LENGTH_LONG).show()
                COUNT_CLICK = 0
            }
        }
    }
}