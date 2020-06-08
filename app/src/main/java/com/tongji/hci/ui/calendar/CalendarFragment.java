package com.tongji.hci.ui.calendar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.tongji.hci.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalendarFragment extends Fragment {

    private CalendarViewModel calendarViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calendarViewModel =
                ViewModelProviders.of(this).get(CalendarViewModel.class);
        View root = inflater.inflate(R.layout.fragment_calendar, container, false);
        //新增按钮
        FloatingActionButton fab = root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_task);
            }
        });
        ViewPager2 viewPager2=root.findViewById(R.id.view_page_date);
        final List<String> mMonth=new ArrayList<>();
        final TextView header=root.findViewById(R.id.text_month);
        mMonth.add("五月");
        mMonth.add("六月");
        mMonth.add("七月");
        viewPager2.setAdapter(new DateViewAdapter(getContext(),mMonth));
        viewPager2.setCurrentItem(1,false);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                header.setText(mMonth.get(position));
            }
        });
        return root;
    }
}
