package com.example.sqlitedb.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sqlitedb.Data.DBHelper;
import com.example.sqlitedb.MainActivity;
import com.example.sqlitedb.R;
import com.example.sqlitedb.model.Contact;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ViewActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        DBHelper db = new DBHelper(ViewActivity.this);


        ArrayList<String> contacts = new ArrayList<>();
        listView = findViewById(R.id.listview);


        // Get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for(Contact contact: allContacts){

            Log.d("dbharry", "\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n"+
                    "Phone Number: " + contact.getPhoneNumber() + "\n" );

            contacts.add(contact.getId() +". "+ contact.getName() + " (" + contact.getPhoneNumber() + ")" + contact.getDate());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);

        Log.d("dbharry", "Bro you have "+ db.getCount()+ " contacts in your database");



    }
}
