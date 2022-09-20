package com.example.sqlitedb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlitedb.Activities.ViewActivity;
import com.example.sqlitedb.Data.DBHelper;
import com.example.sqlitedb.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText EName,EPhone;
    Button btnsave, btnview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(MainActivity.this);

        EName = findViewById(R.id.name);
        EPhone = findViewById(R.id.phone);
        btnsave = findViewById(R.id.button);
        btnview = findViewById(R.id.button2);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact contact = new Contact();
                String name = EName.getText().toString();
                String  phone =  EPhone.getText().toString().toString();
                contact.setName(name);
                contact.setPhoneNumber(String.valueOf(phone));
                db.addContact(contact);
                Toast.makeText(MainActivity.this, "Successfully inserted", Toast.LENGTH_SHORT).show();
                Log.d("dbharry", "Id for tehri and larry are successfully added to the db");


            }
        });

        btnview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                startActivity(intent);
            }
        });

//        // Creating a contact object for the db
//        Contact harry = new Contact();
//        harry.setPhoneNumber("9090909090");
//        harry.setName("Harry");
//
//        // Adding a contact to the db
//        db.addContact(harry);
//
//        // Creating a contact object for the db
//        Contact larry = new Contact();
//        larry.setPhoneNumber("9090459090");
//        larry.setName("Larry");
//
//        // Adding a contact to the db
//        db.addContact(larry);
//
//        // Creating a contact object for the db
//        Contact tehri = new Contact();
//        tehri.setPhoneNumber("9090675409");
//        tehri.setName("Tehri");
//
//        // Adding a contact to the db
//        db.addContact(tehri);
//        Log.d("dbharry", "Id for tehri and larry are successfully added to the db");

//        tehri.setId(46);
//        tehri.setName("Changed Tehri");
//        tehri.setPhoneNumber("0000000000");
//        int affectedRows = db.updateContact(tehri);
//
//        Log.d("dbharry", "No of affected rows are: " + affectedRows);
//        db.deleteContactById(1);
//        db.deleteContactById(12);
//        db.deleteContactById(5);


    }

}