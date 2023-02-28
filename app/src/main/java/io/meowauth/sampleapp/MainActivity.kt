package io.meowauth.sampleapp

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import io.meowauth.sampleapp.ui.RandomImageUrlGenerator
import io.meowauth.sampleapp.ui.components.BottomSheetDialog
import io.meowauth.sampleapp.ui.components.BottomSheetDialogProperties
import io.meowauth.sampleapp.ui.components.MeowButton
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
                    val confirmImage = remember {
                        RandomImageUrlGenerator.getRandomImageUrl()
                    }
                    val confirmProfile = remember {
                        RandomImageUrlGenerator.getRandomImageUrl()
                    }

                    var isRevokeDialogOpened by remember { mutableStateOf(false) }
                    var isConfirmBottomSheetOpened by remember { mutableStateOf(false) }
                    var is2FABottomSheetOpened by remember { mutableStateOf(false) }
                    var isFlowIntegrateBottomSheetOpened by remember { mutableStateOf(false) }

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
                                    .clickable { isFlowIntegrateBottomSheetOpened = true }
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
                                onClick = { isConfirmBottomSheetOpened = true },
                            )
                            MeowSquareButton(
                                iconResource = R.drawable.icon_top_up,
                                label = "Top Up",
                                onClick = { is2FABottomSheetOpened = true },
                            )
                            MeowSquareButton(
                                iconResource = R.drawable.icon_swap,
                                label = "Swap",
                                onClick = {
                                    startActivity(Intent(this@MainActivity, TFATransactionActivity::class.java))
                                },
                            )
                            MeowSquareButton(
                                iconResource = R.drawable.icon_more,
                                label = "More",
                                onClick = { startActivity(Intent(this@MainActivity, TFALoginActivity::class.java)) },
                            )
                        }
                        MeowGreenInformation(
                            title = "Connect to Your Own Wallet",
                            description = "Manage and control your assets in one single place, your own wallet.",
                            iconResource = R.drawable.icon_flow,
                            onClick = { isFlowIntegrateBottomSheetOpened = true },
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
                            onCancelButtonClick = { isRevokeDialogOpened = false },
                            onRevokeButtonClick = { isRevokeDialogOpened = false },
                            onDismiss = { isRevokeDialogOpened = false },
                        )
                    }

                    if (isConfirmBottomSheetOpened) {
                        BottomSheetDialog(
                            onDismissRequest = { isConfirmBottomSheetOpened = false },
                            properties = BottomSheetDialogProperties(
                                enableEdgeToEdge = true,
                            )
                        ) {
                            Surface(
                                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                                color = Color(0xFF212121),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .navigationBarsPadding()
                                        .padding(24.dp)
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    Text(
                                        text = "Confirm Sending",
                                        fontFamily = PPObjectSans,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 21.sp,
                                        letterSpacing = (-0.01).sp,
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 24.dp)
                                    ) {
                                        MeowNetworkImage(
                                            model = confirmImage,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clip(RoundedCornerShape(16.dp))
                                        )
                                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                            Text(
                                                text = "Meow Cats Collection",
                                                fontFamily = PPObjectSans,
                                                color = Color.White,
                                                fontWeight = FontWeight.Medium,
                                                fontSize = 16.sp,
                                                letterSpacing = (-0.01).sp,
                                            )
                                            Text(
                                                text = "#59",
                                                fontFamily = PretendardFont,
                                                color = Color(0xFF707379),
                                                fontWeight = FontWeight.Normal,
                                                fontSize = 15.sp,
                                                letterSpacing = (-0.01).sp,
                                            )
                                        }
                                    }
                                    Image(
                                        painter = painterResource(id = R.drawable.icon_down),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(start = 6.dp, top = 12.dp)
                                            .width(32.dp)
                                    )
                                    Row(
                                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 12.dp)
                                    ) {
                                        MeowNetworkImage(
                                            model = confirmProfile,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(40.dp)
                                                .clip(CircleShape)
                                        )
                                        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                            Text(
                                                text = "ryan.fn",
                                                fontFamily = PPObjectSans,
                                                color = Color.White,
                                                fontWeight = FontWeight.Medium,
                                                fontSize = 16.sp,
                                                letterSpacing = (-0.01).sp,
                                            )
                                            Text(
                                                text = "0x655f6969fd4761ba",
                                                fontFamily = PretendardFont,
                                                color = Color(0xFF707379),
                                                fontWeight = FontWeight.Normal,
                                                fontSize = 15.sp,
                                                letterSpacing = (-0.01).sp,
                                            )
                                        }
                                    }
                                    MeowButton(
                                        label = "Authorize",
                                        backgroundColor = Color(0xFF58A5FF),
                                        labelColor = Color.White,
                                        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 12.dp),
                                        icon = {
                                            Icon(
                                                painter = painterResource(id = R.drawable.icon_fingerprint),
                                                contentDescription = null,
                                                tint = Color.White,
                                                modifier = Modifier.size(24.dp),
                                            )
                                        },
                                        iconSpacing = 4.dp,
                                        onClick = {},
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 40.dp)
                                    )
                                    Text(
                                        text = "Powered by MeowAuth",
                                        fontFamily = PPObjectSans,
                                        color = Color(0xFF545454),
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = (-0.01).sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 13.dp)
                                            .navigationBarsPadding()
                                    )
                                }
                            }
                        }
                    }

                    if (is2FABottomSheetOpened) {
                        BottomSheetDialog(
                            onDismissRequest = { is2FABottomSheetOpened = false },
                            properties = BottomSheetDialogProperties(
                                enableEdgeToEdge = true,
                            )
                        ) {
                            Surface(
                                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                                color = Color(0xFF212121),
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .navigationBarsPadding()
                                        .padding(24.dp)
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_shield),
                                        tint = Color.White,
                                        contentDescription = null,
                                        modifier = Modifier.size(36.dp)
                                    )
                                    Text(
                                        text = "2-Step Verification",
                                        fontFamily = PPObjectSans,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 21.sp,
                                        letterSpacing = (-0.01).sp,
                                        modifier = Modifier.padding(top = 12.dp)
                                    )
                                    Row {
                                        Text(
                                            text = "Check your",
                                            fontFamily = PPObjectSans,
                                            color = Color(0xFFA0A0A0),
                                            fontWeight = FontWeight.Medium,
                                            fontSize = 16.sp,
                                            letterSpacing = (-0.01).sp,
                                        )
                                        Text(
                                            text = " Galaxy S22",
                                            fontFamily = PPObjectSans,
                                            color = Color(0xFFA0A0A0),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 16.sp,
                                            letterSpacing = (-0.01).sp,
                                        )
                                    }
                                    Text(
                                        text = "We sent a notification to your MeowExample app on Galaxy S22. Tap authorize to continue.",
                                        fontFamily = PretendardFont,
                                        color = Color(0xFFA7A7A7),
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 14.sp,
                                        lineHeight = 18.sp,
                                        letterSpacing = (-0.01).sp,
                                        modifier = Modifier.padding(top = 32.dp)
                                    )
                                    Text(
                                        text = "Powered by MeowAuth",
                                        fontFamily = PPObjectSans,
                                        color = Color(0xFF545454),
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = (-0.01).sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 34.dp)
                                            .navigationBarsPadding()
                                    )
                                }
                            }
                        }
                    }

                    if (isFlowIntegrateBottomSheetOpened) {
                        BottomSheetDialog(
                            onDismissRequest = { isFlowIntegrateBottomSheetOpened = false },
                            properties = BottomSheetDialogProperties(
                                enableEdgeToEdge = true,
                            )
                        ) {
                            Surface(
                                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                                color = Color(0xFF212121),
                            ) {
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .navigationBarsPadding()
                                        .padding(16.dp)
                                        .verticalScroll(rememberScrollState())
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.icon_flow),
                                        tint = Color.Unspecified,
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(top = 36.dp)
                                            .size(80.dp)
                                    )
                                    Text(
                                        text = "Manage Your Assets\n" +
                                                "in One Place, Your Wallet",
                                        fontFamily = PPObjectSans,
                                        color = Color.White,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 21.sp,
                                        letterSpacing = (-0.01).sp,
                                        lineHeight = 28.sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(top = 22.dp)
                                    )

                                    Text(
                                        text = "It’s highly recommended to add more device\ninto your account.",
                                        fontFamily = PretendardFont,
                                        color = Color(0xFFA7A7A7),
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 14.sp,
                                        lineHeight = 18.sp,
                                        letterSpacing = (-0.01).sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier.padding(top = 16.dp)
                                    )
                                    MeowButton(
                                        label = "Connect Wallet",
                                        backgroundColor = Color(0xFF58A5FF),
                                        labelColor = Color.White,
                                        contentPadding = PaddingValues(horizontal = 40.dp, vertical = 12.dp),
                                        onClick = {},
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 70.dp)
                                    )
                                    Text(
                                        text = "Powered by MeowAuth",
                                        fontFamily = PPObjectSans,
                                        color = Color(0xFF545454),
                                        fontWeight = FontWeight.Medium,
                                        letterSpacing = (-0.01).sp,
                                        textAlign = TextAlign.Center,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(top = 13.dp)
                                            .navigationBarsPadding()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
