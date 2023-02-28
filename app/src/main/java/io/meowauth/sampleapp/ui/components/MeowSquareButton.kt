package io.meowauth.sampleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.meowauth.sampleapp.ui.theme.PretendardFont

@Composable
fun MeowSquareButton(
    modifier: Modifier = Modifier,
    iconResource: Int,
    label: String,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(9.dp)
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF262626))
                .clickable { onClick() }
        ) {
            Icon(
                painter = painterResource(id = iconResource),
                contentDescription = null,
                tint = Color(0xFFC0C0C0),
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center),
            )
        }
        Text(
            text = label,
            fontFamily = PretendardFont,
            color = Color(0xFFC0C0C0),
            letterSpacing = -(0.01).sp,
            fontSize = 14.sp,
        )
    }
}
