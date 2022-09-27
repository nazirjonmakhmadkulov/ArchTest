package com.example.data_dagger.di.repository

import com.example.common.dispatcher.DispatcherProvider
import com.example.common.network.Result
import com.example.data_dagger.di.model.asExternalModel
import com.example.model.Profile
import com.example.network_dagger.data_souce.ProfileRemoteDataSource
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val dispatcher: DispatcherProvider,
    private val profileRemoteDataSource: ProfileRemoteDataSource,
    //private val userDao: OwnerDao,
) : ProfileRepository {

    override suspend fun getMe(): Result<Profile.Data> {
        return when (val apiResult = profileRemoteDataSource.getMe(dispatcher.io)) {
            is Result.Loading -> Result.Loading
            is Result.Success -> {
               // userDao.insertUser(apiResult.data.asEntity())
                Result.Success(apiResult.data.asExternalModel())
            }
            is Result.Error -> Result.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
        }
    }

    override suspend fun getUser(userId: String): Result<Profile.Data> {
        return when (val apiResult = profileRemoteDataSource.getUser(dispatcher.io, userId)) {
            is Result.Loading -> Result.Loading
            is Result.Success -> {
              //  userDao.insertUser(apiResult.data.asEntity())
                Result.Success(apiResult.data.asExternalModel())
            }
            is Result.Error -> Result.Error(apiResult.cause, apiResult.code, apiResult.errorMessage)
        }
    }

//    override fun getLocalOwner(id: String): Flow<Profile.Data?> {
//        return userDao.getUserById(id).map { it?.asExternalModel() }
//    }
}