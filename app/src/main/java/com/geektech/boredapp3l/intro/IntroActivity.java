package com.geektech.boredapp3l.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.geektech.boredapp3l.MainActivity;
import com.geektech.boredapp3l.R;

public class IntroActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private IntroPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        MainActivity.start(this);

        new IntroPageAdapter(
                getSupportFragmentManager(),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp)
        );
    }

    private void onNextClick() {
        // 3 - 1 >= 2
        if (adapter.getCount() - 1 >= viewPager.getCurrentItem()) {
            // Finish
            // Start MainActivity
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public class IntroPageAdapter extends FragmentPagerAdapter {

        private IntroPageConfig[] configs;

        IntroPageAdapter(
                FragmentManager fm,
                IntroPageConfig... configs
        ) {
            super(fm);
            this.configs = configs;
        }

        @Override
        public Fragment getItem(int position) {
            return IntroPageFragment.newInstance(configs[position]);
        }

        @Override
        public int getCount() {
            return configs.length;
        }
    }
}
