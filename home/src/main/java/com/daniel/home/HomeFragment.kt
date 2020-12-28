package com.daniel.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.daniel.data.di.networkModule
import com.daniel.data.di.repositoryModule
import com.daniel.domain.entity.ViewState
import com.daniel.home.di.homeModule
import com.daniel.home.databinding.FragmentHomeBinding
import extension.gone
import extension.showToast
import extension.viewBinding
import extension.visible
import extension.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val homeBinding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel by viewModel<HomeViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        loadKoinModules(listOf(homeModule, repositoryModule, networkModule))
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.emojiListLiveData.observe(viewLifecycleOwner, Observer { viewState ->
            when (viewState) {
                is ViewState.Loading -> { showLoading() }
                is ViewState.Success -> {
                    dismissLoading()
                    updateGetEmojiButtonText()
                }
                is ViewState.Error -> {
                    dismissLoading()
                    showErrorMessage()
                }
            }
        })
    }

    private fun showErrorMessage() {
        context?.showToast(getString(R.string.error_message_get_emoji))
    }

    private fun showLoading() {
        homeBinding.fragmentHomeProgressBar.visible()
        homeBinding.fragmentHomeBtnGetEmoji.gone()
    }

    private fun dismissLoading() {
        homeBinding.fragmentHomeProgressBar.gone()
        homeBinding.fragmentHomeBtnGetEmoji.visible()
    }

    private fun updateGetEmojiButtonText() {
        homeBinding.fragmentHomeBtnGetEmoji.text = getString(R.string.button_random_emoji)
        homeBinding.fragmentHomeBtnGetEmoji.setOnClickListener {
            // TODO: Get a random emoji from local database
        }
    }

    private fun setupView() = with(homeBinding) {
        fragmentHomeBtnGetEmoji.setOnClickListener {
            viewModel.getEmojiList()
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
        unloadKoinModules(listOf(homeModule, networkModule))
    }
}
