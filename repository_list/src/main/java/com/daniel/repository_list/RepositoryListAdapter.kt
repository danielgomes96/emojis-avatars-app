package com.daniel.repository_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.daniel.domain.entity.Repository
import extension.visible

class RepositoryListAdapter :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var repositoryList = mutableListOf<Repository>()
    private var useFooter = false
    companion object {
        const val FOOTER_VIEW: Int = 1
    }

    fun submitData(repoList: List<Repository>) {
        this.repositoryList.addAll(repoList.toMutableList())
        notifyDataSetChanged()
    }

    fun updateFooter(showLoading: Boolean) {
        useFooter = showLoading
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        if (position == repositoryList.size) {
            return FOOTER_VIEW
        }
        return super.getItemViewType(position)
    }

    override fun getItemCount(): Int {
        return if (useFooter) {
            repositoryList.size + 1
        } else {
            repositoryList.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == FOOTER_VIEW) {
            FooterViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.item_footer, parent, false)
            )
        } else {
            RepositoryViewHolder(
                    LayoutInflater.from(parent.context)
                            .inflate(R.layout.item_repository_list, parent, false)
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is RepositoryViewHolder -> holder.bind(repositoryList[position])
            is FooterViewHolder -> holder.bind()
        }
    }

    class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.item_repository_list_name)
        fun bind(repository: Repository?) {
            title.text = repository?.name
        }
    }

    class FooterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val progressBar = view.findViewById<ProgressBar>(R.id.item_footer_progressbar)
        fun bind() {
            progressBar.visible()
        }
    }
}
