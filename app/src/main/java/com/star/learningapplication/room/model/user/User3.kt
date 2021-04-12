package com.star.learningapplication.room.model.user

import androidx.databinding.*
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User3 : BaseObservable() {

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

    @get:Bindable
    var firstName: String = ""
        set(value) {
            field = value
            //notifyPropertyChanged(BR.viewmodel)
        }

    @get:Bindable
    var lastName: String = ""
        set(value) {
            field = value
            //notifyPropertyChanged(BR.lastName)
        }

    
}