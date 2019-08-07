package com.geektech.boredapp3l.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import com.geektech.boredapp3l.R;

public class IntroPageFragment extends Fragment {

    private final static String ARG_TITLE_RES_ID = "title_res";

    public static Fragment newInstance(
            @StringRes int titleRes
    ) {
        Fragment fragment = new IntroPageFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_TITLE_RES_ID, titleRes);
        fragment.setArguments(args);

        return fragment;
    }

    public IntroPageFragment() { }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_intro_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

}
