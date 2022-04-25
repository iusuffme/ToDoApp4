package com.geektech.todoapp4.ui.onBoard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.todoapp4.R;
import com.geektech.todoapp4.databinding.PagerBoardBinding;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {
    private PagerBoardBinding binding;
    private String[] title = {"1", "2", "3"};
    private int[] image = {R.drawable.ic_baseline_add, R.drawable.ic_dashboard_black_24dp, R.drawable.ic_launcher_background};
    protected Clickable clickable;
    @NonNull
    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = PagerBoardBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new BoardViewHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(@NonNull BoardViewHolder holder, int position) {
        holder.onBoard(position);
        binding.btnPagerNext.setOnClickListener(v ->  {
            clickable.click();
        });
    }

    @Override
    public int getItemCount() {
        return title.length;
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {
        public BoardViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBoard(int position) {
            binding.tvPagerFirst.setText(title[position]);
            binding.imgPagerView.setImageResource(image[position]);
            if (position == image.length - 1) {
                binding.btnPagerNext.setVisibility(View.VISIBLE);
            }
        }
    }
    interface Clickable {
        void click();
    }
}
