package com.example.loginapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.room.Room
import com.example.loginapp.ui.theme.LoginAppTheme
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@OptIn(DelicateCoroutinesApi::class)
class ContactActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppTheme {
                ContactScreen()
            }
        }
    }

    @OptIn(
        ExperimentalMaterial3Api::class, DelicateCoroutinesApi::class,
        DelicateCoroutinesApi::class
    )
    @Composable
    fun ContactScreen() {
        val firstName = remember { mutableStateOf("") }
        val suraName = remember { mutableStateOf("") }
        val phone = remember { mutableStateOf("") }

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "Contact-Data"
        ).build()

        var contactsList by remember { mutableStateOf<List<Contacts>>(emptyList()) }

        fun loadContacts() {
            GlobalScope.launch {
                contactsList = db.contactDao().selectAllContacts()
            }
        }

        LaunchedEffect(Unit) {
            loadContacts()
        }

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
                        textStyle = TextStyle(color = Color.Black,fontSize = 20.sp),
                        label = { Text("First Name") },
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
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
                        textStyle = TextStyle(color = Color.Black,fontSize = 20.sp),
                        label = { Text("Surname") },
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
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
                        textStyle = TextStyle(color = Color.Black,fontSize = 20.sp),
                        label = { Text("Phone Number") },
                        modifier = Modifier
                            .padding(top = 16.dp)
                            .fillMaxWidth(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.Gray,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.Gray,
                            containerColor = Color.Transparent
                        )
                    )

                    ElevatedButton(
                        onClick = {
                            if (firstName.value.isNotBlank() && suraName.value.isNotBlank() && phone.value.isNotBlank()) {

                                try {
                                    GlobalScope.launch {
                                        db.contactDao().insert(
                                            Contacts(
                                                firstName = firstName.value,
                                                surname = suraName.value,
                                                phone = phone.value
                                            )
                                        )
                                    }
                                } catch (e: Exception) {
                                    Log.d("My", "Error : $e")
                                }
                            }
                        },
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
