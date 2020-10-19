package com.example.skillsacademy.welcome.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.skillsacademy.R;
import com.example.skillsacademy.welcome.ScreenItems;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class IntroviewAdapter extends PagerAdapter {
    public Context context;
    public List<ScreenItems> screenItems;

    public IntroviewAdapter(Context context, List<ScreenItems> screenItems) {
        this.context = context;
        this.screenItems = screenItems;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.screen_layout,null);
        ImageView imageView=view.findViewById(R.id.imageView);
        TextView title=view.findViewById(R.id.textView_title);
        TextView desc=view.findViewById(R.id.textView_description);

        title.setText(screenItems.get(position).getTitle());
        desc.setText(screenItems.get(position).getDescription());
        imageView.setImageResource(screenItems.get(position).getImage());

        container.addView(view);
        return view;

    }

    @Override
    public int getCount() {
        return screenItems.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);
    }
}
