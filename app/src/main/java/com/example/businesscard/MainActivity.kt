package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.MailOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    PersonalCard()
                }
            }
        }
    }
}

@Composable
fun PersonalCard() {
    Identity()
}

@Composable
fun Identity(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.avatar)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().background(Color.Black)
    ) {
        Image(
            painter = image,
            contentDescription = "Personal Image",
            modifier = modifier.clip(CircleShape)
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Victor Rodrigues Novais",
            modifier = modifier,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(Modifier.height(5.dp))
        Text(
            text = "Mobile Developer",
            modifier = modifier,
            color = Color.White
        )
        Spacer(Modifier.height(60.dp))
        Column {
            Social(icon = Icons.Rounded.Call, imageDescription = "Phone icon", description = "+55 11 98357-1644")
            Spacer(Modifier.height(2.dp))
            Social(icon = Icons.Rounded.FavoriteBorder, imageDescription = "Favorite icon", description = "@victorb132")
            Spacer(Modifier.height(2.dp))
            Social(icon = Icons.Rounded.MailOutline, imageDescription = "Mail icon", description = "victor96novais@gmail.com")
        }
    }
}

@Composable
fun Social(icon: ImageVector, imageDescription: String, description: String) {
    Row() {
        Icon(icon, contentDescription = imageDescription, tint = Color.White)
        Spacer(Modifier.width(10.dp))
        Text(
            text = description,
            color = Color.White
        )
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        PersonalCard()
    }
}