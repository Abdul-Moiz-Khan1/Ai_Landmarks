package com.example.jetpack_ai_landmark.domain

import android.graphics.Bitmap

interface LandmarkClassifier {

    fun classify(bitmap: Bitmap , rotation:Int):List<Classification>
}