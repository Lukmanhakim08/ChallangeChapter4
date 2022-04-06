package com.example.challangechapter4

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class School(
    @PrimaryKey(autoGenerate = true)
    var id : Int?,

    @ColumnInfo(name = "namasekolah")
    var namasekolah : String,

    @ColumnInfo(name = "alamat")
    var alamat : String,

    @ColumnInfo(name = "tahun")
    var tahun : String

) : Parcelable
