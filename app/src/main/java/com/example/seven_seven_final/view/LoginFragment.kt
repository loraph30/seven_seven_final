package com.example.seven_seven_final.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.seven_seven_final.R
import com.example.seven_seven_final.viewModel.ViewModel
import androidx.fragment.app.activityViewModels
import com.example.seven_seven_final.databinding.LoginFragmentBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: LoginFragmentBinding? = null
    private val viewModel:ViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val currentUserNameEditText = view.findViewById<EditText>(R.id.user_name)
        val currentUserNameText = currentUserNameEditText.text
        val currentPasswordEditText = view.findViewById<EditText>(R.id.user_name)
        val currentPasswordText = currentPasswordEditText.text
        val incorrectMessage = view.findViewById<TextView>(R.id.incorrect_message)

        // login button
        binding.buttonLogin.setOnClickListener {
            viewModel.postUserName(currentUserNameText.toString())
            viewModel.postUserPassword(currentPasswordText.toString())
            if(viewModel.getUserName() == (viewModel.getCurrentUserName()) && viewModel.getPassword() == viewModel.getCurrentPassword()) {
                findNavController().navigate(R.id.action_LoginFragment_to_WelcomeFragment)
            } else {
                incorrectMessage.setVisibility(View.VISIBLE)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}