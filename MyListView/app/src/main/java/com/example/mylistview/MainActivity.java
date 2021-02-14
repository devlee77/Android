package com.example.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        SingerAdapter adapter = new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대", "010125325222"));
        adapter.addItem(new SingerItem("녀시대", "010125325222"));
        adapter.addItem(new SingerItem("시대", "010125325222"));
        adapter.addItem(new SingerItem("대", "010125325222"));
        adapter.addItem(new SingerItem("소녀시", "010125325222"));
        adapter.addItem(new SingerItem("소녀", "010125325222"));
        adapter.addItem(new SingerItem("소시대", "010125325222"));
        listView.setAdapter(adapter);

    }

    class SingerAdapter extends BaseAdapter{

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertview, ViewGroup viewGroup) {
            SingerItemView view = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(i);
            view.setName(item.getName());
            view.setMobile(item.getMobile());

            return view;
        }
    }
}