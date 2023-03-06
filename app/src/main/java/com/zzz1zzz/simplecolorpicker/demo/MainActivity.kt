package com.zzz1zzz.simplecolorpicker.demo

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.zzz1zzz.simplecolorpicker.ColorPickerListener
import com.zzz1zzz.simplecolorpicker.SimpleColorPicker

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById<Button?>(R.id.select_color_button).also {
            it.setOnClickListener {
                showColorPicker()
            }
        }
    }

    private fun showColorPicker() {
        SimpleColorPicker.Builder(this)
            .setTitle("Select Color") // Optional
            .setListener(object : ColorPickerListener {
                override fun onColorSelected(color: String) {
                    button.setBackgroundColor(Color.parseColor(color))
                }
            })
            .build()
            .show()
    }
}