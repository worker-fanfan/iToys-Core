package com.itoys.android.uikit.components.viewpager.transformer

import android.view.View
import android.view.ViewGroup
import androidx.core.view.children
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView
import com.itoys.android.utils.expansion.dp2px
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class HeaderFloatTransformer(
    private val orientation: Int
) : ViewPager2.PageTransformer {


    private var minPosition = 0f

    override fun transformPage(page: View, position: Float) {
        page.apply {
            val pageWidth = width
            if (minPosition > position) {
                minPosition = position
                elevation = 100f

                when (orientation) {
                    ViewPager2.ORIENTATION_VERTICAL -> {
                        translationY = pageWidth * -position
                    }
                    ViewPager2.ORIENTATION_HORIZONTAL -> {
                        translationX = pageWidth * -position
                    }
                }

                when (position) {
                    in -1f..0f -> { // (-1, 0]
                        if (page is ViewGroup) {
                            page.children.forEach { childView ->
                                if (childView is MaterialCardView) {
                                    childView.cardElevation = min(abs(position) * 10f, 10f)
                                    childView.radius =
                                        max(min(abs(position) * 100f, 100f), 8.dp2px().toFloat())

                                    childView.scaleX = max(1f + position, 0.75f)
                                    childView.scaleY = max(1f + position, 0.75f)
                                }
                                if (childView is MaterialButton) {
                                    childView.elevation = min(abs(position) * 10f, 10f)
                                    childView.cornerRadius =
                                        max(
                                            min(abs(position) * 100f, 100f),
                                            8.dp2px().toFloat()
                                        ).toInt()

                                    childView.scaleX = max(1f + position, 0.75f)
                                    childView.scaleY = max(1f + position, 0.75f)
                                }
                            }
                        }
                    }
                }

            } else if (abs(minPosition - position) < 0.9f) {
                minPosition = position
                if (position == 0f) {
                    elevation = 0f
                }

                when (position) {
                    in -1f..0f -> { // (-1, 0]
                        if (page is ViewGroup) {
                            page.children.forEach { childView ->
                                if (childView is MaterialCardView) {
                                    childView.cardElevation = min(abs(position) * 10f, 10f)
                                    childView.radius =
                                        max(min(abs(position) * 100f, 100f), 8.dp2px().toFloat())

                                    childView.scaleX = max(1f + position, 0.75f)
                                    childView.scaleY = max(1f + position, 0.75f)
                                }
                                if (childView is MaterialButton) {
                                    childView.elevation = min(abs(position) * 10f, 10f)
                                    childView.cornerRadius =
                                        max(
                                            min(abs(position) * 100f, 100f),
                                            8.dp2px().toFloat()
                                        ).toInt()

                                    childView.scaleX = max(1f + position, 0.75f)
                                    childView.scaleY = max(1f + position, 0.75f)
                                }
                            }
                        }
                    }
                }

                when (orientation) {
                    ViewPager2.ORIENTATION_VERTICAL -> {
                        translationY = pageWidth * -position
                    }
                    ViewPager2.ORIENTATION_HORIZONTAL -> {
                        translationX = pageWidth * -position
                    }
                }
            }

        }

    }

}