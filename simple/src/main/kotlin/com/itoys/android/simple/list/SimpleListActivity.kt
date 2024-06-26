package com.itoys.android.simple.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import com.itoys.android.core.activity.AbsMviListActivity
import com.itoys.android.core.mvi.ListUIIntent
import com.itoys.android.databinding.SimpleLayoutFotterButtonBinding
import com.itoys.android.databinding.SimpleLayoutHeaderTotalCountBinding
import com.itoys.android.databinding.SimpleLayoutSearchBinding
import com.itoys.android.uikit.components.input.SearchView
import com.itoys.android.uikit.magicIndicator
import dagger.hilt.android.AndroidEntryPoint

/**
 * @Author Gu Fanfan
 * @Email fanfan.worker@gmail.com
 * @Date 2024/4/6
 */
@AndroidEntryPoint
class SimpleListActivity : AbsMviListActivity<SimpleListViewModel>() {

    override val viewModel: SimpleListViewModel? by viewModels()

    override fun listTitle() = "Simple List"

    override fun setupList() {
    }

    override fun headerView(parent: ViewGroup): View {
        val headerView = SimpleLayoutHeaderTotalCountBinding.inflate(
            LayoutInflater.from(this@SimpleListActivity),
            parent,
            false
        )

        headerView.totalCount.text = "共100条"

        headerView.indicator.magicIndicator(listOf("TAB1", "TAB2", "TAB3"))
        return headerView.root
    }

    override fun footerView(parent: ViewGroup): View {
        val footerView = SimpleLayoutFotterButtonBinding.inflate(
            LayoutInflater.from(this@SimpleListActivity),
            parent,
            false
        )

        footerView.button.text = "确认"
        return footerView.root
    }
}