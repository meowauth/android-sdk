package io.meowauth.sampleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import io.meowauth.sampleapp.ui.theme.PPObjectSans
import io.meowauth.sampleapp.ui.theme.PretendardFont

@Composable
fun MeowGreenInformation(
    modifier: Modifier = Modifier,
    iconResource: Int,
    title: String,
    description: String,
    onClick: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxWidth()) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF00EF8B).copy(alpha = 0.2f))
        ) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(start = 16.dp, top = 16.dp)
                    .size(32.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(6.dp),
                modifier = Modifier.padding(top = 16.dp, bottom = 19.dp, end = 29.dp)
            ) {
                Text(
                    text = title,
                    fontFamily = PPObjectSans,
                    color = Color(0xFFA4DFC6),
                    fontWeight = FontWeight.Medium,
                    letterSpacing = (-0.01).sp,
                    fontSize = 16.sp,
                )
                Text(
                    text = description,
                    fontFamily = PretendardFont,
                    color = Color(0xFFA4DFC6),
                    fontWeight = FontWeight.Normal,
                    letterSpacing = (-0.01).sp,
                    fontSize = 14.sp,
                )
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.icon_x),
            contentDescription = null,
            tint = Color(0xFF85BEA6),
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 40.dp, end = 30.dp)
                .size(16.dp)
                .clickable { onClick() }
        )
    }
}
