package com.example.archtestdagger.di

import android.content.Context
import com.example.common.Constant
import com.example.common.scope.SocialUrl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


@Module
class NetworkModule {
    @Provides
    fun provideHttpCache(context: Context): Cache {
        val cacheSize: Long = 10 * 10 * 1024
        return Cache(context.cacheDir, cacheSize)
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Provides
    fun provideOkHttpClientAuth(
        loggingInterceptor: HttpLoggingInterceptor,
        cache: Cache, //sharedPreference: SharedPreference,
    ): OkHttpClient {
        val client = OkHttpClient.Builder().cache(cache).addInterceptor(loggingInterceptor)
            .connectTimeout(200, TimeUnit.SECONDS).readTimeout(200, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val newRequest: Request = chain.request().newBuilder()
                    .addHeader("Content-Type", "application/json").build()
                // .addHeader("Authorization", "Bearer ${sharedPreference.getToken()}")
                        //.addHeader("User-Agent", getDeviceUserAgent(context)).build()
                chain.proceed(newRequest)
            }
        return client.build()
    }

//    @Provides
//    @Singleton
//    @AuthUrl
//    fun provideRetrofitAuth(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
//        return Retrofit.Builder().baseUrl(Constant.PROFILE_URL)
//            .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
//    }

    @Provides
    @SocialUrl
    fun provideRetrofitSocial(okHttpClient: OkHttpClient, moshi: Moshi): Retrofit {
        return Retrofit.Builder().baseUrl(Constant.SOCIAL_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi)).client(okHttpClient).build()
            //.addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
    }

}
