package com.zzz1zzz.simplecolorpicker.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.zzz1zzz.simplecolorpicker.R

internal class ColorPickerAdapter(private val listener: OnItemClickListener?) :
    RecyclerView.Adapter<ColorPickerAdapter.ViewHolder>() {
    private var mColors: List<String> = emptyList()

    fun setColors(colors: List<String>) {
        mColors = colors
    }

    override fun getItemCount() = mColors.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val rootView = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.color_picker_adapter, viewGroup, false) as CardView
        return ViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    inner class ViewHolder(private val rootView: CardView) :
        RecyclerView.ViewHolder(rootView) {

        fun bind(position: Int) {
            val color = mColors[position]
            rootView.setCardBackgroundColor(Color.parseColor(color))
            rootView.setOnClickListener {
                listener?.onItemClicked(color)
            }
        }
    }

}