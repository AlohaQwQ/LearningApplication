package com.star.learningapplication.room.model.user

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User2 {

    @PrimaryKey(autoGenerate = true)
    var uid = ObservableField<String>()

    @ColumnInfo(name = "token")
    var token = ObservableField<String>()

    @ColumnInfo(name = "phoneNo")
    var phoneNo = ObservableInt()

    var map = ObservableArrayMap<String, Any>().apply {
        put("firstName", "Google")
        put("lastName", "Inc.")
        put("age", 17)
    }

}