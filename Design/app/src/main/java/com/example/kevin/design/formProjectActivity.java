package com.example.kevin.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class formProjectActivity extends AppCompatActivity {

    EditText projectName;
    EditText expiryDate;
    Button createProjectButton;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        projectName = (EditText) findViewById(R.id.projectNameText);
        expiryDate = (EditText) findViewById(R.id.expiryDateText);
        createProjectButton = (Button)findViewById(R.id.addEquipment);

        createProjectButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = projectName.getText().toString();
                String date = expiryDate.getText().toString();
                Project p = new Project("0",name,"0",date);//TODO add ID and individual
                MainActivity.manager.addProject(p);
                if(MainActivity.manager.checkProject(name)){
                    Toast.makeText(formProjectActivity.this,"YES",Toast.LENGTH_LONG).show();
                }
                Intent i = new Intent(formProjectActivity.this,ProjectListActivity.class);
                i.putExtra("projectName",name);
                startActivity(i);
            }
        });
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