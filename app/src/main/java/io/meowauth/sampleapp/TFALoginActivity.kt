package io.meowauth.sampleapp

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
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
import io.meowauth.sampleapp.ui.components.MeowButton
import io.meowauth.sampleapp.ui.theme.MeowAuthSampleTheme
import io.meowauth.sampleapp.ui.theme.PPObjectSans
import io.meowauth.sampleapp.ui.theme.PretendardFont

class TFALoginActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            MeowAuthSampleTheme {
                val confirmImage = remember {
                    RandomImageUrlGenerator.getRandomImageUrl()
                }
                val confirmProfile = remember {
                    RandomImageUrlGenerator.getRandomImageUrl()
                }

                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(0xFF0F0F0F),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .statusBarsPadding()
                            .padding(24.dp)
                    ) {
                        Text(
                            text = "Confirm it’s You",
                            fontFamily = PPObjectSans,
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 24.sp,
                            letterSpacing = -(0.01).sp,
                            modifier = Modifier.padding(top = 11.dp)
                        )
                        Text(
                            text = "Hyojun’s iPhone is trying to log in into MeowExample app in the ryan12@gmail.com account.",
                            fontFamily = PretendardFont,
                            color = Color(0xFFA7A7A7),
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            letterSpacing = -(0.01).sp,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color(0xFF171C20))
                                .padding(horizontal = 20.dp, vertical = 16.dp),
                        ) {
                            Text(
                                text = "Log in to MeowExample",
                                fontFamily = PPObjectSans,
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
                            )
                            Text(
                                text = "Device",
                                fontFamily = PretendardFont,
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
                                modifier = Modifier.padding(top = 27.dp),
                            )
                            Text(
                                text = "Hyojun’s iPhone",
                                fontFamily = PretendardFont,
                                color = Color(0xFFA7A7A7),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
                            )
                            Text(
                                text = "Location",
                                fontFamily = PretendardFont,
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
                                modifier = Modifier.padding(top = 16.dp),
                            )
                            Text(
                                text = "Near Albuquerque, NM, United States",
                                fontFamily = PretendardFont,
                                color = Color(0xFFA7A7A7),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
                            )
                            Text(
                                text = "Time",
                                fontFamily = PretendardFont,
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
                                modifier = Modifier.padding(top = 16.dp),
                            )
                            Text(
                                text = "Just Now",
                                fontFamily = PretendardFont,
                                color = Color(0xFFA7A7A7),
                                fontWeight = FontWeight.Normal,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(11.dp),
                            modifier = Modifier.padding(top = 24.dp)
                        ) {
                            MeowButton(
                                label = "Deny",
                                backgroundColor = Color(0xFF3C3C3C),
                                labelColor = Color.White,
                                contentPadding = PaddingValues(vertical = 12.dp),
                                onClick = {},
                                modifier = Modifier
                                    .weight(1f)
                            )
                            MeowButton(
                                label = "Authorize",
                                backgroundColor = Color(0xFF58A5FF),
                                labelColor = Color.White,
                                contentPadding = PaddingValues(vertical = 9.dp),
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
                                    .weight(1f)
                            )
                        }
                        Text(
                            text = "Powered by MeowAuth",
                            fontFamily = PPObjectSans,
                            color = Color(0xFF545454),
                            fontWeight = FontWeight.Normal,
                            fontSize = 12.sp,
                            letterSpacing = (-0.01).sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .navigationBarsPadding()
                                .padding(top = 16.dp)
                        )
                    }
                }
            }

        }
    }
}
