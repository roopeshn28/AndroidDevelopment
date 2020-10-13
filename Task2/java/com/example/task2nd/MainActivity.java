package com.example.task2nd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText ;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText mtxtaim,mtxtneed,mtxtobj,mtxtoutcome,mtxttitle;
    private Button maddbtn;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    PhaseOne phaseone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtxtaim=(EditText)findViewById(R.id.txtaim);
        mtxtneed=(EditText)findViewById(R.id.txtneed);
        mtxtobj=(EditText)findViewById(R.id.txtobj);
        mtxtoutcome=(EditText)findViewById(R.id.txtoutcome);
        mtxttitle=(EditText)findViewById(R.id.txttitle);
        maddbtn=(Button)findViewById(R.id.addbtn);
        phaseone=new PhaseOne();
         /*maddbtn.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view) {
                rootnode=FirebaseDatabase.getInstance();
                reference=rootnode.getReference("Phaseone");
                reference.setValue(mtxtaim);
                reference.setValue(mtxtneed);
                reference.setValue(mtxtobj);
                reference.setValue(mtxtoutcome);
                reference.setValue(mtxttitle);
            }
         });*/
         reference=FirebaseDatabase.getInstance().getReference().child("PhaseOne");
         maddbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 phaseone.setAim(mtxtaim.getText().toString().trim());
                 phaseone.setObj(mtxtneed.getText().toString().trim());
                 phaseone.setNeed(mtxtobj.getText().toString().trim());
                 phaseone.setOutcome(mtxtoutcome.getText().toString().trim());
                 phaseone.setTitle(mtxttitle.getText().toString().trim());
                 reference.push().setValue(phaseone);
                 Toast.makeText(MainActivity.this,"data inserted successfully",Toast.LENGTH_LONG).show();


             }
         });



    }
}