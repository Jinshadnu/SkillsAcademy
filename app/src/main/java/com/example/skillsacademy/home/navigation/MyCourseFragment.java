package com.example.skillsacademy.home.navigation;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.FragmentMyCourseBinding;
import com.example.skillsacademy.home.adapter.MyCourseAdapter;
import com.example.skillsacademy.home.pojo.MyCourse;
import com.example.skillsacademy.home.viewmodel.MyCourseViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyCourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyCourseFragment extends Fragment {
 public FragmentMyCourseBinding myCourseBinding;
 public MyCourseViewModel courseViewModel;
 public MyCourseAdapter courseAdapter;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MyCourseFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static MyCourseFragment newInstance(String param1, String param2) {
        MyCourseFragment fragment = new MyCourseFragment();
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
        courseViewModel= ViewModelProviders.of((FragmentActivity)this.getActivity()).get(MyCourseViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myCourseBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_my_course,container,false);
        myCourseBinding.recyclerMycourse.setLayoutManager(new LinearLayoutManager(getActivity()));
        myCourseBinding.recyclerMycourse.setHasFixedSize(true);

        myCourseBinding.layoutBase.toolbar.setTitle("My Courses");

        myCourseBinding.layoutBase.toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);

        myCourseBinding.layoutBase.toolbar.setNavigationOnClickListener(v -> {
            getActivity().onBackPressed();
        });


        getCourse();

        return myCourseBinding.getRoot();
    }

    public void getCourse(){
        courseViewModel.getCourse().observe((LifecycleOwner) this.getActivity(), new Observer<List<MyCourse>>() {
            @Override
            public void onChanged(List<MyCourse> myCourses) {
                courseAdapter=new MyCourseAdapter(getActivity(),myCourses);
                myCourseBinding.recyclerMycourse.setAdapter(courseAdapter);
            }
        });
    }


}