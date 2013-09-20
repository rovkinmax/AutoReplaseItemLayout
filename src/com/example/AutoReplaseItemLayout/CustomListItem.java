package com.example.AutoReplaseItemLayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created UseIT for  AutoReplaseItemLayout
 * User: maxrovkin
 * Date: 21.09.13
 * Time: 0:24
 */
public class CustomListItem extends FrameLayout
{
    private final View usualLayout;
    private final View specialLayout;

    private final TextView usualTitle;
    private final TextView specialTitle;
    private final TextView specialSubtitle;

    public CustomListItem(final Context context)
    {
        super(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        usualLayout = inflater.inflate(R.layout.usual_item,null);
        specialLayout = inflater.inflate(R.layout.spetial_item,null);
        addView(usualLayout);
        addView(specialLayout);
        specialLayout.setVisibility(GONE);

        usualTitle = (TextView) usualLayout.findViewById(R.id.title);

        specialTitle = (TextView)specialLayout.findViewById(R.id.title);
        specialSubtitle = (TextView)specialLayout.findViewById(R.id.subtitle);
    }

    public void showUsualLayout(final String title)
    {
        specialLayout.setVisibility(GONE);
        usualLayout.setVisibility(VISIBLE);
        usualTitle.setText(title);
    }

    public void showSpecialLayout(final String title, final String subtitle)
    {
        usualLayout.setVisibility(GONE);
        specialLayout.setVisibility(VISIBLE);
        specialTitle.setText(title);
        specialSubtitle.setText(subtitle);
        }


}
