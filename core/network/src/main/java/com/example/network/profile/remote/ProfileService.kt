package com.example.network.profile.remote

import com.example.network.profile.model.RemoteProfile
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.security.acl.Owner

interface ProfileService {
    @GET("api/v1/user_profile/me")
    suspend fun getOwner(): Owner

    @GET("api/v1/user_profile/")
    suspend fun getUsers(@Query("offset") page: Int, @Query("limit") limit: Int): Response<RemoteProfile>

    @GET("api/v1/user_profile/me")
    suspend fun getMe(): RemoteProfile.Data

    @GET("api/v1/user_profile/{userId}")
    suspend fun getUser(@Path("userId") userId: String): RemoteProfile.Data
}