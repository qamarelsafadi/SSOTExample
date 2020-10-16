package net.qamar.ssotexample.data.model
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

class SearchResult {

    @field:Json(name ="Search")
   var search: ArrayList<Movie>? = null

    @field:Json(name = "totalResults")
    var totalResults = 0

    override fun toString(): String {
        return "SearchResult(search=$search, totalResults=$totalResults)"
    }

}