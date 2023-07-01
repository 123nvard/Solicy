package com.example.solicytaskproject.ui

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.solicytaskproject.R
import com.example.solicytaskproject.databinding.FragmentViewInboxBinding


class ViewInboxFragment : Fragment() {
    private lateinit var binding: FragmentViewInboxBinding
    private val args by navArgs<ViewInboxFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewInboxBinding.inflate(inflater, container, false)
        initInbox()
        initListener()
        return binding.root
    }

    private fun initListener() {
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun initInbox() {
        with(binding) {
            with(args.dataOfMessage) {
                tvSenderName.text = senderName
                tvMessageDate.text = date
                tvMessage.text = message
                tvMessage.movementMethod = ScrollingMovementMethod()
                tvMessageSubject.text = subjectOfMessage
                Glide.with(root).load(userImage).into(binding.userImage)
                if (isFavorite) {
                    favoriteButton.setImageDrawable(
                        root.resources.getDrawable(
                            R.drawable.ic_star_filled,
                            null
                        )
                    )
                } else {
                    favoriteButton.setImageDrawable(
                        root.resources.getDrawable(
                            R.drawable.ic_star,
                            null
                        )
                    )
                }
            }
        }
    }

}