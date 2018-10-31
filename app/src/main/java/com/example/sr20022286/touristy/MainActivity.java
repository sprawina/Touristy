package com.example.sr20022286.touristy;

import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Tourist> formList = new ArrayList<>();

    private TouristAdapter TpAdapter = new TouristAdapter(this, formList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar bar = getSupportActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(android.R.color.black)));

        //Data();

        try {
            JSONObject obj = new JSONObject(readJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("imagesArray");


            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_in = m_jArry.getJSONObject(i);
                String id_val = jo_in.getString("imageID");
                String name_val = jo_in.getString("imageName");
                String url_val = jo_in.getString("imageUrl");

                Tourist tourist = new Tourist(id_val, name_val, url_val);
                formList.add(tourist);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView mRecycView = (RecyclerView) findViewById(R.id.my_recyc_view);
        mRecycView.setHasFixedSize(true);
        mRecycView.setAdapter(TpAdapter);

        RecyclerView.LayoutManager mLayoutMngr = new LinearLayoutManager(getApplicationContext());
        mRecycView.setLayoutManager(mLayoutMngr);


    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("Images");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return json;
    }


}
