package com.example.seven_seven_final.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.seven_seven_final.R
import com.example.seven_seven_final.databinding.WelcomeFragmentBinding
import com.example.seven_seven_final.viewModel.ViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class WelcomeFragment : Fragment() {

    private var _binding: WelcomeFragmentBinding? = null
    private val viewModel: ViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = WelcomeFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.buttonSignOut.setOnClickListener {
            viewModel.postUserName("")
            viewModel.postUserPassword("")

            findNavController().navigate(R.id.action_WelcomeFragment_to_LoginFragment)

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}