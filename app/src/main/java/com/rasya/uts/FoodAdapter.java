package com.rasya.uts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    private List<Fooditem> foodList;
    private OnAddClickListener onAddClickListener;

    public interface OnAddClickListener {
        void onAddClick(Fooditem foodItem);
    }

    public FoodAdapter(List<Fooditem> foodList, OnAddClickListener onAddClickListener) {
        this.foodList = foodList;
        this.onAddClickListener = onAddClickListener;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_popular, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Fooditem foodItem = foodList.get(position);
        holder.ivFood.setImageResource(foodItem.getImageResource());
        holder.tvFoodName.setText(foodItem.getName());
        holder.tvFoodPrice.setText(foodItem.getPrice());
        holder.tvFoodDes.setText(foodItem.getDes());
        holder.btnAdd.setOnClickListener(v -> onAddClickListener.onAddClick(foodItem));
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFood;
        TextView tvFoodName, tvFoodPrice, tvFoodDes;
        Button btnAdd;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFood = itemView.findViewById(R.id.ivFood);
            tvFoodName = itemView.findViewById(R.id.tvFoodName);
            tvFoodPrice = itemView.findViewById(R.id.tvFoodPrice);
            tvFoodDes = itemView.findViewById(R.id.tvFoodDes);
            btnAdd = itemView.findViewById(R.id.btnAdd);
        }
    }
}
