package com.example.tinda.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tinda.R
import com.example.tinda.ui.theme.LobsterFontFamily
import com.example.tinda.ui.theme.PoppinsFontFamily

@Composable
fun HeaderSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Column {
            Text(
                text = "MyTinda",
                fontSize = 45.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = LobsterFontFamily
            )
            Text(
                text = "Order your favourite food!",
                color = Color.Gray,
                fontFamily = PoppinsFontFamily
            )
        }

        Image(
            painter = painterResource(id = R.drawable.mask_group),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(RoundedCornerShape(10.dp))
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeaderSection() {
    HeaderSection()
}