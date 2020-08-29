package com.daniyalak.stepcounterkotlin_androidfitnessapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daniyalak.stepcounterkotlin_androidfitnessapp.R
import com.daniyalak.stepcounterkotlin_androidfitnessapp.callback.stepsCallback
import com.daniyalak.stepcounterkotlin_androidfitnessapp.helper.GeneralHelper
import com.daniyalak.stepcounterkotlin_androidfitnessapp.service.StepDetectorService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), stepsCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this, StepDetectorService::class.java)
        startService(intent)

        StepDetectorService.subscribe.register(this)
    }

    override fun subscribeSteps(steps: Int) {
        TV_STEPS.setText(steps.toString())
        TV_CALORIES.setText(GeneralHelper.getCalories(steps))
        TV_DISTANCE.setText(GeneralHelper.getDistanceCovered(steps))
    }
}