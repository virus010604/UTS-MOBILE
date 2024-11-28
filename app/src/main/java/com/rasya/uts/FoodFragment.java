package com.rasya.uts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class FoodFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.food);

        List<Fooditem> foodList = new ArrayList<>();
        foodList.add(new Fooditem(R.drawable.paket_1, "Meatballs", "Rp.22.999", "Bakso, or Indonesian meatballs, is a savory dish made from a mixture of finely ground beef, tapioca flour, " +
                "and spices. Typically served in a flavorful broth, bakso is often accompanied by noodles, tofu, fried dumplings, and boiled eggs, topped with green onions and fried shallots. " +
                "Its hearty flavor and tender texture make it a beloved comfort food across Indonesia."));
        foodList.add(new Fooditem(R.drawable.paket_2, "Chicken Katsu", "Rp.24.999","Chicken katsu is a Japanese-inspired dish consisting of breaded and deep-fried chicken cutlets." +
                " The crispy outer layer contrasts beautifully with the tender and juicy chicken inside. Often served with steamed rice, shredded cabbage, and a " +
                "tangy katsu sauce, this dish offers a satisfying combination of textures and flavors."));
        foodList.add(new Fooditem(R.drawable.paket_3, "Dumplings", "Rp.29.999", "Dumplings, known as pangsit in Indonesia, are small parcels of dough filled with a savory mixture, usually " +
                "minced chicken, shrimp, or vegetables. These can be steamed or fried to golden perfection and are often paired with" +
                " dipping sauces or served in a light, flavorful soup, making them a versatile and delightful snack or appetizer."));
        foodList.add(new Fooditem(R.drawable.paket_4, "Salad", "Rp.9.999" ,"Salad is a refreshing and healthy dish featuring a colorful combination of fresh vegetables, " +
                "fruits, and proteins like grilled chicken or boiled eggs. Dressed with a variety of sauces, from creamy to tangy vinaigrettes," +
                " salads offer a nutritious meal option that’s both satisfying and customizable to individual tastes."));

        FoodAdapter adapter = new FoodAdapter(foodList, foodItem -> {
            // Aksi saat tombol "+Add" ditekan
            System.out.println("Added: " + foodItem.getName());
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}
