package com.example.loginapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.ui.theme.LoginAppTheme

class HomePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Design()
            }
        }
    }

    @Composable
    fun Design() {
        Scaffold {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color(0xFFBBDEFB), Color(0xFF64B5F6))
                        )
                    )
            ) {
                Box(
                    modifier = Modifier
                        .weight(.05f)
                        .fillMaxSize()
                ) {
                }

                Column(
                    modifier = Modifier
                        .weight(.5f)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "username",
                        color = Color.Black,
                        fontSize = 30.sp,
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(.5f)
                        .fillMaxSize()
                        .padding(30.dp),
                    verticalArrangement = Arrangement.Bottom,
                    horizontalAlignment = Alignment.End
                ) {
                    FloatingActionButton(
                        onClick = {
                            val intent = Intent(applicationContext, ContactActivity::class.java)
                            startActivity(intent)
                        },
                        modifier = Modifier.size(70.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.aadd),
                            contentDescription = "",
                            modifier = Modifier.size(50.dp)
                        )
                    }
                }
            }

        }
    }
}
