package com.itoys.android.common.activity

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.itoys.android.common.R
import com.itoys.android.common.databinding.CommonLayoutListBinding
import com.itoys.android.common.mvi.AbsListViewModel
import com.itoys.android.common.mvi.IUIIntent
import com.itoys.android.common.mvi.IUIState
import com.itoys.android.common.mvi.ListUIIntent
import com.itoys.android.common.mvi.ListUIState
import com.itoys.android.utils.expansion.then
import kotlinx.coroutines.launch

/**
 * @Author Gu Fanfan
 * @Email fanfan.work@outlook.com
 * @Date 2023/12/8
 */
abstract class AbsMviListActivity<VM : AbsListViewModel<out IUIIntent, out IUIState>> : AbsMviActivity<CommonLayoutListBinding, VM>() {

    /**
     * 是否显示搜索组件
     */
    open val withSearchView = false

    /**
     * 开启刷新
     */
    open val enableRefresh = true

    /**
     * 开启加载更多
     */
    open val enableLoadMore = true

    /**
     * 是否显示底部按钮
     */
    open val showBottomButton = false

    override fun createViewBinding() = CommonLayoutListBinding.inflate(layoutInflater)

    override fun initialize(savedInstanceState: Bundle?) {
        binding?.titleBar?.setTitle(listTitle())
        binding?.searchLayout?.visibility = withSearchView.then(View.VISIBLE, View.GONE)
        initSearchView()

        setupList()

        if (showBottomButton) {
            binding?.bottom?.visibility = View.VISIBLE
            binding?.bottomBtn?.text = bottomButtonText()
        }
    }

    /**
     * 初始化搜索组件
     */
    private fun initSearchView() {
        val searchView = searchView() ?: return
        binding?.searchLayout?.addView(searchView)
    }

    override fun addClickListen() {
        super.addClickListen()

        binding?.page?.apply {
            // 刷新
            if (enableRefresh) {
                onRefresh { viewModel?.sendListIntent(ListUIIntent.Refresh) }.refresh()
            }

            // 加载更多
            if (enableLoadMore) {
                onLoadMore { viewModel?.sendListIntent(ListUIIntent.LoadMore) }
            }
        }
    }

    /**
     * list title
     */
    abstract fun listTitle(): String

    /**
     * bottom button text.
     */
    open fun bottomButtonText() = getString(R.string.uikit_confirm)

    /**
     * 搜索组件
     */
    open fun searchView(): View? = null

    /**
     * 设置list
     */
    abstract fun setupList()

    override fun addObserver() {
        super.addObserver()
        viewModel?.let { viewModel ->
            lifecycleScope.launch {
                viewModel.listState.collect { state ->
                    when (state) {
                        is ListUIState.LoadingComplete -> {
                            if (state.isRefresh) {
                                binding?.page?.showContent()
                            } else {
                                binding?.page?.finishLoadMore(state.isSuccessful)
                            }
                        }

                        ListUIState.NoMore -> {
                            binding?.page?.finishLoadMoreWithNoMoreData()
                        }

                        ListUIState.ShowEmpty -> binding?.page?.showEmpty()
                    }
                }
            }
        }
    }
}