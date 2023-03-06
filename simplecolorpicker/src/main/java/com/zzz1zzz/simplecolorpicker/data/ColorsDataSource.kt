package com.zzz1zzz.simplecolorpicker.data

import android.content.Context
import org.json.JSONObject

internal class ColorsDataSource(private val context: Context?) {

    private lateinit var mColorMap: Map<String, MutableList<String>>

    fun getColors(tone: String): List<String> {
        if (!::mColorMap.isInitialized) {
            mColorMap = getColorsFromAsset(context)
        }
        return mColorMap[tone] ?: emptyList()
    }

    private fun getColorsFromAsset(context: Context?): HashMap<String, MutableList<String>> {
        val colorsMap = HashMap<String, MutableList<String>>()
        val file = readAssetFile(context)
        file?.let {
            val jsonObject = JSONObject(it)

            for (key in jsonObject.keys()) {
                val jsonArray = jsonObject.getJSONArray(key)
                val colorsList = mutableListOf<String>()
                for (i in 0 until jsonArray.length()) {
                    val color = jsonArray.getString(i)
                    colorsList.add(color)
                }
                colorsMap[key] = colorsList
            }
        }
        return colorsMap
    }

    private fun readAssetFile(context: Context?): String? {
        return context?.assets?.open("material-colors.json")
            ?.bufferedReader().use { reader->
                reader?.readText()
            }
    }
}
