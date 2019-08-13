package com.geektech.boredapp3l.intro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

import com.geektech.boredapp3l.MainActivity;
import com.geektech.boredapp3l.R;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        MainActivity.start(this);

        new IntroPageAdapter(
                getSupportFragmentManager(),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp),
                new IntroPageConfig(R.string.intro_first_page, R.drawable.ic_android_black_24dp)
        );
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
