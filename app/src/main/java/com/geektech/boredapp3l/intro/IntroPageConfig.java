package com.geektech.boredapp3l.intro;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;

class IntroPageConfig {
    @StringRes
    int titleRes;

    @DrawableRes
    int imageRes;

    IntroPageConfig(int titleRes, int imageRes) {
        this.titleRes = titleRes;
        this.imageRes = imageRes;
    }
}
