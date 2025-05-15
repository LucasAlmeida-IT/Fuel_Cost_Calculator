package com.example.fuelcostcalculator

import android.content.Intent
import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

const val KEY_FUEL_COST = "FuelCostActivity.FUEL_KEY"

class ConsumptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumption)

        val fuelCost = intent.getFloatExtra(KEY_FUEL_COST, 0.0f)
        val consumption = findViewById<TextInputEditText>(R.id.edt_Consumption)
        val btnConsumption = findViewById<Button>(R.id.Consumption_button)

        btnConsumption.setOnClickListener {

            val edtConsumption: String = consumption.text.toString()

            if ( edtConsumption == "" ) {

                Snackbar.make(
                    consumption,
                    "Please fill in all fields!",
                    Snackbar.LENGTH_LONG
                ).show()

            } else {

                val carConsumption: Float = edtConsumption.toFloat()

                val intentConsumption = Intent(this, DistanceActivity::class.java)
                intentConsumption.putExtra(KEY_CONSUMPTION, carConsumption)
                intentConsumption.putExtra(KEY_FUEL_COST, fuelCost)
                startActivity(intentConsumption)

            }

        }

    }
}