package com.example.tk2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LanguageAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Language> listLanguage;
    private int positionSelect = -1;

    public LanguageAdapter(Context context, int idLayout, List<Language> listLanguage) {
        this.context = context;
        this.idLayout = idLayout;
        this.listLanguage = listLanguage;
    }

    @Override
    public int getCount() {
        if (listLanguage.size() != 0 && !listLanguage.isEmpty()) {
            return listLanguage.size();
        }
        return 0;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvLanguageName = (TextView) convertView.findViewById(R.id.tvLanguageName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final Language language = listLanguage.get(position);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, language.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });
        return convertView;
    }

}
