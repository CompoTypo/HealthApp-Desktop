/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.models;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;
public class Reminder extends JFrame {
    
    public String title;
    public int timeH;
    public int timeM;
    public int dateM;
    public int dateD;
    public String description;
    
    public Reminder(String t, int mon, int day, int h, int m,  String d)
    {
        title = t;
        timeH = h;
        timeM = m;
        dateM = mon;
        dateD = day;
        description = d;
    }
    
    public void SetTitle(String t)
    {
       title = t;
    }
    
    public void SetHour(int t)
    {
        timeH = t;
    }
    
    public void SetMin(int m)
    {
        timeM = m;
    }
    
    public void SetMonth (int d)
    {
        dateM = d;
    }
    
    public void SetDay(int d)
    {
        dateD = d;
    }
    public void SetDescription (String d)
    {
        description = d;
    }
    
    public String GetTitle()
    {
       return title;
    }
    
    public int GetHour()
    {
        return timeH;
    }
    
    public int GetMin()
    {
        return timeM;
    }
    
    public int GetDate ()
    {
        return dateM;
    }
    
    public String GetDescription ()
    {
        return description;
    }
    
    
}

