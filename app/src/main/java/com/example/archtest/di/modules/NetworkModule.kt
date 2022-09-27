package com.example.archtest.di.modules

import android.content.Context
import com.example.common.scope.AuthUrl
import com.example.common.scope.SocialUrl
import com.example.common.Constant
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun provideHttpCache(@ApplicationContext context: Context): okhttp3.Cache {
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
        loggingInterceptor: HttpLoggingInterceptor,
        cache: okhttp3.Cache, //sharedPreference: SharedPreference,
    ): OkHttpClient {
        val client = OkHttpClient.Builder().cache(cache).addInterceptor(loggingInterceptor)
            .connectTimeout(200, TimeUnit.SECONDS).readTimeout(200, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val newRequest: Request =
                    chain.request().newBuilder().addHeader("Content-Type", "application/json")
                        //.addHeader("Authorization", "Bearer ${sharedPreference.getToken()}")
//                    .addHeader("User-Agent" , getDeviceUserAgent(context))
                        .build()
                chain.proceed(newRequest)
            }
        return client.build()
    }

    @Provides
    @Singleton
    @SocialUrl
    fun provideRetrofitSocial(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder().baseUrl(Constant.SOCIAL_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
    }

    @Provides
    @Singleton
    @AuthUrl
    fun provideRetrofitProfile(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
        return Retrofit.Builder().baseUrl(Constant.PROFILE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
    }
}
