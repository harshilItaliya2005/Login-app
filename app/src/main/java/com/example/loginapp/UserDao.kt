package com.example.loginapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Insert
    fun insertAll(users: User)

    @Query("SELECT * FROM user")
    fun selectAll() : List<User>

    @Query("SELECT * FROM user WHERE first_name = :name")
    fun selectUser(name : String): User

    @Query("UPDATE user SET first_name = :name , email = :email WHERE uid = :uid")
    fun updateUser(uid : Int,name : String,email : String)

    @Delete
    fun deleteData(users: User)

}