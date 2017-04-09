package com.example.android.notester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewNoteActivity extends AppCompatActivity {

    public static int totalnumber = 0;
    public static int flag = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        Button cancel_button = (Button) findViewById(R.id.cancel);
        Button save_button = (Button) findViewById(R.id.save);
        TextView showDater = (TextView) findViewById(R.id.showDate);

        Calendar myCalendar = Calendar.getInstance();

        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat dateForamt = new SimpleDateFormat("MMMM dd, yyyy");

        String time = timeFormat.format(myCalendar.getTime());
        String date = dateForamt.format(myCalendar.getTime());
        String ender = date + " " + time;
        showDater.setText(ender);

        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        if (flag == 1) {

            EditText temp1 = (EditText) findViewById(R.id.note_title);
            EditText temp2 = (EditText) findViewById(R.id.content);
            CheckBox myBox = (CheckBox) findViewById(R.id.important);

            temp1.setText(MainFrameActivity.temp.getTitle(), TextView.BufferType.EDITABLE);
            temp2.setText(MainFrameActivity.temp.getContent(), TextView.BufferType.EDITABLE);
            myBox.setChecked(MainFrameActivity.temp.getState());
        }

            save_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (flag == 0) {
                        EditText noteTitle = (EditText) findViewById(R.id.note_title);
                        EditText noteContent = (EditText) findViewById(R.id.content);
                        CheckBox myBox = (CheckBox) findViewById(R.id.important);

                        String title = noteTitle.getText().toString();
                        String Content = noteContent.getText().toString();
                        boolean check = myBox.isChecked();

                        Note myNote = new Note(title, Content, check);
                        totalnumber++;
                        MainActivity.NoteCollection.add(myNote);
                    } else if (flag == 1) {
                        flag = 0;
                        Log.v("NewNoteActivity", "I AM HERE.");
                        EditText temp1 = (EditText) findViewById(R.id.note_title);
                        EditText temp2 = (EditText) findViewById(R.id.content);
                        CheckBox myBox = (CheckBox) findViewById(R.id.important);

                        for (int i = 0; i < MainActivity.NoteCollection.size(); i++) {
                            if ((MainActivity.NoteCollection.get(i).getTitle()).equals(MainFrameActivity.temp.getTitle()))
                            {
                            Log.v("NewNoteActivity", ""+i);
                                MainActivity.NoteCollection.get(i).setTitle(temp1.getText().toString());
                                MainActivity.NoteCollection.get(i).setContent(temp2.getText().toString());
                                MainActivity.NoteCollection.get(i).setState(myBox.isChecked());
                                break;
                            }
                        }
                    }
                    finish();
                    Intent intent = new Intent(NewNoteActivity.this, MainFrameActivity.class);
                    startActivity(intent);

                }
            });


    }

}
