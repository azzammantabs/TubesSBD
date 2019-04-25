/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubessbd;

/**
 *
 * @author Abdullah Azzam
 */
public class StringMatch {
    String[] text;
 
    String[] pattern;
 
    int n, m, idx;
 
    boolean ketemu;
 
    public StringMatch(String text, String pattern) {
 
        //split berfungsi untuk memecah character menjadi array
        this.text = text.split("");
        this.pattern = pattern.split("");
        this.n = this.text.length;
        this.m = this.pattern.length;
        this.idx = -1; 
    }

    public boolean run()
 
    {
         int i = 0;
      
         while (i <= n-m && !ketemu) {
            int j = 1;
            
//equals berfungsi untuk membanding kan 2 buah variabel
             while (j < m && (this.pattern[j].equals(this.text[i + j]))) {
 
                j = j + 1;
 
            }
 
            if (j == m)
 
                ketemu = true;
 
            else
                i = i + 1;
 
        }
       if (ketemu) 
    
           this.idx = i + 1;

       
        return ketemu;
    }
}
