package com.insightvalley.samsungapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter{

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    public int[] slide_icons = {
            R.drawable.tutor_first,
            R.drawable.tutor2,
            R.drawable.tutor3,
            R.drawable.tutor4
    };

    public String[] slide_headers = {
            "tutor 1",
            "tutor 2",
            "tutor 3",
            "tutor 4"
    };

    public String[] slide_descs = {
            "lorem 1 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec dolor sem, vulputate eget fermentum sed, gravida id ipsum. Curabitur pharetra erat convallis tincidunt faucibus. Pellentesque mattis condimentum velit, nec ultricies urna tristique non. Duis consectetur laoreet sagittis.",
            "lorem 2 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec dolor sem, vulputate eget fermentum sed, gravida id ipsum. Curabitur pharetra erat convallis tincidunt faucibus. Pellentesque mattis condimentum velit, nec ultricies urna tristique non. Duis consectetur laoreet sagittis.",
            "lorem 3 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec dolor sem, vulputate eget fermentum sed, gravida id ipsum. Curabitur pharetra erat convallis tincidunt faucibus. Pellentesque mattis condimentum velit, nec ultricies urna tristique non. Duis consectetur laoreet sagittis.",
            "lorem 4 Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec dolor sem, vulputate eget fermentum sed, gravida id ipsum. Curabitur pharetra erat convallis tincidunt faucibus. Pellentesque mattis condimentum velit, nec ultricies urna tristique non. Duis consectetur laoreet sagittis."
    };

    @Override
    public int getCount() {
        return slide_headers.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);


        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeader = (TextView) view.findViewById(R.id.slide_header);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_icons[position]);
        slideHeader.setText(slide_headers[position]);
        slideDescription.setText(slide_descs[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
