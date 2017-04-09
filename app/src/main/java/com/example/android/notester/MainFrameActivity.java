package com.example.android.notester;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainFrameActivity extends AppCompatActivity {

    public static Note temp;
    public static NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_frame);




        updateCounter();

        ImageView addButton = (ImageView) findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainFrameActivity.this, NewNoteActivity.class);
                startActivity(intent);
            }
        });
        adapter = new NoteAdapter(this, MainActivity.NoteCollection);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

           final int location = position;


                AlertDialog.Builder alert = new AlertDialog.Builder(MainFrameActivity.this);
                alert.setTitle("Alert!!");
                alert.setMessage("Are you sure to delete record");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //do your work here
                        listView.invalidate();
                        NewNoteActivity.totalnumber--;
                        MainActivity.NoteCollection.remove(location);
                        adapter.notifyDataSetChanged();
                        updateCounter();
                        dialog.dismiss();
                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                alert.show();

                return true;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                temp = MainActivity.NoteCollection.get(position);
                Log.v("MainFrameActivity", temp.getTitle() + " " + temp.getContent() + " " + temp.getState());
                //display

                Intent display = new Intent(MainFrameActivity.this, DisplayActivity.class);
                startActivity(display);

            }
        });




    }

    private void updateCounter()
    {
        TextView counter = (TextView) findViewById(R.id.count);
        counter.setText("Total number of notes: " + NewNoteActivity.totalnumber);

    }



}