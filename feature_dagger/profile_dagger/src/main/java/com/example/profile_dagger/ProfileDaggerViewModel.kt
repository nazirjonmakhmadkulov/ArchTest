package com.example.profile_dagger

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.network.Result
import com.example.data_dagger.di.usecases.ProfileUseCase
import com.example.model.Profile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProfileDaggerViewModel @Inject constructor(private val profileUseCase: ProfileUseCase) :
    ViewModel() {
    private val _getUser = MutableStateFlow<Result<Profile.Data>>(Result.Loading)
    val getUser: StateFlow<Result<Profile.Data>> get() = _getUser.asStateFlow()
    fun getUser(userId: String) = viewModelScope.launch {
        when (val result = profileUseCase.invokeGetUser(userId)) {
            is Result.Loading -> Result.Loading
            is Result.Success -> _getUser.value = Result.Success(result.data)
            is Result.Error -> _getUser.value =
                Result.Error(result.cause, result.code, result.errorMessage)
        }
    }
}