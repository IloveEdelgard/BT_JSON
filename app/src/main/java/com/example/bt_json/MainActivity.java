package com.example.bt_json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lvproduct;
    ArrayList<JSONItem> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ReadJSON().execute("https://dummyjson.com/products");

        lvproduct = findViewById(R.id.lv_json);
        //rrayList = new ArrayList<>();

        //adapter = new ListAdapter(this, arrayList);

    }

    private class ReadJSON extends AsyncTask<String, Void, ArrayList<JSONItem>> {
        @Override
        protected ArrayList<JSONItem> doInBackground(String... strings) {
            ArrayList<JSONItem> jsonItems = new ArrayList<>();
            try {
                URL url = new URL(strings[0]);

                InputStreamReader inputStreamReader = new InputStreamReader(url.openConnection().getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String line = "";
                StringBuilder content = new StringBuilder();
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line);
                }

                bufferedReader.close();

                JSONObject object = new JSONObject(content.toString());
                JSONArray array = object.getJSONArray("products");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject pobject = array.getJSONObject(i);
                    String title = pobject.getString("title");
                    String brand = pobject.getString("brand");
                    String price = pobject.getString("price");
                    String stock = pobject.getString("stock");
                    String category = pobject.getString("category");
                    String rating = pobject.getString("rating");
                    String thumbnail = pobject.getString("thumbnail");
                    JSONItem jsonItem = new JSONItem(title, rating, price, thumbnail, stock, category, brand);
                    jsonItems.add(jsonItem);
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jsonItems;
        }

        @Override
        protected void onPostExecute(ArrayList<JSONItem> jsonItems) {
            super.onPostExecute(jsonItems);
            ListAdapter adapter = new ListAdapter(MainActivity.this, jsonItems);
            lvproduct.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        }
    }
}