package io.meowauth.sampleapp

import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import io.meowauth.sampleapp.ui.RandomImageUrlGenerator
import io.meowauth.sampleapp.ui.components.MeowButton
import io.meowauth.sampleapp.ui.components.MeowNetworkImage
import io.meowauth.sampleapp.ui.theme.MeowAuthSampleTheme
import io.meowauth.sampleapp.ui.theme.PPObjectSans
import io.meowauth.sampleapp.ui.theme.PretendardFont
import java.util.concurrent.Executor

class TFATransactionActivity : AppCompatActivity() {
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var promptInfo: BiometricPrompt.PromptInfo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        executor = ContextCompat.getMainExecutor(this)
        biometricPrompt = BiometricPrompt(this, executor,
            object : BiometricPrompt.AuthenticationCallback() {
                override fun onAuthenticationError(errorCode: Int,
                                                   errString: CharSequence) {
                    super.onAuthenticationError(errorCode, errString)
                    Toast.makeText(applicationContext,
                        "Authentication error: $errString", Toast.LENGTH_SHORT)
                        .show()
                }

                override fun onAuthenticationSucceeded(
                    result: BiometricPrompt.AuthenticationResult) {
                    super.onAuthenticationSucceeded(result)
                    finish()
                }

                override fun onAuthenticationFailed() {
                    super.onAuthenticationFailed()
                    Toast.makeText(applicationContext, "Authentication failed",
                        Toast.LENGTH_SHORT)
                        .show()
                }
            })

        promptInfo = BiometricPrompt.PromptInfo.Builder()
            .setTitle("Approve Request")
            .setSubtitle("Sign with your device key to approve.")
            .setNegativeButtonText("Cancel")
            .build()
        Log.e("TFATrnasaction", "init auth")

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
                            text = "Hyojun’s iPhone is trying to send Meow Cats Collection #59 to address ryan.fn (0x655f6969fd4761ba).",
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
                                text = "Send Transaction",
                                fontFamily = PPObjectSans,
                                color = Color.White,
                                fontWeight = FontWeight.Medium,
                                fontSize = 16.sp,
                                letterSpacing = -(0.01).sp,
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
                                onClick = {
                                    Log.e("TFATrnasaction", "biometric auth")
                                    biometricPrompt.authenticate(promptInfo)
                                },
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
