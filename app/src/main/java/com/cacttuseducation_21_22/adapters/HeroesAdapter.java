package com.cacttuseducation_21_22.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cacttuseducation_21_22.R;
import com.cacttuseducation_21_22.models.Hero;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeroesAdapter extends BaseAdapter {

    Context context;
    ArrayList<Hero> arrayList;
    LayoutInflater layoutInflater;

    public HeroesAdapter(Context context, ArrayList<Hero> arrayList){
        this.context = context;
        this.arrayList = arrayList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
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

        convertView = layoutInflater.inflate(R.layout.hero_item,null);

        ImageView ivHero = convertView.findViewById(R.id.ivHero);
        TextView tvHeroName = convertView.findViewById(R.id.tvHeroName);
        TextView tvHeroRealName = convertView.findViewById(R.id.tvHeroRealName);

        Hero hero = arrayList.get(position);

        Picasso.get().load(hero.getImageurl()).placeholder(R.mipmap.ic_launcher).into(ivHero);

        tvHeroName.setText("Name: " + hero.getName());
        tvHeroRealName.setText("Realname: " + hero.getRealname());


        return convertView;
    }
}
