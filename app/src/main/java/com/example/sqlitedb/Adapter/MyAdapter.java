package com.example.sqlitedb.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sqlitedb.R;
import com.example.sqlitedb.model.Contact;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<Contact>{
    private LayoutInflater mInflater;
    private ArrayList<Contact> contacts;
    private int mViewResourceId;

    public MyAdapter(Context context,int textViewResourceId, ArrayList<Contact> contacts){
        super(context,textViewResourceId,contacts);
        this.contacts= contacts;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId,null);

        Contact contact = getItem(position);
        if (contact == null) {

            TextView tvid = convertView.findViewById(R.id.textid);
            TextView tvname = convertView.findViewById(R.id.textname);
            TextView tvphone = convertView.findViewById(R.id.textphone);

            if (tvid != null) {
                tvid.setText(contact.getId());
            }
            if (tvname != null) {
                tvname.setText(contact.getName());
            }
            if (tvphone != null) {
                tvphone.setText(contact.getPhoneNumber());
            }
        }

        return convertView;


    }
}
