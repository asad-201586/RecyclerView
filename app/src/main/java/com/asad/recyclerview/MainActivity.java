package com.asad.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private reAdapter adapter;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Recyclerview Practice");

        /*arrayList = new ArrayList<String>(Arrays.asList("Dhaka","Rajshahi","Rangpur","Noakhali",
                "Chottogram","Feni","Cumilla","Dinajpur","Vola","Barishal","Narayanganj"));*/

        ArrayList<GetData> arrayList = new ArrayList<>();
        arrayList.add(new GetData("Dhaka","capital",R.drawable.distance));
        arrayList.add(new GetData("Dinajpur","capital",R.drawable.avoid_touch_face));
        arrayList.add(new GetData("Bogra","capital",R.drawable.body_temperature));
        arrayList.add(new GetData("Rajshahi","capital",R.drawable.difficulty));
        arrayList.add(new GetData("Chittagong","capital",R.drawable.doctor_smartphone));
        arrayList.add(new GetData("comilla","capital",R.drawable.dry_caugh));
        arrayList.add(new GetData("Bagerhat","capital",R.drawable.elbow_sneezing));
        arrayList.add(new GetData("Vola","capital",R.drawable.hand_wash));
        arrayList.add(new GetData("Barishal","capital",R.drawable.home_quarantine));





        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new reAdapter(this,arrayList);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu,menu);

//        MenuInflater menuInflater = new MenuInflater(this);
//        menuInflater.inflate(R.menu.search_menu,menu);

//        MenuItem menuItem = menu.findItem(R.id.search_id);
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        MenuItem menuItem=menu.findItem(R.id.search_id);
        android.widget.SearchView searchView=(android.widget.SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });

        return true;
    }


}
