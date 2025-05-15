package com.example.fuelcostcalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_CONSUMPTION = "ConsumptionActivity.CONSUMPTION_KEY"

class DistanceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distance)

        val distance = findViewById<TextInputEditText>(R.id.edt_Distance)
        val fuelCost = intent.getFloatExtra(KEY_FUEL_COST, 0.0f)
        val consumption = intent.getFloatExtra(KEY_CONSUMPTION, 0.0f)
        val btnDistance = findViewById<Button>(R.id.distance_button)

        btnDistance.setOnClickListener {

            val edtDistance: String = distance.text.toString()

            if( edtDistance == "") {

                Snackbar.make(
                    distance,
                    "Please fill in all fields!",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {

                val distanceKM = edtDistance.toFloat()

                val intentDistance = Intent(this, ResultActivity::class.java)
                intentDistance.putExtra(KEY_FUEL_COST, fuelCost)
                intentDistance.putExtra(KEY_CONSUMPTION, consumption)
                intentDistance.putExtra(KEY_DISTANCE, distanceKM)
                startActivity(intentDistance)

            }

        }

    }
}