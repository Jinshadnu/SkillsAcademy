package com.example.skillsacademy.home.navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.FragmentHomeBinding;
import com.example.skillsacademy.home.adapter.CategoriesAdapater;
import com.example.skillsacademy.home.adapter.DevelopmentAdapter;
import com.example.skillsacademy.home.adapter.FeaturedAdapter;
import com.example.skillsacademy.home.adapter.ImageSliderAdapter;
import com.example.skillsacademy.home.pojo.Categories;
import com.example.skillsacademy.home.pojo.Devolopment;
import com.example.skillsacademy.home.pojo.Featured;
import com.example.skillsacademy.home.viewmodel.CategoryViewModel;
import com.example.skillsacademy.home.viewmodel.DevelopmentViewModel;
import com.example.skillsacademy.home.viewmodel.FeaturedViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
public FragmentHomeBinding fragmentHomeBinding;
public FeaturedAdapter featuredAdapter;
public FeaturedViewModel featuredViewModel;
public CategoryViewModel categoryViewModel;
public CategoriesAdapater categoriesAdapater;
public DevelopmentViewModel developmentViewModel;
public DevelopmentAdapter developmentAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        featuredViewModel= ViewModelProviders.of((FragmentActivity)this.getActivity()).get(FeaturedViewModel.class);
        categoryViewModel=ViewModelProviders.of((FragmentActivity)this.getActivity()).get(CategoryViewModel.class);
        developmentViewModel=ViewModelProviders.of((FragmentActivity)this.getActivity()).get(DevelopmentViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        fragmentHomeBinding.layoutBase.toolbar.setTitle("Home");

        fragmentHomeBinding.recyclerFeatured.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        fragmentHomeBinding.recyclerFeatured.setHasFixedSize(true);

        fragmentHomeBinding.recyclerCategories.setLayoutManager(new GridLayoutManager(getActivity(),3));
        fragmentHomeBinding.recyclerCategories.setHasFixedSize(true);

        fragmentHomeBinding.recyclerDevelopement.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL,false));
        fragmentHomeBinding.recyclerDevelopement.setHasFixedSize(true);

        setValuesToFields();

        getFeaturedVideos();

        fetchCategories();

        fetchCourses();

        return fragmentHomeBinding.getRoot();
    }

    private void fetchCourses() {
        developmentViewModel.getCourse().observe((LifecycleOwner) this.getActivity(), new Observer<List<Devolopment>>() {
            @Override
            public void onChanged(List<Devolopment> devolopments) {
                developmentAdapter=new DevelopmentAdapter(getActivity(),devolopments);
                fragmentHomeBinding.recyclerDevelopement.setAdapter(developmentAdapter);
            }
        });
    }

    private void setValuesToFields() {
        //banner image
        List<String> bannerList = new ArrayList<>();
        bannerList.add("1");
        bannerList.add("2");
        bannerList.add("3");
        fragmentHomeBinding.rlBanner.setVisibility(View.VISIBLE);
        fragmentHomeBinding.vpImage.setAdapter(new ImageSliderAdapter(getActivity(), bannerList));

        fragmentHomeBinding.cpImage.setViewPager(fragmentHomeBinding.vpImage);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        fragmentHomeBinding.cpImage.setRadius(5 * density);

        fragmentHomeBinding.vpImage.startAutoScroll();
        fragmentHomeBinding.vpImage.setInterval(5000);
        fragmentHomeBinding.vpImage.setCycle(true);
        fragmentHomeBinding.vpImage.setStopScrollWhenTouch(true);

        // Pager listener over indicator
        fragmentHomeBinding.cpImage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }
    public void getFeaturedVideos(){
     featuredViewModel.getFeaturedVideos().observe((LifecycleOwner) this.getActivity(), new Observer<List<Featured>>() {
         @Override
         public void onChanged(List<Featured> featureds) {
         featuredAdapter=new FeaturedAdapter(getActivity(),featureds);
         fragmentHomeBinding.recyclerFeatured.setAdapter(featuredAdapter);
         }
     });
    }

    private void fetchCategories() {
        categoryViewModel.getCatrgories().observe((LifecycleOwner) this, new Observer<List<Categories>>() {
            @Override
            public void onChanged(List<Categories> categoriesList) {
                categoriesAdapater=new CategoriesAdapater(getActivity(),categoriesList);
                fragmentHomeBinding.recyclerCategories.setAdapter(categoriesAdapater);

            }
        });
    }
}