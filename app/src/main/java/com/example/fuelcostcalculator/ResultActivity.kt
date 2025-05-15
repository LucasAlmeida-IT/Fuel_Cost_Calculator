package com.example.fuelcostcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

const val KEY_DISTANCE = "DistanceActivity.DISTANCE_KEY"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val fuelCost: Float = intent.getFloatExtra(KEY_FUEL_COST,0f)
        val tvFuelCost = findViewById<TextView>(R.id.tv_fuelPrice)

        val consumption: Float = intent.getFloatExtra(KEY_CONSUMPTION, 0.00f)
        val tvConsumption = findViewById<TextView>(R.id.tv_consumption)

        val distance: Float = intent.getFloatExtra(KEY_DISTANCE, 0.00f)
        val tvDistance = findViewById<TextView>(R.id.tv_distance)

        val result: Float = (fuelCost * distance)/consumption
        val tvResult = findViewById<TextView>(R.id.tv_result)

        tvFuelCost.text = "%.1f".format(fuelCost)
        tvConsumption.text = "%.1f".format(consumption)
        tvDistance.text = "%.1f".format(distance)
        tvResult.text = "€ %.1f".format(result)

        val btnNewCalculation = findViewById<Button>(R.id.btn_result)

        btnNewCalculation.setOnClickListener {

            val intentNewCalculate = Intent(this,MainActivity::class.java)
            startActivity(intentNewCalculate)

        }

    }
}