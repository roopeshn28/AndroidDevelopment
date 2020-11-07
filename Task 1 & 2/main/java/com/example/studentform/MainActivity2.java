package com.example.studentform;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    Form form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        form = new Form();
        listView = (ListView)findViewById(R.id.listview);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Form");
        list = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.user_info,R.id.userinfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds: dataSnapshot.getChildren())
                {
                 form = ds.getValue(Form.class);
                 list.add("Guide Name :"+form.getGuidename().toString()+" \nStudent Name : "+form.getFullname().toString()+"\nEmail : "+form.getEmail().toString()+"\nBranch :"+form.getBranch().toString());

                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}