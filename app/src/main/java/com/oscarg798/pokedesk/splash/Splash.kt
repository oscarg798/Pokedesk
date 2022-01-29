package com.oscarg798.pokedesk.splash

import android.animation.ObjectAnimator
import android.view.View
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreenViewProvider


fun animationForSplashScreen(splashScreenView: SplashScreenViewProvider) {
        val alpha = ObjectAnimator.ofFloat(
            splashScreenView.view,
            View.ALPHA,
            1f,
            0f
        )
        alpha.duration = 500L
        alpha.doOnEnd { splashScreenView.remove() }
        alpha.start()
}