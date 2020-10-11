package net.qamar.ssotexample.data.util

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import net.qamar.ssotexample.data.model.Movie

class ThingArrayListMoshiAdapter {
    @ToJson
    fun arrayListToJson(list: ArrayList<Movie>): List<Movie> = list

    @FromJson
    fun arrayListFromJson(list: List<Movie>): ArrayList<Movie> = ArrayList(list)
}