package com.example.android.notester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Note> NoteCollection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NoteCollection = new ArrayList<>();

        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this, "Sample App", Toast.LENGTH_SHORT).show();
            }
        });

        Button contin = (Button) findViewById(R.id.contin);
        contin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent mainframe = new Intent(MainActivity.this, MainFrameActivity.class);
                startActivity(mainframe);
            }
        });

        Button newNote = (Button) findViewById(R.id.new_note);
        newNote.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent note = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivity(note);
            }
        });
    }
}
