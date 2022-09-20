package com.example.sqlitedb.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlitedb.Adapter.MyAdapter;
import com.example.sqlitedb.Data.DBHelper;
import com.example.sqlitedb.MainActivity;
import com.example.sqlitedb.R;
import com.example.sqlitedb.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    DBHelper db;
     ListView listView;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

         db = new DBHelper(ViewActivity.this);

        ArrayList<String> contacts = new ArrayList<>();
 //         Cursor data = db.getListContents();
//         int numRows = data.getCount();
//         if (numRows==0){
//             Toast.makeText(ViewActivity.this, "Database is Empty", Toast.LENGTH_SHORT).show();
//         }else{
//             int i=0;
//             while(data.moveToNext()){
//                 contact = new Contact(data.getInt(1),data.getString(2),data.getString(3));
//                 contactlist.add(i,contact);
//                 i++;
//             }
//             MyAdapter adapter = new MyAdapter(this,R.layout.adapter_list,contactlist);
//             listView = findViewById(R.id.listview);
//             listView.setAdapter(adapter);
//
//         }



        listView = findViewById(R.id.listview);
        // Get all contacts
        List<Contact> allContacts = db.getAllContacts();
        for(Contact contact: allContacts){

            Log.d("dbharry", "\nId: " + contact.getId() + "\n" +
                    "Name: " + contact.getName() + "\n"+
                    "Phone Number: " + contact.getPhoneNumber() + "\n" );

             contacts.add(contact.getId() +" : " + contact.getName() + " (" + contact.getPhoneNumber() + ")");
        }

         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contacts);
        listView.setAdapter(arrayAdapter);

        Log.d("dbharry", "Bro you have "+ db.getCount()+ " contacts in your database");



    }
}
