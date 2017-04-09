package com.example.android.notester;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        if(MainFrameActivity.temp != null) {
            TextView displayTitle = (TextView) findViewById(R.id.display_title);
            TextView displayContent = (TextView) findViewById(R.id.display_content);

            displayTitle.setText(MainFrameActivity.temp.getTitle());
            displayContent.setText((MainFrameActivity.temp.getContent()));

            Button edit_Button = (Button) findViewById(R.id.editButton);
            edit_Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent editText = new Intent(DisplayActivity.this, NewNoteActivity.class);
                    NewNoteActivity.flag = 1;
                    startActivity(editText);
                    finish();

                }
            });
        }
    }
}
