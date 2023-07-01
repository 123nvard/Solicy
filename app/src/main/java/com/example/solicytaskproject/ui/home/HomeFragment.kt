package com.example.solicytaskproject.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.solicytaskproject.R
import com.example.solicytaskproject.adapters.MessageAdapter
import com.example.solicytaskproject.databinding.FragmentHomeBinding
import com.example.solicytaskproject.ui.BaseFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()
    private var messageAdapter = MessageAdapter({
        val action = HomeFragmentDirections.actionNavHomeToViewInboxFragment(it)
        findNavController().navigate(action)
    }, {
        if (it.isFavorite) {
            viewModel.updateMessage(it.copy(isFavorite = false))
        } else {
            viewModel.updateMessage(it.copy(isFavorite = true))
        }
    }, {
        viewModel.updateMessage(
            it.copy(isRead = true)
        )
    })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        initListener()
        initUser()
        initSearchView()
        initAdapter()
        initViewModel()

        return binding.root
    }

    private fun initSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {

                return true
            }
        })
        with(binding.searchView) {
            setOnClickListener {
                isIconified = false
            }
        }
    }

    private fun initUser() {
        with(binding) {
            Glide.with(root)
                .load("https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Christian_Bale-7837.jpg/440px-Christian_Bale-7837.jpg")
                .into(userImage)
        }

    }

    private fun initListener() {
        with(binding) {
            composeButton.setOnClickListener {
                findNavController().navigate(R.id.action_nav_home_to_sendEmailFragment2)
            }
            menuButton.setOnClickListener {
                val fragment=parentFragmentManager.getBackStackEntryAt(0)
                val id=fragment.id
                var firstFragment=parentFragmentManager.findFragmentById(R.id.drawer_layout)
                if (firstFragment is BaseFragment){
                    firstFragment.openDrawer()
                }
            }
        }

    }

    private fun initViewModel() {
        lifecycleScope.launch {
            viewModel.listOfMessages.collectLatest {
                messageAdapter.submitList(it)
            }
        }


    }

    private fun initAdapter() {
        binding.recycleMessages.apply {
            adapter = messageAdapter
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }


}