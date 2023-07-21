package com.example.solicytaskproject.ui.sendEmail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.solicytaskproject.databinding.FragmentSendEmailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class SendEmailFragment : Fragment() {
    private lateinit var binding: FragmentSendEmailBinding
    private val viewModel by viewModel<SendEmailViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSendEmailBinding.inflate(inflater, container, false)
        initListener()
        return binding.root
    }

    private fun initListener() {
        with(binding) {
            imBack.setOnClickListener {
                findNavController().navigateUp()
            }
      imSend.setOnClickListener {
              viewModel.sendEmail(
                  tvFromText.text.toString(),
                  tvToText.text.toString(),
                  tvThemeText.text.toString(),
                  etMessageText.text.toString()
              )
         }
         viewModel.successLiveData.observe(viewLifecycleOwner) {
             Toast.makeText(requireContext(), "Message was sent", Toast.LENGTH_LONG).show()
             findNavController().navigateUp()
         }
        }
    }
}