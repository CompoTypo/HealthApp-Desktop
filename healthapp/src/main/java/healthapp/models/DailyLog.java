/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthapp.models;

/**
 *
 * @author Antwa
 */
public class DailyLog {
    public int weight;
    public int bpOver;
    public int bpUnder;
    
    public DailyLog(int w, int O, int U)
    {
        weight = w;
        bpOver = O;
        bpUnder = U;
    }
    
    public void SetWeight(int w)
    {
       weight = w;
    }
    
    public void SetBloodPressureOver(int t)
    {
        bpOver = t;
    }
    
    public void SetBloodPressureUnder(int t)
    {
        bpUnder = t;
    }
    
   
    public float GetWeight()
    {
       return weight;
    }
    
    public int GetBloodPressureOver()
    {
        return bpOver;
    }
    
     public int GetBloodPressureUnder()
    {
        return bpUnder;
    }
    
}

