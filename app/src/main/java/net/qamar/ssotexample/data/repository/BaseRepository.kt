package net.qamar.ssotexample.data.repository

import net.qamar.ssotexample.data.remote.RetrofitHelper


open class BaseRepository {

    fun getRetrofitHelper(): RetrofitHelper? {
        return RetrofitHelper()
    }
}