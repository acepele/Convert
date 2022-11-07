package com.example.convert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.mipmap.ic_launcher)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val convertNum = findViewById<EditText>(R.id.idMesurement)
        val btnDollarToEuro = findViewById<RadioButton>(R.id.idBtn1)
        val btnEuroToDollar = findViewById<RadioButton>(R.id.idBtn2)
        val txtResult = findViewById<TextView>(R.id.idResult)
        val convertIt = findViewById<Button>(R.id.idBtnConvert)


        convertIt.setOnClickListener {
            val tenth = DecimalFormat("#.#")
            val db1Measure = convertNum.text.toString().toDouble()
            val conversionRate = 1.47
            var convertMeasureNum: Double?

            if (btnDollarToEuro.isChecked) {
                if (db1Measure <= 10000) {
                    convertMeasureNum = db1Measure * conversionRate
                    txtResult.text = tenth.format(convertMeasureNum) + " $ "
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Currency in Dollar must be less than 10,000.00",
                        Toast.LENGTH_LONG
                    ).show()
                }

                if (btnEuroToDollar.isChecked) {
                    if (db1Measure <= 10000) {
                        convertMeasureNum = db1Measure / conversionRate
                        txtResult.text = tenth.format(convertMeasureNum) + " Euro "
                    } else {
                        Toast.makeText(
                            this@MainActivity,
                            "Currency in Euros must be less than 10,000.00",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }


            }

        }
    }
}


