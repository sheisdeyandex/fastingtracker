package com.fasting.tracker.usecases

import android.content.Context
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import com.fasting.tracker.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@Module
@InstallIn (FragmentComponent::class)
class PlanColor @Inject constructor() {
    @Provides
    fun forBeginners(@ApplicationContext context:Context):GradientDrawable{
        val drawable = GradientDrawable().apply {
            colors = intArrayOf(
                ContextCompat.getColor(context,R.color.forBeginnersStart),
                ContextCompat.getColor(context,R.color.forBeginnersEnd)
            )

            orientation = GradientDrawable.Orientation.LEFT_RIGHT
            gradientType = GradientDrawable.LINEAR_GRADIENT
            shape = GradientDrawable.RECTANGLE
        }
        return drawable

    }
    @Provides
    fun forExperienced(@ApplicationContext context:Context):GradientDrawable{
        val drawable = GradientDrawable().apply {
            colors = intArrayOf(
                ContextCompat.getColor(context,R.color.forExperiencedStart),
                ContextCompat.getColor(context,R.color.forExperiencedEnd))

            orientation = GradientDrawable.Orientation.LEFT_RIGHT
            gradientType = GradientDrawable.LINEAR_GRADIENT
            shape = GradientDrawable.RECTANGLE
        }
        return drawable

    }
    @Provides
    fun forExpert(@ApplicationContext context:Context):GradientDrawable{
        val drawable = GradientDrawable().apply {
            colors = intArrayOf(
                ContextCompat.getColor(context,R.color.forExpertStart),
                ContextCompat.getColor(context,R.color.forExpertEnd)
            )

            orientation = GradientDrawable.Orientation.LEFT_RIGHT
            gradientType = GradientDrawable.LINEAR_GRADIENT
            shape = GradientDrawable.RECTANGLE
        }
        return drawable

    }
    @Provides
    fun ownPlan(@ApplicationContext context:Context):GradientDrawable{
        val drawable = GradientDrawable().apply {
            colors = intArrayOf(
                ContextCompat.getColor(context,R.color.ownPlanStart),
                ContextCompat.getColor(context,R.color.ownPlanStart)
            )

            orientation = GradientDrawable.Orientation.LEFT_RIGHT
            gradientType = GradientDrawable.LINEAR_GRADIENT
            shape = GradientDrawable.RECTANGLE
        }
        return drawable

    }
}