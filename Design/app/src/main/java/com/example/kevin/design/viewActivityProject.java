package com.example.kevin.design;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class viewActivityProject extends AppCompatActivity {
    Button edit;
    Button delete;
    String stringDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_project);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView tv = (TextView) findViewById(R.id.viewProjectText);
        String output = getIntent().getStringExtra("name");
        stringDelete = output;
        tv.setText(output);

        edit = (Button) findViewById(R.id.editButton);
        delete = (Button) findViewById(R.id.deleteButton);
        edit.setOnClickListener(new View.OnClickListener() {
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
        if (v == edit) {
            Toast.makeText(this,"Hello",Toast.LENGTH_LONG);
            Intent intent = new Intent(this, MainActivity.class);//TODO change to an editProject activity
            startActivity(intent);
        }
        else if(v == delete){
            String result = stringDelete.substring(stringDelete.indexOf(":") + 2, stringDelete.indexOf('\n'));
            MainActivity.manager.deleteProject(result);
            Intent intent = new Intent(this, ProjectListActivity.class);
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
