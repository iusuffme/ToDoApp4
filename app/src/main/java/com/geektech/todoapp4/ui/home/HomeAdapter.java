package com.geektech.todoapp4.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.geektech.todoapp4.App;
import com.geektech.todoapp4.Model.Task;
import com.geektech.todoapp4.databinding.ItemNoteBinding;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
    private ItemNoteBinding binding;
    private List<Task> list ;
    private LongTouch click;

    public HomeAdapter(LongTouch click) {
        this.click = click;
    }

    public void save(List<Task> list) {
        this.list = list;
        notifyDataSetChanged();
    }



    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false);
        return new HomeViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.onBind(list.get(position));
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                click.click(list.get(holder.getAdapterPosition()));
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void onBind(Task task) {
            binding.tvItemTitle.setText(task.getTitle());
        }
    }
    public interface LongTouch {
        void click(Task task);
    }
}
