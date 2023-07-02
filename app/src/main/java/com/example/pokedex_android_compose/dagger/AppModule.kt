package com.example.pokedex_android_compose.dagger

import com.example.pokedex_android_compose.network.AppRepository
import com.example.pokedex_android_compose.network.AppRepositoryImpl
import com.example.pokedex_android_compose.network.AppService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.newBuilder().build())
            .build()
    }

    @Provides
    @Singleton
    fun providesAppService(retrofit: Retrofit): AppService {
        return retrofit.create(AppService::class.java)
    }

    @Provides
    fun providesAppRepository(appService: AppService): AppRepository {
        return AppRepositoryImpl(appService)
    }
}