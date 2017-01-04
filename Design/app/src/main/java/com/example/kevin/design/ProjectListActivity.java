package com.example.kevin.design;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ProjectListActivity extends AppCompatActivity {
    Project[] projects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        projects = MainActivity.manager.searchProjects("");

        if(projects==null|| projects.length==0){
            Toast.makeText(this,"Database contains no projects",Toast.LENGTH_LONG).show();

            Intent i = new Intent(ProjectListActivity.this,MainActivity.class);
            startActivity(i);
        }
        else {
            String[] list = new String[projects.length];
            for (int i = 0; i < projects.length; i++) {
                list[i] = projects[i].getProjectName();
            }
            ListView lv = (ListView) findViewById(R.id.projectList);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.proj_list_item, R.id.txtProj, list);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new ItemList());
        }
    }

    class ItemList implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent,View view, int position,long id){
            ViewGroup vg = (ViewGroup) view;
            TextView tv = (TextView) vg.findViewById(R.id.txtProj);

            String s="";
            for(int i=0;i<projects.length;i++){
                if(tv.getText().toString().equals(projects[i].getProjectName())){
                    s=projects[i].toString();
                }
            }
            Intent i = new Intent(ProjectListActivity.this,viewActivityProject.class);
            i.putExtra("name",s);
            startActivity(i);
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
