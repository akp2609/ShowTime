package project.dheeraj.showtime.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import project.dheeraj.showtime.data.api.NetworkService
import project.dheeraj.showtime.utils.CONSTANTS
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/** ShowTime by Aman Kumar Pandey */

@Module
@InstallIn(ApplicationComponent::class)
class ApiModule {

    @Provides
    @Singleton
    operator fun invoke() : NetworkService {
        return Retrofit.Builder()
                .baseUrl(CONSTANTS.BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NetworkService::class.java)
    }


}