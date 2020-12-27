package com.daniel.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.daniel.home.databinding.FragmentHomeBinding
import com.daniel.home.di.homeModule
import extension.findNavController
import extension.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeBinding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        loadKoinModules(homeModule)
    }

    private fun setupView() = with(homeBinding) {
        fragmentHomeBtnGetEmoji.setOnClickListener {
            // TODO: Request Get Emojis from Github API
        }
        fragmentHomeBtnSearch.setOnClickListener {
            // TODO: Request username from Github API
        }
        fragmentHomeBtnEmojiList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_featureEmojiListNavGraph)
        }
        fragmentHomeBtnGoogleRepos.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_featureRepositoryListNavGraph)
        }
        fragmentHomeBtnAvatarList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_featureAvatarListNavGraph)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unloadKoinModules(homeModule)
    }
}
