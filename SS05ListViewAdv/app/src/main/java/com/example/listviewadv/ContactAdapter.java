package com.example.listviewadv;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactAdapter  extends BaseAdapter {
    private Context mContext;
    private List<ContactModel> listContacts;
    private IOnChildItemClick iOnChildItemClick;

    public ContactAdapter(Context mContext, List<ContactModel> listContacts) {
        this.mContext = mContext;
        this.listContacts = listContacts;
    }

   public void registerChildItemClick(IOnChildItemClick iOnChildItemClick){
        this.iOnChildItemClick= iOnChildItemClick;
   }
   public void unRegisterChildItemClick(){
        this.iOnChildItemClick = null;
   }

    @Override
    public int getCount() {
        return listContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        //reuse views
        if(rowView == null){
            LayoutInflater inflater = ((Activity)mContext).getLayoutInflater();
            rowView = inflater.inflate(R.layout.item_contact, null);
            //configure view holder
            ViewHolder holder = new ViewHolder();
            holder.tvName = (TextView) rowView.findViewById(R.id.tvName);
//            holder.tvPhone= (TextView) rowView.findViewById(R.id.tvPhone);
//            holder.ivAvatar= (Image) rowView.findViewById(R.id.ivAvatar);
//            holder.btCall= (Button) rowView.findViewById(R.id.btCall);
//            holder.btEdit= (Button) rowView.findViewById(R.id.btEdit);
            rowView.setTag(holder);
        }
        //fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.tvName.setText(listContacts.get(position).getName());
        holder.tvPhone.setText(listContacts.get(position).getPhone());
        holder.ivAvatar.setImageResource(listContacts.get(position).getImage());

        holder.btCall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                onCall(position);
            }
        });
        holder.btEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                iOnChildItemClick.onItemChildClick(position);
            }
        });
        return rowView;
    }

    private void onCall(int position){
        ContactModel contact = listContacts.get(position);
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel : " + contact.getPhone()));
        if(ActivityCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
            return;
        }
        mContext.startActivity(intent);
    }

    static class ViewHolder{
        TextView tvName;
        TextView tvPhone;
        ImageView ivAvatar;
        Button btCall;
        Button btEdit;
    }
}
