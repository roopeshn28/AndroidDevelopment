package com.example.task4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText ;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {
    private EditText mbranch, memails, mguidemail, mguidename, mguideorg, mguidephone, mnames, morganization, mphoneno, mtheme, musn;
    private Button maddbtn;
    FirebaseDatabase rootnode;
    DatabaseReference reference;
    Studentform studentform;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbranch = (EditText) findViewById(R.id.branch);
        memails = (EditText) findViewById(R.id.emails);
        mguidemail = (EditText) findViewById(R.id.guidemail);
        mguidename = (EditText) findViewById(R.id.guidename);
        mguideorg = (EditText) findViewById(R.id.guideorg);
        mguidephone = (EditText) findViewById(R.id.guidephone);
        mnames = (EditText) findViewById(R.id.names);
        morganization = (EditText) findViewById(R.id.organization);
        mphoneno = (EditText) findViewById(R.id.phoneno);
        mtheme = (EditText) findViewById(R.id.theme);
        musn = (EditText) findViewById(R.id.usn);
        maddbtn = (Button) findViewById(R.id.addbtn);
        studentform = new Studentform();
        reference = FirebaseDatabase.getInstance().getReference().child("Studentform");
        maddbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentform.setBranch(mbranch.getText().toString().trim());
                studentform.setEmails(memails.getText().toString().trim());
                studentform.setGuidemail(mguidemail.getText().toString().trim());
                studentform.setGuidename(mguidename.getText().toString().trim());
                studentform.setGuideorg(mguideorg.getText().toString().trim());
                studentform.setGuidephone(mguidephone.getText().toString().trim());
                studentform.setNames(mnames.getText().toString().trim());
                studentform.setOrganization(morganization.getText().toString().trim());
                studentform.setPhoneno(mphoneno.getText().toString().trim());
                studentform.setTheme(mtheme.getText().toString().trim());
                studentform.setUsn(musn.getText().toString().trim());
                reference.push().setValue(studentform);
                Toast.makeText(MainActivity.this,"data inserted successfully",Toast.LENGTH_LONG).show();


            }
        });



    }
}