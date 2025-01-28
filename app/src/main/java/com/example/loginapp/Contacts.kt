package com.example.loginapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contacts")
data class Contacts(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        @ColumnInfo(name = "first_name") val firstName: String,
        @ColumnInfo(name = "surname") val surname: String,
        @ColumnInfo(name = "phone") val phone: String
)

