package com.daniel.emoji_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.daniel.domain.entity.EmojiList
import com.daniel.emoji_list.databinding.FragmentEmojiListBinding
import extension.showToast
import extension.viewBinding

class EmojiListFragment : Fragment(R.layout.fragment_emoji_list) {

    private val emojiListBinding by viewBinding(FragmentEmojiListBinding::bind)
    private val args: EmojiListFragmentArgs by navArgs()
    private val emojiListAdapter: EmojiListAdapter by lazy {
        EmojiListAdapter(::onItemRemoved)
    }
    private companion object {
        const val GRID_COLUMN_SIZE = 4
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val emojiList = args.emojiProperties
        setupRecyclerView(emojiList)
        setupSwipeToRefresh(emojiList)
    }

    private fun setupSwipeToRefresh(emojiList: EmojiList) {
        emojiListBinding.emojiListSwipeToRefresh.setOnRefreshListener {
            context?.showToast(getString(R.string.emoji_list_swipe_to_refresh))
            emojiListAdapter.emojiList = ArrayList(emojiList.list)
            emojiListBinding.emojiListSwipeToRefresh.isRefreshing = false
        }
    }

    private fun setupRecyclerView(emojiList: EmojiList) {
        emojiListAdapter.emojiList = ArrayList(emojiList.list)
        emojiListBinding.emojiListRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager =
                GridLayoutManager(
                    context,
                    GRID_COLUMN_SIZE
                )
            adapter = emojiListAdapter
        }
    }

    private fun onItemRemoved(emojiName: String) {
        context?.showToast(String.format(getString(R.string.emoji_name_removed_message), emojiName))
    }
}
