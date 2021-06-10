package com.example.listviewadv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick {
    private List<ContactModel> listContacts = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
        mAdapter = new ContactAdapter(this, listContacts);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactModel model = listContacts.get(position);
                Toast.makeText(MainActivity.this, model.getName() + ":" + model.getPhone(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initView(){
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData(){
        listContacts.add(new ContactModel("Nguyen Van A", "0123456781", R.drawable.ic_user_boy));
        listContacts.add(new ContactModel("Nguyen Van B", "0123456782", R.drawable.ic_user_girl));
        listContacts.add(new ContactModel("Nguyen Van C", "0123456783", R.drawable.ic_user_boy));
        listContacts.add(new ContactModel("Nguyen Van D", "0123456784", R.drawable.ic_user_girl));
        listContacts.add(new ContactModel("Nguyen Van E", "0123456785", R.drawable.ic_user_boy));
        listContacts.add(new ContactModel("Nguyen Van G", "0123456786", R.drawable.ic_user_girl));
        listContacts.add(new ContactModel("Nguyen Van H", "0123456787", R.drawable.ic_user_boy));
        listContacts.add(new ContactModel("Nguyen Van K", "0123456788", R.drawable.ic_user_girl));
        listContacts.add(new ContactModel("Nguyen Van L", "0123456789", R.drawable.ic_user_boy));
        listContacts.add(new ContactModel("Nguyen Van M", "0123456790", R.drawable.ic_user_girl));
        listContacts.add(new ContactModel("Nguyen Van N", "0123456791", R.drawable.ic_user_boy));
        listContacts.add(new ContactModel("Nguyen Van O", "0123456792", R.drawable.ic_user_girl));
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mAdapter.unRegisterChildItemClick();
    }

    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContacts.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}
