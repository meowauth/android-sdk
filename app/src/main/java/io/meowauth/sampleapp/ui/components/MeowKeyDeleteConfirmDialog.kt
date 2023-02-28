package io.meowauth.sampleapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import io.meowauth.sampleapp.R
import io.meowauth.sampleapp.ui.theme.PPObjectSans
import io.meowauth.sampleapp.ui.theme.PretendardFont

@Composable
fun MeowKeyDeleteConfirmDialog(
    onCancelButtonClick: () -> Unit,
    onRevokeButtonClick: () -> Unit,
    onDismiss: () -> Unit,
) {
    Dialog(
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true,
        ),
        onDismissRequest = onDismiss,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF262626))
                .padding(24.dp)
        ) {
            Text(
                text = "Are you sure you want to revoke the Custodial Key?",
                fontFamily = PPObjectSans,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                color = Color.White,
                letterSpacing = (-0.01).sp,
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(11.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 26.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF1CC88A).copy(alpha = 0.3f))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_thumbs_up),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(19.dp)
                            .align(Alignment.Center),
                    )
                }
                Text(
                    text = "You can take over the full control of your wallet.",
                    fontFamily = PretendardFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 17.sp,
                    color = Color(0xFF828282),
                    letterSpacing = (-0.01).sp,
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(11.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 14.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFFFE173).copy(alpha = 0.3f))
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_warning),
                        contentDescription = null,
                        tint = Color.Unspecified,
                        modifier = Modifier
                            .size(19.dp)
                            .align(Alignment.Center),
                    )
                }
                Text(
                    text = "Every time you send a transaction, 2FA must be required.",
                    fontFamily = PretendardFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp,
                    lineHeight = 17.sp,
                    color = Color(0xFF828282),
                    letterSpacing = (-0.01).sp,
                )
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(7.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 41.dp),
            ) {
                MeowButton(
                    label = "Cancel",
                    backgroundColor = Color(0xFF616161).copy(alpha = 0.3f),
                    labelColor = Color(0xFF828282),
                    contentPadding = PaddingValues(horizontal = 40.dp, vertical = 9.dp),
                    onClick = onCancelButtonClick,
                    modifier = Modifier.weight(1f)
                )
                MeowButton(
                    label = "Revoke",
                    backgroundColor = Color(0xFF616161),
                    labelColor = Color.White,
                    contentPadding = PaddingValues(horizontal = 40.dp, vertical = 9.dp),
                    onClick = onRevokeButtonClick,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
