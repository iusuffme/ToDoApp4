package com.geektech.todoapp4.ui.onBoard;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import com.geektech.todoapp4.R;
import com.geektech.todoapp4.databinding.FragmentBoardBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class BoardFragment extends Fragment {
    private FragmentBoardBinding binding;
    private BoardAdapter adapter;
    private NavController controller;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        controller = Navigation.findNavController(container);
        binding = FragmentBoardBinding.inflate(inflater);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        requireActivity().finish();
                    }
                });
        new TabLayoutMediator(binding.tabLayout, binding.boardPager, ((tab, position) ->
                tab.setIcon(R.drawable.tab_selected))).attach();
    }

    private void initListener() {
        adapter = new BoardAdapter();
        binding.boardPager.setAdapter(adapter);

        adapter.clickable = () -> {
            controller.navigateUp();
        };
    }
}