package net.qamar.ssotexample.util.di

import dagger.Module
import dagger.Provides
import net.qamar.ssotexample.data.remote.RetrofitHelper
import net.qamar.ssotexample.data.remote.api.MovieApi
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun movieApi(): MovieApi = RetrofitHelper().getService(MovieApi::class.java)




}