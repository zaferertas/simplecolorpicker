package com.zzz1zzz.simplecolorpicker.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.Slider
import com.zzz1zzz.simplecolorpicker.ColorPickerListener
import com.zzz1zzz.simplecolorpicker.data.ColorPickerRepository
import com.zzz1zzz.simplecolorpicker.R


internal class ColorPickerDialog(
    private val title: String?,
    private val context: Context,
    private val colorPickerListener: ColorPickerListener?,
    private val repository: ColorPickerRepository = ColorPickerRepository(context)
) {

    fun show() {
        var dialog: AlertDialog? = null
        val dialogTitle = title ?: context.resources.getString(R.string.colorPicker_dialogTitle)
        val builder = AlertDialog.Builder(context)
            .setTitle(dialogTitle)
            .setNegativeButton(context.resources?.getString(android.R.string.cancel), null)

        val dialogView = LayoutInflater.from(context).inflate(R.layout.color_picker_dialog, null) as View
        val recyclerView: RecyclerView = dialogView.findViewById(R.id.colorPicker_gridView)

        val adapter = ColorPickerAdapter(object: OnItemClickListener {
            override fun onItemClicked(color: String) {
                colorPickerListener?.onColorSelected(color)
                dialog?.dismiss()
            }
        })
        adapter.setColors(repository.getColors())
        recyclerView.adapter = adapter

        val slider = dialogView.findViewById<Slider>(R.id.colorPicker_slider)
        slider.value = repository.getTone().toFloat()
        slider.addOnChangeListener { _, value, _ ->
            repository.setTone(value.toInt().toString())
            adapter.setColors(repository.getColors())
            adapter.notifyDataSetChanged()
        }

        builder.setView(dialogView)
        dialog = builder.create()
        dialog.show()
    }
}