package com.example.restapi_2018052;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ListView pokemonListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokemonListView = findViewById(R.id.pokemonListView);

        getPokemons();
    }

    private void getPokemons() {
        Call<Komiku> call = RetrofitClient.getInstance().getMyApi().getPokemons();
        call.enqueue(new Callback<Komiku>() {
            @Override
            public void onResponse(Call<Komiku> call, Response<Komiku> response) {
                Komiku pokemonData = response.body();
                ArrayList<RestItem> data = pokemonData.getResults();
                String[] onePokemon = new String[data.size()];

                for (int i = 0; i < data.size(); i++) {
                    onePokemon[i] = data.get(i).getName();
                }

                pokemonListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, onePokemon));
            }

            @Override
            public void onFailure(Call<Komiku> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }

}