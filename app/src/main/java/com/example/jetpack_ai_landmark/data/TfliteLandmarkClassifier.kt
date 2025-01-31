package com.example.jetpack_ai_landmark.data

import android.content.Context
import android.graphics.Bitmap
import com.example.jetpack_ai_landmark.domain.Classification
import com.example.jetpack_ai_landmark.domain.LandmarkClassifier
import org.tensorflow.lite.task.core.BaseOptions
import org.tensorflow.lite.task.vision.classifier.ImageClassifier

class TfliteLandmarkClassifier(
    private val context: Context,
    private val threshold: Float = 0.5f,
    private val maxResult: Int = 1
) : LandmarkClassifier {

    private var classifier: ImageClassifier? = null

    private fun setUpClassifier() {
        val baseOptions = BaseOptions.builder()
            .setNumThreads(2)
            .build()
        val options = ImageClassifier.ImageClassifierOptions.builder()
            .setBaseOptions(baseOptions)
            .setMaxResults(maxResult)
            .setScoreThreshold(threshold)
            .build()

        try {
            classifier = ImageClassifier.createFromFileAndOptions(
                context, "1.tflite", options
            )
        } catch (e: IllegalStateException) {
            e.printStackTrace()

        }
    }


    override fun classify(bitmap: Bitmap, rotation: Int): List<Classification> {

    }


}