@file:Suppress("DEPRECATED_ANNOTATION")

package com.example.submit1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Anggota(
    var photo: Int,
    var name: String,
    var location: String,
    var username: String,
    var company: String,
    val repository: Int,
    val followers: Int,
    val followings: Int

) : Parcelable
