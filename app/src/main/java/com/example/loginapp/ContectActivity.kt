package com.example.loginapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.LoginAppTheme

@Suppress("DEPRECATION")
class ContactActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                Design()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Design() {
        val firstName = remember { mutableStateOf("") }
        val suraName = remember { mutableStateOf("") }
        val phone = remember { mutableStateOf("") }

        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color(0xFFBBDEFB), Color(0xFF64B5F6))
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Add To Contacts",
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )

                    OutlinedTextField(
                        value = firstName.value,
                        onValueChange = { firstName.value = it },
                        label = { Text("First Name") },
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.Gray,
                            containerColor = Color.Transparent
                        )
                    )

                    OutlinedTextField(
                        value = suraName.value,
                        onValueChange = { suraName.value = it },
                        label = { Text("Surname") },
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.Gray,
                            containerColor = Color.Transparent
                        )
                    )

                    OutlinedTextField(
                        value = phone.value,
                        onValueChange = { phone.value = it },
                        label = { Text("Phone Number") },
                        modifier = Modifier.padding(top = 16.dp).fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.Gray,
                            containerColor = Color.Transparent
                        )
                    )

                    ElevatedButton (
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        border = BorderStroke(3.dp, Color(0xFF00B8D4)),
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.Transparent, containerColor = Color.Transparent
                        )
                    ) {
                        Text(
                            text = "Submit",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Black

                        )
                    }
                }
            }
        }
    }
}
