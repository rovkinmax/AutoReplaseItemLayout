package com.example.AutoReplaseItemLayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements ListView.OnItemClickListener
{
    private CustomAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        initListView();
    }

    private void initListView()
    {
        adapter = new CustomAdapter(this, 0, getStringsList(500));
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    private List<String> getStringsList(final int number)
    {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < number; i++)
            list.add(String.format("title %d", i + 1));
        return list;
    }

    @Override
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int position, final long l)
    {
        if (adapter.isSpecialItem(position))
            adapter.removeSpecialItem(position);
        else
            adapter.addSpecialItem(position);
        adapter.notifyDataSetChanged();
    }
}
