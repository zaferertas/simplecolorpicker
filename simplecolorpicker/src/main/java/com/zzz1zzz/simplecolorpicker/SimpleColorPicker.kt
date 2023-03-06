package com.zzz1zzz.simplecolorpicker

import android.content.Context
import com.zzz1zzz.simplecolorpicker.ui.ColorPickerDialog

class SimpleColorPicker private constructor(
    private val context: Context,
    private val title: String?,
    private val colorPickerListener: ColorPickerListener?,
) {

    class Builder(private val context: Context) {
        private var title: String? = null
        private var colorPickerListener: ColorPickerListener? = null

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setListener(listener: ColorPickerListener): Builder {
            this.colorPickerListener = listener
            return this
        }

        fun build() = SimpleColorPicker(
            context = context,
            title = title,
            colorPickerListener = colorPickerListener,
        )
    }

    fun show() = ColorPickerDialog(title, context, colorPickerListener).show()
}