package com.daniel.data.di

import com.daniel.data.BuildConfig.SERVER_URL
import com.daniel.data.dto.EmojiDTOList
import com.daniel.data.service.EmojiDataParser
import com.daniel.data.service.GithubService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    factory {
        getCharacterService(
            get<Retrofit>()
        )
    }

    single {
        createGithubService(
            get<OkHttpClient>()
        )
    }

    factory {
        createOkHttpClient()
    }
}

val gsonBuilder = GsonBuilder().apply {
    registerTypeAdapter(EmojiDTOList::class.java, EmojiDataParser())
}

private fun getCharacterService(retrofit: Retrofit): GithubService =
        retrofit.create(GithubService::class.java)

private fun createGithubService(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
        .build()

private fun createOkHttpClient(): OkHttpClient {
    val timeoutInSeconds = 10L
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(timeoutInSeconds, TimeUnit.SECONDS)
        .readTimeout(timeoutInSeconds, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}
