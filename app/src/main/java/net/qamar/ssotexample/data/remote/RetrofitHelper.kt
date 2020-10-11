package net.qamar.ssotexample.data.remote


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import net.qamar.ssotexample.data.util.ThingArrayListMoshiAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * RetrofitHelper
 */
class RetrofitHelper {
    private val BASE_URL = "http://www.omdbapi.com"
    private val retrofit: Retrofit.Builder
    private var moshi =
        Moshi.Builder()
            .add(ThingArrayListMoshiAdapter())
            .add(KotlinJsonAdapterFactory())
            .build()!!

    fun <T> getService(tService: Class<T>?): T {
        return retrofit.build().create(tService!!)
    }

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient().newBuilder()
                    .addNetworkInterceptor(httpLoggingInterceptor.apply {
                        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
    }
}