package com.geektech.boredapp3l.intro;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.geektech.boredapp3l.R;

public class IntroPageFragment extends Fragment {

    private final static String ARG_TITLE_RES_ID = "title_res";
    private final static String ARG_IMAGE_RES_ID = "image_res";

    static Fragment newInstance(IntroPageConfig config) {
        Fragment fragment = new IntroPageFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_TITLE_RES_ID, config.titleRes);
        args.putInt(ARG_IMAGE_RES_ID, config.imageRes);
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

        int imageRes = getArguments().getInt(ARG_IMAGE_RES_ID);
        int titleRes = getArguments().getInt(ARG_TITLE_RES_ID);

//        TextView titleTv = view.findViewById(R.id.intro_title);
//        ImageView imageView = view.findViewById(R.id.intro_image);
//
//        titleTv.setText(titleRes);
//        imageView.setImageResource(imageRes);
    }

}
