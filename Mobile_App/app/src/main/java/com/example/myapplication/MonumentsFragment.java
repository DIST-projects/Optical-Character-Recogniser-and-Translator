package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MonumentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MonumentsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ViewPager2 viewPager2;
    private Handler sliderHandler = new Handler();


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MonumentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MonumentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MonumentsFragment newInstance(String param1, String param2) {
        MonumentsFragment fragment = new MonumentsFragment();
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

        View view = inflater.inflate(R.layout.fragment_monuments, container, false);
        ViewPager2 locationsViewPager =(ViewPager2) view.findViewById(R.id.locationsViewPager);

        List<TravelLocation> travelLocations = new ArrayList<>();


        TravelLocation travelLocationEiffelTower = new TravelLocation();
        //travelLocationEiffelTower.imageUrl = "https://www.infinityandroid.com/images/france_eiffel_tower.jpg";
       // travelLocationEiffelTower.imageUrl = "https://www.infinityandroid.com/wp-content/uploads/2021/05/landing_background_image-576x1024.jpg";
         travelLocationEiffelTower.imageUrl = "https://i.pinimg.com/564x/16/ba/54/16ba54e985a9cc11cf8edfe296877a0d.jpg";
        travelLocationEiffelTower.title = "Konark Temple";
        travelLocationEiffelTower.location = "Odisha, India";
        travelLocationEiffelTower.starRating = 4.8f;
        travelLocations.add(travelLocationEiffelTower);

        TravelLocation travelLocationMountainView = new TravelLocation();
        //travelLocationMountainView.imageUrl = "https://purewows3.imgix.net/images/articles/2019_04/machu_picchu.png?auto=format,compress&cs=strip";
        travelLocationMountainView.imageUrl = "https://i.pinimg.com/564x/17/8b/04/178b04a1f871d228aefdf54bdf9c8bf9.jpg";
        travelLocationMountainView.title = "Charminar";
        travelLocationMountainView.location = "Hyderabad, India";
        travelLocationMountainView.starRating = 4.5f;
        travelLocations.add(travelLocationMountainView);

        TravelLocation travelLocationTajMahal = new TravelLocation();
        travelLocationTajMahal.imageUrl = "https://www.roadaffair.com/wp-content/uploads/2017/12/taj-mahal-india-shutterstock_180918317.jpg";
        travelLocationTajMahal.title = "Taj Mahal";
        travelLocationTajMahal.location = "Agra, India";
        travelLocationTajMahal.starRating = 4.7f;
        travelLocations.add(travelLocationTajMahal);


        TravelLocation travelLocationAjanta = new TravelLocation();
        travelLocationAjanta.imageUrl = "https://i.pinimg.com/564x/1f/62/5c/1f625cad678147aceed0ea4352f09add.jpg";
        travelLocationAjanta.title = "Ellora Caves";
        travelLocationAjanta.location = "Aurangabad, India";
        travelLocationAjanta.starRating = 4.7f;
        travelLocations.add(travelLocationAjanta);

        TravelLocation travelLocationFort = new TravelLocation();
        travelLocationFort.imageUrl = "https://i.pinimg.com/564x/60/c6/8a/60c68ada54f703205a747831d30b1ad1.jpg";
        travelLocationFort.title = "Red Fort";
        travelLocationFort.location = "Delhi, India";
        travelLocationFort.starRating = 4.3f;
        travelLocations.add(travelLocationFort);

        TravelLocation travelLocationGol = new TravelLocation();
        travelLocationGol.imageUrl = "https://i.pinimg.com/564x/ec/91/ef/ec91ef3b0832f3849f760b5786146ab6.jpg";
        travelLocationGol.title = "Golconda Fort";
        travelLocationGol.location = "Hyderabad, India";
        travelLocationGol.starRating = 4.4f;
        travelLocations.add(travelLocationGol);






        locationsViewPager.setAdapter(new TravelLocationsAdapter(travelLocations));

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r*0.05f);

            }
        });
        locationsViewPager.setPageTransformer(compositePageTransformer);

        return view;
    }


}