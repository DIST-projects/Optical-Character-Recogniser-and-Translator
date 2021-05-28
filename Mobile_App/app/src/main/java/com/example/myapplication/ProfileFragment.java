package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView logo, appName,splashImg;
    LottieAnimationView lottieAnimationView;

    private static final int NUM_PAGES=3;
    private ViewPager viewPager;
    private ScreenSliderPagerAdapter pagerAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public ProfileFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_profile, container, false);



        viewPager = view.findViewById(R.id.pager);
        pagerAdapter = new ScreenSliderPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);


       return view;
    }

    private class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSliderPagerAdapter(FragmentManager fm){
            super(fm
            );
        }


        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position){
                case 0:
                    ProfileFragment1 tab1 = new ProfileFragment1();

                    return tab1;
                case 1:
                    ProfileFragment2 tab2 = new ProfileFragment2();
                    return tab2;
                case 2:
                    ProfileFragment3 tab3 = new ProfileFragment3();
                    return tab3;


            }
            return  null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }



    }
