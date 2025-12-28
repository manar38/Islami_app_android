package com.example.islami_app.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Chapter (
    val index: Int,
    val titleAr: String,
   val titleEn: String,
   val ayaNum: String


):Parcelable
