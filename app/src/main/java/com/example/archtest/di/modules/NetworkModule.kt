package com.example.archtest.di.modules

import android.content.Context
import com.example.archtest.di.scope.AuthUrl
import com.example.common.Constant
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideHttpCache(context: Context): okhttp3.Cache {
        val cacheSize: Long = 10 * 10 * 1024
        return okhttp3.Cache(context.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @Singleton
    fun provideOkHttpClientAuth(
        context: Context,
        loggingInterceptor: HttpLoggingInterceptor,
        cache: okhttp3.Cache, //sharedPreference: SharedPreference,
    ): OkHttpClient {
        val client = OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(200, TimeUnit.SECONDS)
            .readTimeout(200, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val newRequest: Request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    //.addHeader("Authorization", "Bearer ${sharedPreference.getToken()}")
//                    .addHeader("User-Agent" , getDeviceUserAgent(context))
                    .build()
                chain.proceed(newRequest)
            }
        return client.build()
    }

    @Provides
    @Singleton
    @AuthUrl
    fun provideRetrofitAuth(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constant.AUTH_URL_NEW)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build()
    }
}
