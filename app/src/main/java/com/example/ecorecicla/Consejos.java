package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class Consejos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_consejos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView buttonBack = findViewById(R.id.back_button);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Consejos.this, Landing.class);
                startActivity(intent);
            }
        });

        String[] items = {"Comparte tus conocimientos sobre reciclaje con amigos y familiares para ampliar el impacto positivo.",
                "Comienza un compost en casa para convertir los residuos orgánicos en abono para tus plantas",
                "Reutiliza frascos y botellas de vidrio como contenedores para alimentos o almacenamiento.",
                "Limpia los envases antes de reciclarlos para evitar la contaminación.",
                "Añade hojas secas y restos de jardín a tu compost para equilibrar los materiales húmedos de cocina."};

        // Encuentra el ListView en el diseño
        ListView listView = findViewById(R.id.list_view);

        // Crea un ArrayAdapter usando el diseño por defecto de Android para los elementos de la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);

        // Asigna el adaptador al ListView
        listView.setAdapter(adapter);
    }
}