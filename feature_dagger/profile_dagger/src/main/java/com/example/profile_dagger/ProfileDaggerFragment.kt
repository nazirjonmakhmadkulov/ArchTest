package com.example.profile_dagger

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.common.Constant
import com.example.common.network.Result
import com.example.model.Profile
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ProfileDaggerFragment : Fragment(R.layout.fragment_profile_dagger) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ProfileDaggerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = injectViewModel(factory = viewModelFactory)
        viewModel.getUser("956e034f-e9d6-4b57-9389-cd7c17c8fab5")
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getUser.collect { subscribeGetUserState(it) }
        }
    }

    private fun subscribeGetUserState(result: Result<Profile.Data>) {
        when (result) {
            is Result.Loading -> Result.Loading
            is Result.Success -> {
                view?.findViewById<TextView>(R.id.text)?.text = result.toString()
                Log.d(" User Remote", result.data.toString())
            }
            is Result.Error -> Log.d(
                Constant.ERROR, "${result.code.toString()}=${result.errorMessage}"
            )
        }
    }
}