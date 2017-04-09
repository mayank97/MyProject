package com.example.android.notester;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Mayank on 4/6/2017.
 */

public class NoteAdapter extends ArrayAdapter<Note>
{
    public NoteAdapter(Activity context, ArrayList<Note> collection)
    {
        super(context,0,collection);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        View listItemView = convertView;

        if(listItemView == null)
        {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }

        RelativeLayout root = (RelativeLayout) listItemView.findViewById(R.id.root);
        root.setBackgroundColor(000000);

        Note my_note = getItem(position);

        TextView noteTitle = (TextView) listItemView.findViewById(R.id.title);
        noteTitle.setText(my_note.getTitle());

        ImageView imageGet = (ImageView) listItemView.findViewById(R.id.image);
        if(my_note.getState() == true)
        {
            imageGet.setImageResource(R.drawable.designcircle);
        }
        else
        {
            imageGet.setImageResource(R.drawable.designcircle2);
        }
        TextView timer = (TextView) listItemView.findViewById(R.id.time);
        TextView dater = (TextView) listItemView.findViewById(R.id.date);

        Calendar myCalendar = Calendar.getInstance();

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateForamt = new SimpleDateFormat("MMMM dd, yyyy");

        timer.setText(timeFormat.format(myCalendar.getTime()));
        dater.setText(dateForamt.format(myCalendar.getTime()));


        return listItemView;

    }
}
