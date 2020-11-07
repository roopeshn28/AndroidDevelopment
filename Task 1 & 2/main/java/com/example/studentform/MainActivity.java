package com.example.studentform;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText fullname,branch,usn,email,guidename,guideemail,guidephone,phone,organization;
    Button submit;
    Button retrieve;
    DatabaseReference ref;
    Form form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullname = (EditText) findViewById(R.id.fullname);
        branch = (EditText) findViewById(R.id.branch);
        usn = (EditText) findViewById(R.id.usn);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        guidename = (EditText) findViewById(R.id.guidename);
        guideemail = (EditText) findViewById(R.id.guideemail);
        guidephone = (EditText) findViewById(R.id.guidephone);
        organization = (EditText) findViewById(R.id.organization);
        submit = (Button) findViewById(R.id.submitbtn);
        retrieve = (Button) findViewById(R.id.retrieve);
        ref = FirebaseDatabase.getInstance().getReference().child("Form");
        form = new Form();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                form.setFullname(fullname.getText().toString());
                form.setBranch(branch.getText().toString());
                form.setUsn(usn.getText().toString());
                form.setEmail(email.getText().toString());
                form.setPhone(phone.getText().toString());
                form.setGuidename(guidename.getText().toString());
                form.setGuideemail(guideemail.getText().toString());
                form.setGuidephone(guidephone.getText().toString());
                form.setOrganization(organization.getText().toString());

                ref.push().setValue(form);
                Toast.makeText(MainActivity.this , "data inserted" , Toast.LENGTH_LONG).show();


            }
        });

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRetrieve();
            }
        });
    }

    public void openRetrieve() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}