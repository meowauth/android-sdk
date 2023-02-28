package io.meowauth.sampleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.meowauth.sampleapp.ui.theme.PretendardFont

@Composable
fun MeowButton(
    modifier: Modifier = Modifier,
    label: String,
    isEnabled: Boolean = true,
    labelFont: FontFamily = PretendardFont,
    labelWeight: FontWeight = FontWeight.Medium,
    labelColor: Color = Color(0xfffbfbfb),
    backgroundColor: Color = Color(0xff171C20),
    shape: Shape = RoundedCornerShape(16.dp),
    contentPadding: PaddingValues = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
    icon: (@Composable () -> Unit)? = null,
    iconSpacing: Dp = 12.dp,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(shape)
            .background(backgroundColor)
            .clickable(enabled = isEnabled, onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(contentPadding),
        ) {
            icon?.let {
                it()
                Spacer(modifier = Modifier.width(iconSpacing))
            }

            Text(
                text = label,
                fontWeight = labelWeight,
                fontFamily = labelFont,
                letterSpacing = (-0.01).sp,
                color = labelColor
            )
        }
    }
}
