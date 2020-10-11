package net.qamar.ssotexample.data.remote.api

import net.qamar.ssotexample.data.model.SearchResult
import retrofit2.Response
import retrofit2.http.GET
import rx.Single


interface MovieApi {
        @GET("/?s=Batman&page=1&apikey=96099fe3")
        fun movieList(): Single<Response<SearchResult?>?>?

}