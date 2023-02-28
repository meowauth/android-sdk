package io.meowauth.sampleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.meowauth.sampleapp.R
import io.meowauth.sampleapp.ui.theme.PretendardFont

@Composable
fun MeowDeviceItem(
    modifier: Modifier = Modifier,
    isDevice: Boolean = true,
    title: String,
    keyHash: String,
    dateLocation: String = "",
    isThisDevice: Boolean = false,
    onDeleteClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier.width(16.dp))
        if (isDevice) {
            Icon(
                painter = painterResource(id = R.drawable.icon_device),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.icon_key),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier.padding(vertical = 7.dp)
        ) {
            Text(
                text = title,
                fontFamily = PretendardFont,
                color = Color.White,
                fontWeight = FontWeight.W600,
                letterSpacing = (-0.01).sp,
            )
            Row(verticalAlignment = Alignment.CenterVertically) {
                if (!isDevice) {
                    Text(
                        text = "On Server",
                        fontFamily = PretendardFont,
                        color = Color(0xFF1983FF),
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        letterSpacing = (-0.01).sp,
                    )
                } else if (isDevice && isThisDevice) {
                    Text(
                        text = "This Device",
                        fontFamily = PretendardFont,
                        color = Color(0xFF1CC88A),
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        letterSpacing = (-0.01).sp,
                    )
                } else {
                    Text(
                        text = dateLocation,
                        fontFamily = PretendardFont,
                        color = Color(0xFF828282),
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        letterSpacing = (-0.01).sp,
                    )
                }

                Text(
                    text = " · $keyHash",
                    fontFamily = PretendardFont,
                    color = Color(0xFF828282),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    letterSpacing = (-0.01).sp,
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .clickable { onDeleteClick() }
                .background(Color(0xFF262626)),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_delete),
                contentDescription = null,
                tint = Color(0xFFA1A1A1),
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}
