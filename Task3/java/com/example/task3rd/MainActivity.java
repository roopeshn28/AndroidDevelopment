package com.example.task3rd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText ;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity {
    private EditText mbranch,memails,mguidemail,mguidename,mguideorg,mguidephone,mnames,morganization,mphoneno,mtheme,musn;
    private Button mshowbtn;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    Studentform studentform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbranch=(EditText)findViewById(R.id.branch);
        memails=(EditText)findViewById(R.id.emails);
        mguidemail=(EditText)findViewById(R.id.guidemail);
        mguidename=(EditText)findViewById(R.id.guidename);
        mguideorg=(EditText)findViewById(R.id.guideorg);
        mguidephone=(EditText)findViewById(R.id.guidephone);
        mnames=(EditText)findViewById(R.id.names);
        morganization=(EditText)findViewById(R.id.organization);
        mphoneno=(EditText)findViewById(R.id.phoneno);
        mtheme=(EditText)findViewById(R.id.theme);
        musn=(EditText)findViewById(R.id.usn);
        mshowbtn=(Button)findViewById(R.id.showbtn);
        studentform=new Studentform();
        reference=FirebaseDatabase.getInstance().getReference().child("Studentform");
        mshowbtn.setOnClickListener(new View.OnClickListener() {
         @Override
            public void onClick(View view) {
             //reference=FirebaseDatabase.getInstance().getReference().child("Studentform").child("1");
             reference.addValueEventListener(new ValueEventListener() {
                 @Override
                 public void onDataChange(@NonNull DataSnapshot snapshot) {

                     String branch=snapshot.child("branch").getValue().toString();
                     String emails=snapshot.child("emails").getValue().toString();
                     String guidemail=snapshot.child("guidemail").getValue().toString();
                     String guidename=snapshot.child("guidename").getValue().toString();
                     String guideorg=snapshot.child("guideorg").getValue().toString();
                     String guidephone=snapshot.child("guidephone").getValue().toString();
                     String names=snapshot.child("names").getValue().toString();
                     String organization=snapshot.child("organization").getValue().toString();
                     String phoneno=snapshot.child("phoneno").getValue().toString();
                     String theme=snapshot.child("theme").getValue().toString();
                     String usn=snapshot.child("usn").getValue().toString();
                     mbranch.setText(branch);
                     memails.setText(emails);
                     mguidemail.setText(guidemail);
                     mguidename.setText(guidename);
                     mguideorg.setText(guideorg);
                     mguidephone.setText(guidephone);
                     mnames.setText(names);
                     morganization.setText(organization);
                     mphoneno.setText(phoneno);
                     mtheme.setText(theme);
                     musn.setText(usn);

                 }

                 @Override
                 public void onCancelled(@NonNull DatabaseError error) {

                 }
             });
         }
        });


        }


    }