package com.example.kevin.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class projectsActivity extends AppCompatActivity {
    Button create;
    Button view;
    Button delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        create = (Button) findViewById(R.id.createProject);
        view = (Button) findViewById(R.id.viewProject);
        delete = (Button) findViewById(R.id.deleteProject);
        create.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonActivity(v);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonActivity(v);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonActivity(v);
            }
        });
    }

    //@Override
    public void buttonActivity(View v) {
        if (v == create) {
            Intent intent = new Intent(this, formProjectActivity.class);
            startActivity(intent);
        } else if (v == view) {
            Intent intent = new Intent(this, ProjectListActivity.class);
            startActivity(intent);
        }
        else if(v == delete){
            Intent intent = new Intent(this, ProjectListActivity.class);
            startActivity(intent);
        }

    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
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
