package com.example.loginapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContactDao {

    @Insert
    fun insert(contact: Contacts)

    @Query("SELECT * FROM contacts")
    fun selectAllContacts(): List<Contacts>
}

