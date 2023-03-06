package com.zzz1zzz.simplecolorpicker.data

import android.content.Context

internal class ColorPickerRepository(
    context: Context?
) {
    private val sharedPref = context?.applicationContext?.getSharedPreferences(
        COLOR_PICKER_PREFERENCES, Context.MODE_PRIVATE
    )
    private val colorsDataSource = ColorsDataSource(context)

    fun getColors(): List<String> = colorsDataSource.getColors(getTone())

    fun getTone() = sharedPref?.getString(SELECTED_COLOR_TONE, DEFAULT_COLOR_TONE).orEmpty()

    fun setTone(tone: String) =
        sharedPref?.edit()?.putString(SELECTED_COLOR_TONE, tone)?.apply()

    companion object {
        private const val DEFAULT_COLOR_TONE = "500"
        private const val SELECTED_COLOR_TONE = "color_picker_selected_color_tone"
        private const val COLOR_PICKER_PREFERENCES = "color_picker_preferences"
    }
}
