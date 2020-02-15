package com.example.wasmah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindInt;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.widget.Toast;

import com.example.wasmah.Adapters.FavouritAdapter;
import com.example.wasmah.Utilies.AppUtilies;

import java.util.ArrayList;
import java.util.List;

public class FavouritesActivity extends AppCompatActivity {

    List<String> favList = new ArrayList<>();
    @BindView(R.id.favRec)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        ButterKnife.bind(this);

        favList = AppUtilies.getFavourites(this);
        if(favList!=null&&favList.size()>0) {
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
            recyclerView.setHasFixedSize(true);
            FavouritAdapter adapter = new FavouritAdapter(favList, this);
            recyclerView.setAdapter(adapter);
        }
        else {
            Toast.makeText(this,"There aren't any saved countries",Toast.LENGTH_LONG).show();
        }
    }
}
