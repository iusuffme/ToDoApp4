package com.geektech.todoapp4.ui.formFragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.todoapp4.Model.Task;
import com.geektech.todoapp4.App;
import com.geektech.todoapp4.databinding.FragmentFormBinding;

public class FormFragment extends Fragment {
    private FragmentFormBinding binding;
    private NavController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        controller = Navigation.findNavController(container);
        binding = FragmentFormBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
    }

    private void initListener() {
        binding.btnSave.setOnClickListener(v -> {
            String title = binding.etTitle.getText().toString();
            Task task = new Task(title);
            App.dataBase.roomDao().addList(task);
//            Bundle bundle = new Bundle();
//            bundle.putString("title", title);
//            requireActivity().getSupportFragmentManager().setFragmentResult("title", bundle);
            controller.navigateUp();
        });
    }
}