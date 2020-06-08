package com.tongji.hci.ui.task;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.tongji.hci.R;

public class TaskFragment extends Fragment {

    private TaskViewModel taskViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        taskViewModel =
                ViewModelProviders.of(this).get(TaskViewModel.class);
        View root = inflater.inflate(R.layout.fragment_task, container, false);
//        final TextView textView = root.findViewById(R.id.text_task);
//        taskViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        Bundle arguments = getArguments();
        if(arguments!=null){
            Button button = root.findViewById(R.id.delete_button);
            button.setVisibility(View.VISIBLE);
            TextView title=root.findViewById(R.id.form_title);
            title.setText("人机交互项目");
            TextView start=root.findViewById(R.id.form_start_date);
            start.setText("2020-06-03");
            TextView end=root.findViewById(R.id.form_end_date);
            end.setText("2020-06-06");
            TextView desc=root.findViewById(R.id.form_desc);
            desc.setText("人机交互的课程项目");
        }
        return root;
    }
}
