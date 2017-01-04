package com.example.kevin.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class equipmentActivity extends AppCompatActivity {
    Button viewE;
    Button damageE;
    Button deleteE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewE = (Button) findViewById(R.id.viewEquip);
        damageE = (Button) findViewById(R.id.damagedEquip);
        deleteE = (Button) findViewById(R.id.delEquip);
        viewE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonActivity(v);
            }
        });
        damageE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonActivity(v);
            }
        });
        deleteE.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonActivity(v);
            }
        });
        setupActionBar();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);

        }
    }

    //@Override
    public void buttonActivity(View v) {
         if (v == viewE) {
            Intent intent = new Intent(this, EquipmentListActivity.class);
            startActivity(intent);
        }
        else if (v == damageE) {
            Intent intent = new Intent(this, damagedActivity.class);
            startActivity(intent);
        }
        else if(v==deleteE){
             Intent intent = new Intent(this, EquipmentListActivity.class);
             startActivity(intent);
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
