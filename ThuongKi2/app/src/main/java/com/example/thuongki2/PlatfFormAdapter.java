package com.example.thuongki2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PlatfFormAdapter extends ArrayAdapter<NhanVien> {
    Context context;
    int layoutResourceId;
    List<NhanVien> data;
    public PlatfFormAdapter(Context context, int resource, List<NhanVien> data) {
        super(context, resource, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        PlatfFormHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new PlatfFormHolder();
            holder.txtMaso = (TextView)row.findViewById(R.id.tv_maso);
            holder.txtHoten = (TextView)row.findViewById(R.id.tv_hoten);
            holder.txtGioitinh = (TextView)row.findViewById(R.id.tv_gioitinh);
            holder.txtDonvi = (TextView)row.findViewById(R.id.tv_donvi);
            row.setTag(holder);
        }
        else
        {
            holder = (PlatfFormHolder)row.getTag();
        }
        NhanVien pf = data.get(position);
        holder.txtMaso.setText(pf.getMaso());
        holder.txtDonvi.setText(pf.getHoten());
        holder.txtDonvi.setText(pf.getGioitinh());
        holder.txtDonvi.setText(pf.getDonvi());
        return row;
    }
    class PlatfFormHolder
    {
        TextView txtMaso;
        TextView txtHoten;
        TextView txtGioitinh;
        TextView txtDonvi;
    }
}
