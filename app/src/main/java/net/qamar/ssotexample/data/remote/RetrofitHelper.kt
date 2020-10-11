package net.qamar.ssotexample.data.remote


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import net.qamar.ssotexample.data.util.ThingArrayListMoshiAdapter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import rx.Single
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * RetrofitHelper
 */
class RetrofitHelper {
    private val BASE_URL = "http://www.omdbapi.com"
    private val retrofit: Retrofit.Builder
    var moshi =
        Moshi.Builder()
            .add(ThingArrayListMoshiAdapter())
            .add(KotlinJsonAdapterFactory())
            .build()

    fun <T> getService(tService: Class<T>?): T {
        return retrofit.build().create(tService)
    }

    interface ApiListener<T> {
        fun onSuccess(t: T)
        fun onError(throwable: Throwable?)
        fun onServerError(errorMessage: String?)
    }

    companion object {
        fun <T> request(
            single: Single<Response<T>>,
            listener: ApiListener<T?>
        ) {
            single.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(
                { tResponse: Response<T> ->
                    if (tResponse.isSuccessful) {
                        listener.onSuccess(tResponse.body())
                    } else {
                        listener.onServerError(tResponse.errorBody().toString())
                    }
                }
            ) { throwable: Throwable? ->
                listener.onError(
                    throwable
                )
            }
        }
    }

    init {
        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient().newBuilder()
                    .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
    }
}