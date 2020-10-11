package net.qamar.ssotexample.data.util.di

import dagger.Component
import net.qamar.ssotexample.data.repository.MovieRepository
import javax.inject.Singleton
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(movieRepository: MovieRepository)


}