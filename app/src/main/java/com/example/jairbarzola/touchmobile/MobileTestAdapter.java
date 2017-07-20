package com.example.jairbarzola.touchmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.jairbarzola.touchmobile.R.id.parent;
import static com.example.jairbarzola.touchmobile.R.id.viewa;

/**
 * Created by Jair Barzola on 20-Jul-17.
 */

public class MobileTestAdapter extends BaseAdapter{
    List<MobileTest> mobileTestList = new ArrayList<MobileTest>();
    LayoutInflater layoutInflater;
    Context context;
    public MobileTestAdapter(Context context,List<MobileTest> mobileTestList){
        this.context = context;
        this.mobileTestList= mobileTestList;
        layoutInflater= LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return mobileTestList.size();
    }

    @Override
    public MobileTest getItem(int i) {
        return mobileTestList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if ( view == null){
            view = layoutInflater.inflate(R.layout.item_test,viewGroup,false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        MobileTest mobileTest = getItem(i);
        viewHolder.va.setText(String.valueOf(mobileTest.getA()));
        viewHolder.vb.setText(mobileTest.getB());
        viewHolder.ve.setText(mobileTest.getE());
        viewHolder.vj.setText(mobileTest.getJ());
        if (mobileTest.getA()==1|| String.valueOf(mobileTest.getA())=="1"){
            Picasso.with(context).load("http://jairbarzola.esy.es/Images/002-chico-2.png").into(viewHolder.vl);
        }
        if (mobileTest.getA()==29|| String.valueOf(mobileTest.getA())=="29"){
                Picasso.with(context).load("http://jairbarzola.esy.es/Images/005-chica-2.png").into(viewHolder.vl);
            }
        if (mobileTest.getA()==49|| String.valueOf(mobileTest.getA())=="49"){
                    Picasso.with(context).load("http://jairbarzola.esy.es/Images/004-chico.png").into(viewHolder.vl);
        }
        if (mobileTest.getA()==42|| String.valueOf(mobileTest.getA())=="42"){
            Picasso.with(context).load("http://jairbarzola.esy.es/Images/002-chico-2.png").into(viewHolder.vl);
                    }
        if (mobileTest.getA()==43 || String.valueOf(mobileTest.getA())=="43"){
            Picasso.with(context).load("http://jairbarzola.esy.es/Images/004-chico.png").into(viewHolder.vl);
        }else{
            Picasso.with(context).load("http://jairbarzola.esy.es/Images/002-chico-2.png").into(viewHolder.vl);
        }

        return view;
    }
    public class ViewHolder {

        TextView va;
        TextView vb;
        TextView ve;
        TextView vj;
        ImageView vl;

        public ViewHolder (View item){
            va = (TextView) item.findViewById(R.id.viewa);
            vb= (TextView) item.findViewById(R.id.viewb);
            ve = (TextView) item.findViewById(R.id.viewe);
            vj = (TextView) item.findViewById(R.id.viewj);
            vl = (ImageView) item.findViewById(R.id.image);
        }


    }
}
