package com.example.myapplicationmylist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {
    ListView lv;
    myListView adapter;
    MainActivity customView =null;
    List<listItem> courses =new ArrayList<listItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customView = this;
        setData();
        Resources res= getResources();
        lv=findViewById(R.id.list);
        adapter=new myListView(customView, (ArrayList) courses,res);
        lv.setAdapter(adapter);



    }
    public void setData(){

       // DatabaseReference ref =.getInstance().getReference("courses");


        listItem item = new listItem("Java","java");
        courses.add(item);
        item = new listItem("Swift","swift");
        courses.add(item);
        item = new listItem("C#","cc");
        courses.add(item);
        item = new listItem("PHP","php");
        courses.add(item);
    }
    public void onItemClick(int i){
        listItem tempValue =(listItem) courses.get(i);
    }
}
