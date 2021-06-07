package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvContact;
    private List<ContactModel> listContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        lvContact = (ListView) findViewById(R.id.lvContact);

        ContactAdapter adapter = new ContactAdapter(listContacts,this);
        lvContact.setAdapter(adapter);

        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel contactModel = listContacts.get(position);
                Toast.makeText(MainActivity.this, contactModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        ContactModel contact = new ContactModel("Nguyen Van A", "0123456789", R.drawable.ic_user_boy);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van B", "0123456789", R.drawable.ic_user_girl);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van C", "0123456789", R.drawable.ic_user_boy);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van D", "0123456789", R.drawable.ic_user_girl);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van E", "0123456789", R.drawable.ic_user_boy);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van F", "0123456789", R.drawable.ic_user_girl);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van G", "0123456789", R.drawable.ic_user_boy);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van H", "0123456789", R.drawable.ic_user_girl);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van I", "0123456789", R.drawable.ic_user_boy);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van K", "0123456789", R.drawable.ic_user_girl);
        listContacts.add(contact);
        contact = new ContactModel("Nguyen Van L", "0123456789", R.drawable.ic_user_boy);
        listContacts.add(contact);

    }
}
