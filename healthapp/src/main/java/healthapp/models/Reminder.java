/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.models;

import java.util.Map;
import javax.swing.*;

/**
 * Reminded stores a reminder
 */
public class Reminder extends JFrame {
    
    public String title;
    public int timeH;
    public int timeM;
    public int dateM;
    public int dateD;
    public String description;
    
    /**
     * Constructs a reminder given a title, month, day, timeh, timem, description
     * @param t the title
     * @param mon the month
     * @param day the day
     * @param h the h
     * @param m the m
     * @param d the description
     */
    public Reminder(String t, int mon, int day, int h, int m,  String d)
    {
        title = t;
        timeH = h;
        timeM = m;
        dateM = mon;
        dateD = day;
        description = d;
    }
    /**
     * Sets the title given a title
     * @param t the title
     */
    public void SetTitle(String t)
    {
       title = t;
    }
    /**
     * Sets the hour
     * @param t the hour
     */
    public void SetHour(int t)
    {
        timeH = t;
    }
    /**
     * Sets the min
     * @param m the min
     */
    public void SetMin(int m)
    {
        timeM = m;
    }
    /**
     * Sets the month
     * @param d the month
     */
    public void SetMonth (int d)
    {
        dateM = d;
    }
    /**
     * Sets the day
     * @param d the day
     */
    public void SetDay(int d)
    {
        dateD = d;
    }
    /**
     * Sets the desc
     * @param d the desc
     */
    public void SetDescription (String d)
    {
        description = d;
    }
    /**
     * Returns the title
     * @return the title
     */
    public String GetTitle()
    {
       return title;
    }
    /**
     * Returns the hour
     * @return the hour
     */
    public int GetHour()
    {
        return timeH;
    }
    /**
     * Returns the min
     * @return the min
     */
    public int GetMin()
    {
        return timeM;
    }
    /**
     * Return the date
     * @return the date
     */
    public int GetDate ()
    {
        return dateM;
    }
    /**
     * Returns the desc
     * @return the desc
     */
    public String GetDescription ()
    {
        return description;
    }
    
    
}

