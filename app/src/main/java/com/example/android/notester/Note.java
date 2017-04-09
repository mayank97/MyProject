package com.example.android.notester;

/**
 * Created by Mayank on 4/6/2017.
 */

public class Note
{
    private String title;
    private String content;
    private boolean check;

    public Note(String title, String note, boolean check)
    {
        this.title = title;
        this.content = note;
        this.check = check;
    }
    public String getTitle()
    {
        return this.title;
    }
    public String getContent()
    {
        return this.content;
    }
    public boolean getState() {return this.check;}
    public void setState(boolean check) {this.check = check;}
    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
}
