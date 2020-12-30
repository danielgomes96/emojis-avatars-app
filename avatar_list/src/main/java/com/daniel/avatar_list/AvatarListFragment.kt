package com.daniel.avatar_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.daniel.avatar_list.databinding.FragmentAvatarListBinding
import com.daniel.avatar_list.di.avatarListModule
import com.daniel.domain.entity.User
import com.daniel.domain.entity.ViewState
import extension.showToast
import extension.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class AvatarListFragment : Fragment(R.layout.fragment_avatar_list) {

    private val fragmentAvatarListBinding by viewBinding(FragmentAvatarListBinding::bind)
    private val viewModel by viewModel<AvatarListViewModel>()
    private val avatarListAdapter: AvatarListAdapter by lazy {
        AvatarListAdapter(::onItemRemoved)
    }

    companion object {
        const val GRID_COLUMN_SIZE = 4
    }

    private fun onItemRemoved(user: User) {
        context?.showToast(String.format(getString(R.string.user_avatar_deleted_message), user.name))
        viewModel.removeUser(user)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadKoinModules(avatarListModule)
        setupObservers()
        fragmentAvatarListBinding.avatarListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(
                    context,
                    GRID_COLUMN_SIZE
                )
            adapter = avatarListAdapter
        }
    }

    private fun setupObservers() {
        viewModel.usersAvatarListLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is ViewState.Success -> {
                    avatarListAdapter.avatarList = ArrayList(it.data)
                }
                is ViewState.Error -> {
                    // TODO: Handle error
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        unloadKoinModules(avatarListModule)
    }
}
