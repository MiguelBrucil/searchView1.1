package com.jmbp.searchview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String[] nombres;
    private ArrayAdapter<String> Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombres = new String[]{"jose", "luis", "pedro", "lucas", "martin", "flores"};

        ListView listView = findViewById(R.id.listView);
        Lista = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, nombres);
        listView.setAdapter(Lista);

        SearchView searchView = findViewById(R.id.idsearch);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Lista.getFilter().filter(newText);
                return true;
            }
        });

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedName = Lista.getItem(position);
            Toast.makeText(MainActivity.this, "Nombre seleccionado: " + selectedName, Toast.LENGTH_SHORT).show();
        });
    }
}
