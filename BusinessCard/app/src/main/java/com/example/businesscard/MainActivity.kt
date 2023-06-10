package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(211,232,213)//MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Title(
            "Jennifer Doe",
            "Android Developer Extraordinaire",
            modifier = Modifier
                .weight(1f)
        )
        ContactInfo(
            "+11 (123) 444 555 666",
            "@AndroidDev" ,
            "jen.doe@android.com",
            modifier = Modifier
        )
    }
}

@Composable
fun Title(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(Color(7, 48, 66))
                .width(128.dp)
                .height(128.dp)
                .padding(2.dp)
        )
        Text(
            text = name,
            color = Color.Black,
            fontSize = 45.sp,
            modifier = Modifier
        )
        Text(
            text = title,
            color = Color(1,122,74),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
        )
    }
}

@Composable
fun ContactInfo(mobile: String, social: String, email: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .padding(bottom = 30.dp)
    ) {
        ContactInfoRow(Icons.Rounded.Phone, mobile)
        ContactInfoRow(Icons.Rounded.Share, social)
        ContactInfoRow(Icons.Rounded.Email, email)
    }
}

@Composable
fun ContactInfoRow(icon: ImageVector, detail: String, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .height(40.dp)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Mobile",
            tint = Color(1,122,74),
            modifier = Modifier
                .height(25.dp)
        )
        Text(
            text = detail,
            color = Color.Black,
            fontSize = 15.sp
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}