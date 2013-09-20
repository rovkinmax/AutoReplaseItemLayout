package com.example.AutoReplaseItemLayout;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created UseIT for  AutoReplaseItemLayout
 * User: maxrovkin
 * Date: 20.09.13
 * Time: 23:50
 */
public class CustomAdapter extends ArrayAdapter<String>
{
    private final boolean[] specialItem;

    public CustomAdapter(final Context context, final int textViewResourceId, final List<String> objects)
    {
        super(context, textViewResourceId, objects);
        specialItem = new boolean[objects.size()];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        if (convertView == null)
            convertView = new CustomListItem(getContext());

        if (!specialItem[position])
            ((CustomListItem) convertView).showUsualLayout(getItem(position));
        else
            ((CustomListItem) convertView).showSpecialLayout(getItem(position), String.format("subtitle %d", position + 1));
        return convertView;
    }


    public void addSpecialItem(final int position)
    {
        specialItem[position] = true;
    }

    public void removeSpecialItem(final int position)
    {
        specialItem[position] = false;
    }

    public boolean isSpecialItem(final int position)
    {
        return specialItem[position];
    }
}
