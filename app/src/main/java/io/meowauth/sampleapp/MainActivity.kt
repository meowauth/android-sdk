package io.meowauth.sampleapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import io.meowauth.sampleapp.ui.RandomImageUrlGenerator
import io.meowauth.sampleapp.ui.components.MeowDeviceItem
import io.meowauth.sampleapp.ui.components.MeowGreenInformation
import io.meowauth.sampleapp.ui.components.MeowKeyDeleteConfirmDialog
import io.meowauth.sampleapp.ui.components.MeowNetworkImage
import io.meowauth.sampleapp.ui.components.MeowSquareButton
import io.meowauth.sampleapp.ui.theme.MeowAuthSampleTheme
import io.meowauth.sampleapp.ui.theme.PPObjectSans
import io.meowauth.sampleapp.ui.theme.PretendardFont

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContent {
            MeowAuthSampleTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xFF0F0F0F),
                ) {
                    var isRevokeDialogOpened by remember { mutableStateOf(false) }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        val profileImage = remember {
                            RandomImageUrlGenerator.getRandomImageUrl()
                        }
                        MeowNetworkImage(
                            model = profileImage,
                            contentDescription = null,
                            modifier = Modifier
                                .statusBarsPadding()
                                .padding(top = 32.dp)
                                .size(60.dp)
                                .clip(CircleShape)
                        )
                        Text(
                            text = "ryan.fn",
                            fontFamily = PPObjectSans,
                            color = Color(0xfffbfbfb),
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp,
                            letterSpacing = -(0.01).sp,
                            modifier = Modifier.padding(top = 11.dp)
                        )
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 5.dp)
                        ) {
                            Text(
                                text = "0x655f6969fd4761ba",
                                fontFamily = PretendardFont,
                                color = Color(0xff707379),
                                fontWeight = FontWeight.Normal,
                                fontSize = 15.sp,
                                letterSpacing = -(0.01).sp,
                                modifier = Modifier.padding(end = 4.dp)
                            )
                            Icon(
                                painter = painterResource(id = R.drawable.icon_copy),
                                contentDescription = "Copy",
                                tint = Color(0xff707379),
                                modifier = Modifier
                                    .size(12.dp)
                                    .clickable { }
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .padding(horizontal = 32.dp)
                                .padding(top = 38.dp)
                                .fillMaxWidth(),
                        ) {
                            MeowSquareButton(
                                iconResource = R.drawable.icon_send,
                                label = "Send",
                                onClick = {},
                            )
                            MeowSquareButton(
                                iconResource = R.drawable.icon_top_up,
                                label = "Top Up",
                                onClick = {},
                            )
                            MeowSquareButton(
                                iconResource = R.drawable.icon_swap,
                                label = "Swap",
                                onClick = {},
                            )
                            MeowSquareButton(
                                iconResource = R.drawable.icon_more,
                                label = "More",
                                onClick = {},
                            )
                        }
                        MeowGreenInformation(
                            title = "Connect to Your Own Wallet",
                            description = "Manage and control your assets in one single place, your own wallet.",
                            iconResource = R.drawable.icon_flow,
                            onClick = {},
                            modifier = Modifier.padding(top = 28.dp, start = 15.dp, end = 15.dp)
                        )
                        Text(
                            text = "Your Keys",
                            fontFamily = PPObjectSans,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            letterSpacing = (-0.01).sp,
                            fontSize = 18.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 30.dp)
                                .padding(horizontal = 15.dp)
                                .padding(bottom = 21.dp)
                        )
                        MeowDeviceItem(
                            title = "MeowAuth Custodial Key",
                            keyHash = "4dc0...a034",
                            isDevice = false,
                            onDeleteClick = { isRevokeDialogOpened = true },
                        )
                        MeowDeviceItem(
                            title = "Google Pixel 6a",
                            keyHash = "95a4...223a",
                            // dateLocation = "Mar 1  ·  South Korea",
                            isDevice = true,
                            isThisDevice = true,
                            onDeleteClick = { isRevokeDialogOpened = true },
                        )
                        MeowDeviceItem(
                            title = "Galaxy S22",
                            keyHash = "9a40...576e",
                            dateLocation = "Mar 1  ·  South Korea",
                            isDevice = true,
                            isThisDevice = false,
                            onDeleteClick = { isRevokeDialogOpened = true },
                        )
                        MeowDeviceItem(
                            title = "Ryan’s iPhone",
                            keyHash = "9e33...937c",
                            isDevice = true,
                            isThisDevice = false,
                            dateLocation = "Feb 27  ·  South Korea",
                            onDeleteClick = { isRevokeDialogOpened = true },
                        )
                    }

                    if (isRevokeDialogOpened) {
                        MeowKeyDeleteConfirmDialog(
                            onCancelButtonClick = { /*TODO*/ },
                            onRevokeButtonClick = { /*TODO*/ },
                            onDismiss = { isRevokeDialogOpened = false },
                        )
                    }
                }
            }
        }
    }
}
