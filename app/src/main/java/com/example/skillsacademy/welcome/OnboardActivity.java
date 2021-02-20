package com.example.skillsacademy.welcome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.skillsacademy.MainActivity;
import com.example.skillsacademy.R;
import com.example.skillsacademy.databinding.ActivityOnboardBinding;
import com.example.skillsacademy.register.RegisterActivity;
import com.example.skillsacademy.utilities.Utils;
import com.example.skillsacademy.welcome.adapter.IntroviewAdapter;
import com.example.skillsacademy.welcome.transformers.AntiClockSpinTransformation;
import com.example.skillsacademy.welcome.transformers.CubeInDepthTransformation;
import com.example.skillsacademy.welcome.transformers.DepthPageTransformer;
import com.example.skillsacademy.welcome.transformers.FanTransformation;
import com.example.skillsacademy.welcome.transformers.HingeTransformation;
import com.example.skillsacademy.welcome.transformers.HorizontalFlipTransformation;
import com.example.skillsacademy.welcome.transformers.SpinnerTransformation;
import com.example.skillsacademy.welcome.transformers.TossTransformation;
import com.google.android.gms.common.data.DataBufferUtils;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class OnboardActivity extends AppCompatActivity {
 public ViewPager viewPager;
 public IntroviewAdapter introviewAdapter;
 public TabLayout tabIndicator;
    private TextView[] dots;
 public Button button,button_getStarted;
 public MyViewPagerAdapter mAdapter;
    public Animation topAnim,bottomAnim;
 public ActivityOnboardBinding binding;
    public ImageView imageView;
    private int[] layouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_onboard);

        init();


    }

    private void init(){
        layouts = new int[]{
                R.layout.welcome_slide2,
                R.layout.welcome_slide3,
                R.layout.welcome_slide1,
               };

        topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        mAdapter = new MyViewPagerAdapter();
        binding.viewPager.setAdapter(mAdapter);
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback);

        binding.btnSkip.setOnClickListener(v -> launchHomeScreen());

        binding.btnNext.setOnClickListener(v -> {
            // checking for last page
            // if last page home screen will be launched
            int current = getItem(+1);
            if (current < layouts.length) {
                // move to next screen
                binding.viewPager.setCurrentItem(current);
            } else {
                launchHomeScreen();
            }
        });

//        binding.iconMore.setOnClickListener(view -> {
//            showMenu(view);
//        });

        // adding bottom dots
        addBottomDots(0);

        AntiClockSpinTransformation antiClockSpinTransformation=new AntiClockSpinTransformation();

        DepthPageTransformer depthPageTransformer=new DepthPageTransformer();


        CubeInDepthTransformation cubeInDepthTransformation=new CubeInDepthTransformation();

        HingeTransformation hingeTransformation=new HingeTransformation();

        HorizontalFlipTransformation horizontalFlipTransformation=new HorizontalFlipTransformation();

        SpinnerTransformation spinnerTransformation=new SpinnerTransformation();

        TossTransformation tossTransformation=new TossTransformation();

        FanTransformation fanTransformation=new FanTransformation();
        binding.viewPager.setAnimation(topAnim);
        binding.viewPager.setPageTransformer(fanTransformation);

    }

    private int getItem(int i) {
        return binding.viewPager.getCurrentItem() + i;
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        binding.layoutDots.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(colorsInactive[currentPage]);
            binding.layoutDots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private void showMenu(View view) {
        PopupMenu popup = new PopupMenu(this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu, popup.getMenu());
        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_orientation) {
                binding.viewPager.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
            } else {
                binding.viewPager.setPageTransformer(Utils.getTransformer(item.getItemId()));
                binding.viewPager.setCurrentItem(0);
                binding.viewPager.getAdapter().notifyDataSetChanged();
            }
            return false;
        });
        popup.show();
    }


    private void launchHomeScreen() {
        //Toast.makeText(this, R.string.slides_ended, Toast.LENGTH_LONG).show();
        Intent intent=new Intent(OnboardActivity.this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }

    ViewPager2.OnPageChangeCallback pageChangeCallback = new ViewPager2.OnPageChangeCallback() {
        @Override
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            addBottomDots(position);

            // changing the next button text 'NEXT' / 'GOT IT'
            if (position == layouts.length - 1) {
                // last page. make button text to GOT IT
                binding.btnNext.setText(getString(R.string.start));
                binding.btnSkip.setVisibility(View.GONE);
            } else {
                // still pages are left
                binding.btnNext.setText(getString(R.string.next));
                binding.btnSkip.setVisibility(View.VISIBLE);
            }
        }
    };

    public class MyViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        public MyViewPagerAdapter() {
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(viewType, parent, false);
            return new SliderViewHolder(view);
        }

        @Override
        public int getItemViewType(int position) {
            return layouts[position];
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        }

        @Override
        public int getItemCount() {
            return layouts.length;
        }

        private class SliderViewHolder extends RecyclerView.ViewHolder {

            public ImageView imageView;
            public TextView title, year, genre;
            public SliderViewHolder(View view) {
                super(view);
            }
        }
    }


}