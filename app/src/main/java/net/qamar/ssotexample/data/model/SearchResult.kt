package net.qamar.ssotexample.data.model
import com.squareup.moshi.Json
import java.util.*


class SearchResult {
    @field:Json(name ="Search")
    var search: ArrayList<Movie>? = null

    @field:Json(name = "totalResults")
    var totalResults = 0

    @field:Json(name = "Response")
    var isResponse = false

}