package com.example.fuelcostcalculator

import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.snackbar.Snackbar.SnackbarLayout
import com.google.android.material.textfield.TextInputEditText

class FuelCostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fuel_cost)

        val fuelPrice = findViewById<TextInputEditText>(R.id.edt_FuelPrice)
        val btnFuelCost = findViewById<Button>(R.id.FuelCost_button)

        btnFuelCost.setOnClickListener {

            val edtprice: String = fuelPrice.text.toString()

            if ( edtprice == "" ) {
                Snackbar.make(
                    fuelPrice,
                    "Please fill in all fields!",
                    Snackbar.LENGTH_LONG
                )
                    .show()
            } else {

                val price: Float = edtprice.toFloat()

                val intentPrice = Intent(this,ConsumptionActivity::class.java)
                intentPrice.putExtra(KEY_FUEL_COST, price)
                startActivity(intentPrice)

            }

        }

    }
}