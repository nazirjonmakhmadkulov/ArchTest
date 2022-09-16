package com.example.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.common.Constant.ERROR
import com.example.common.network.Result
import com.example.model.Profile
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileFragment : Fragment() {
    private val viewModel by viewModels<ProfileViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser("956e034f-e9d6-4b57-9389-cd7c17c8fab5")
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getUser.collect { subscribeGetUserState(it) }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getLocalOwner("956e034f-e9d6-4b57-9389-cd7c17c8fab5")
                .collect { subscribeGetUserState(it) }
        }
    }

    private fun subscribeGetUserState(result: Result<Profile.Data>) {
        when (result) {
            is Result.Loading -> Result.Loading
            is Result.Success -> Log.d(" User Remote", result.data.toString())
            is Result.Error -> Log.d(ERROR, "${result.code.toString()}=${result.errorMessage}")
        }
    }

    private fun subscribeGetUserState(data: Profile.Data?) {
        data?.let {
            Log.d("User  Local", it.toString())
            view?.findViewById<TextView>(R.id.text)?.text = data.toString()
        }
    }
}