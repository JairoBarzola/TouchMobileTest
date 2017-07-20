package com.example.jairbarzola.touchmobile;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jairbarzola.touchmobile.Service.Service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    MobileTestAdapter adapter;
    List<MobileTest> mobileTestList = new ArrayList<MobileTest>();
    List<MobileTest> mobileDialog = new ArrayList<MobileTest>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        /*Estructura para retrofit2*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://touchmobile.pe/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);

        Call<List<MobileTest>> listCall = service.getData();

        listCall.enqueue(new Callback<List<MobileTest>>() {
            @Override
            public void onResponse(Call<List<MobileTest>> call, Response<List<MobileTest>> response) {
                mobileTestList= response.body();
                mobileDialog=mobileTestList;
                adapter = new MobileTestAdapter(getApplicationContext(),mobileTestList);
                listView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<MobileTest>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error en el servidor", Toast.LENGTH_SHORT).show();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                dialog(i).show();
            }
        });
    }
    private Dialog dialog(int position) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = this.getLayoutInflater();

        View v = inflater.inflate(R.layout.dialog_item, null);
        TextView item_a = (TextView) v.findViewById(R.id.itema);
        TextView item_b = (TextView) v.findViewById(R.id.itemb);
        TextView item_c = (TextView) v.findViewById(R.id.itemc);
        TextView item_d = (TextView) v.findViewById(R.id.itemd);
        TextView item_e = (TextView) v.findViewById(R.id.iteme);
        TextView item_f = (TextView) v.findViewById(R.id.itemf);
        TextView item_g = (TextView) v.findViewById(R.id.itemg);
        TextView item_h = (TextView) v.findViewById(R.id.itemh);
        TextView item_i = (TextView) v.findViewById(R.id.itemi);
        TextView item_j = (TextView) v.findViewById(R.id.itemj);
        TextView item_k = (TextView) v.findViewById(R.id.itemk);
        TextView item_l = (TextView) v.findViewById(R.id.iteml);
        TextView item_m = (TextView) v.findViewById(R.id.itemm);
        TextView item_n = (TextView) v.findViewById(R.id.itemn);
        TextView item_o = (TextView) v.findViewById(R.id.itemo);
        TextView item_p = (TextView) v.findViewById(R.id.itemp);
        TextView item_q = (TextView) v.findViewById(R.id.itemq);

        item_a.setText("A :"+String.valueOf(mobileDialog.get(position).getA()));
        item_b.setText("B :"+mobileDialog.get(position).getB());
        item_c.setText("C :"+mobileDialog.get(position).getC());
        item_d.setText("D :"+mobileDialog.get(position).getD());
        item_e.setText("E :"+mobileDialog.get(position).getE());
        item_f.setText("F :"+mobileDialog.get(position).getF());
        item_g.setText("G :"+mobileDialog.get(position).getG());
        item_h.setText("H :"+mobileDialog.get(position).getH());
        item_i.setText("I :"+String.valueOf(mobileDialog.get(position).getI()));
        item_j.setText("J :"+mobileDialog.get(position).getJ());
        item_k.setText("K :"+mobileDialog.get(position).getK());
        item_l.setText("L :"+mobileDialog.get(position).getL());
        item_m.setText("M :"+mobileDialog.get(position).getM());
        item_n.setText("N :"+mobileDialog.get(position).getN());
        item_o.setText("O :"+mobileDialog.get(position).getO());
        item_p.setText("P :"+mobileDialog.get(position).getP());
        item_q.setText("Q :"+mobileDialog.get(position).getQ());

        builder.setCancelable(false);
        builder.setView(v);
        builder.setTitle("DESCRIPCION");
        builder.setPositiveButton("OK",    new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.dismiss();
            }
        });

        return builder.create();
    }
}
