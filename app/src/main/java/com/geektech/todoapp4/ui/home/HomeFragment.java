package com.geektech.todoapp4.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.geektech.todoapp4.Model.Task;
import com.geektech.todoapp4.R;
import com.geektech.todoapp4.App;
import com.geektech.todoapp4.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment implements HomeAdapter.LongTouch {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private NavController controller;
    private HomeAdapter adapter = new HomeAdapter(this::click);

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        controller = Navigation.findNavController(container);

        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListener();
        initRv();
    }

    private void initRv() {
        binding.rvNote.setAdapter(adapter);
//       requireActivity().getSupportFragmentManager().setFragmentResultListener("title",
//               getViewLifecycleOwner(), (requestKey, result) -> {
//                   if (requestKey.equals("title")) {
//                       String title = result.getString("title");
//                       adapter.save(title);
//                   }
//               });

        adapter.save(App.dataBase.roomDao().gelAll());

    }

    private void initListener() {
        binding.btnAddNote.setOnClickListener(v -> {
            controller.navigate(R.id.formFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void click(Task task) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        builder.setTitle("Вы точно хотите удалить?")
                .setNegativeButton("нет", null)
                .setPositiveButton("да", (dialog, which) -> {
                    App.dataBase.roomDao().delete(task);
                    initRv();
                }).show();
    }
}