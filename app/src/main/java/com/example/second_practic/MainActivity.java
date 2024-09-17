package com.example.second_practic;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<State> states = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setInitialData();

        RecyclerView recyclerView = findViewById(R.id.list);


        StateAdapter adapter = new StateAdapter(this, states);


        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(State state) {

                Toast.makeText(MainActivity.this, "Страна: " + state.getName() +
                        "\nСтолица: " + state.getCapital(), Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setInitialData() {
        states.add(new State("Германия", "Берлин", R.drawable.germany_flag));
        states.add(new State("Швейцария", "Берн", R.drawable.switzerland_flag));
        states.add(new State("Испания", "Мадрид", R.drawable.spane_flag));
        states.add(new State("Португалия", "Лиссабон", R.drawable.portugal_flag));
    }
}