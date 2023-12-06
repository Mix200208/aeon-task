package com.aeon.aeonpayment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.aeon.aeonpayment.R
import com.aeon.aeonpayment.api.ServerService
import com.aeon.aeonpayment.databinding.FragmentLoginBinding
import com.aeon.aeonpayment.viewmodels.LoginViewModelImpl
import com.aeon.aeonpayment.viewmodels.factory.LoginViewModelFactory
import kotlin.properties.Delegates

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private var status = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel?.statusLogin!!.observe( viewLifecycleOwner, Observer {
            status = it
        })

        binding.logInButton.apply {
            setOnClickListener {
                binding.viewModel?.registerUser(binding.editTextLogin.toString(), binding.editTextPassword.toString())
                if (status) {
                    Toast.makeText(this@LoginFragment.context, "Log in success", Toast.LENGTH_LONG).show()
                    Navigation.findNavController(it).navigate(R.id.profileFragment)
                } else {
                    Toast.makeText(this@LoginFragment.context, "Log in failed", Toast.LENGTH_LONG).show()
                    Navigation.findNavController(it).navigate(R.id.profileFragment)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login,null,false)
        binding.viewModel = ViewModelProvider(this, LoginViewModelFactory()).get(LoginViewModelImpl::class.java)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}