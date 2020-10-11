package net.qamar.ssotexample.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity
class Movie {
    @PrimaryKey
    lateinit var imdbID: String

    @field:Json(name ="Title")
    var title: String? = null

    @field:Json(name = "Year")
    var year: String? = null

    @field:Json(name = "Type")
    var type: String? = null

    @field:Json(name = "Poster")
    var poster: String? = null

    @field:Json(name = "Rated")
    var rated: String? = null

    @field:Json(name = "Released")
    var released: String? = null

    @field:Json(name = "Genre")
    var genre: String? = null

    @field:Json(name = "Director")
    var director: String? = null

    @field:Json(name = "Country")
    var country: String? = null

    @field:Json(name = "Awards")
    var awards: String? = null
    var imdbRating: String? = null

    @field:Json(name = "BoxOffice")
    var boxOffice: String? = null

    @field:Json(name = "Website")
    var website: String? = null
    override fun toString(): String {
        return "Movie(imdbID='$imdbID', title=$title, year=$year, type=$type, poster=$poster, rated=$rated, released=$released, genre=$genre, director=$director, country=$country, awards=$awards, imdbRating=$imdbRating, boxOffice=$boxOffice, website=$website)"
    }

}