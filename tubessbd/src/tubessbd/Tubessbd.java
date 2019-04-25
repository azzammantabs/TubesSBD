/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubessbd;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import com.sun.glass.events.KeyEvent;

/**
 *
 * @author Nur M. Ihsan
 */
public class Tubessbd {

    /**
     * @param args the command line arguments
     */
    public static String readFileAsString(String fileName)throws Exception { 
        String data = ""; 
        data = new String(Files.readAllBytes(Paths.get(fileName))); 
        return data; 
    }
  
    public static void main(String[] args) throws Exception { 
        String data = readFileAsString("pe.txt"); 
        String[] parts = data.split("#");

        //System.out.println(parts[1]); 
        String[] data1 = parts[0].split(";");
        String[] data2 = parts[1].split(";");
        String[] data3 = parts[2].split(";");
        String[] data4 = parts[3].split(";");
        
        //System.out.println(parts[1]);
        String pointer,block;
        float sizeB = 0, sizeP = 0;
        for (int i=0; i<data1.length;i++) {
            String[] datain = data1[i].split(" ");
            for (int j = 0; j < datain.length-1; j++) {
//                System.out.println(datain[j]);
//                System.out.println(datain[j+1]);
                char[] huruf = datain[j].toCharArray();
                int l = 0;
                if(huruf[l]=='P') {
                    pointer = datain[j+1];
                    sizeP = Integer.parseInt(pointer);
                    
                }else if(huruf[l]=='B') {
                    block = datain[j+1];
                    sizeB = Integer.parseInt(block);
                    
                }
            }
        }
        
        //System.out.println(parts[2]);
        String record,jrecord,key;
        float  sizeR = 0, sizeJR = 0, sizeK = 0;
        for (int i=0; i<data2.length;i++) {
            //System.out.println(data2[i]);
            String[] datain = data2[i].split(" ");
            for (int j = 0; j < datain.length-1; j++) {
              //  System.out.println(datain[j]);
                char[] huruf = datain[j].toCharArray();
                int l = 0;
                if(huruf[l]=='R') {
                    record = datain[j+1];
                    sizeR = Integer.parseInt(record);
                }else if(huruf[l]=='n') {
                    jrecord = datain[j+1];
                    sizeJR = Integer.parseInt(jrecord);
                }else if(huruf[l]=='V') {
                    key = datain[j+1];
                    sizeK = Integer.parseInt(key);
                }
            }
        }
        
        //System.out.println(parts[3]);
        String record2, jrecord2, key2; 
        float  sizeR2 = 0, sizeJR2 = 0, sizeK2 = 0;
        for (int i=0; i<data3.length;i++) {
            //System.out.println(data3[i]);
            String[] datain = data3[i].split(" ");
            for (int j = 0; j < datain.length-1; j++) {
                //System.out.println(datain[j]);
                char[] huruf = datain[j].toCharArray();
                int m = 0;
                if(huruf[m]=='R') {
                    record2 = datain[j+1];
                    sizeR2 = Integer.parseInt(record2);
                }else if(huruf[m]=='n') {
                    jrecord2 = datain[j+1];
                    sizeJR2 = Integer.parseInt(jrecord2);
                }else if(huruf[m]=='V') {
                    key2 = datain[j+1];
                    sizeK2 = Integer.parseInt(key2);
                }
            }
        }
        
        //System.out.println(parts[4]);
        String record3,jrecord3,key3;
        float  sizeR3 = 0, sizeJR3 = 0, sizeK3 = 0;
        for (int i=0; i<data4.length;i++) {
            //System.out.println(data4[i]);
            String[] datain = data4[i].split(" ");
            for (int j = 0; j < datain.length-1; j++) {
                //System.out.println(datain[j]);
                char[] huruf = datain[j].toCharArray();
                int n = 0;
                if(huruf[n]=='R') {
                    record3 = datain[j+1];
                    sizeR3 = Integer.parseInt(record3);
                }else if(huruf[n]=='n') {
                    jrecord3 = datain[j+1];
                    sizeJR3 = Integer.parseInt(jrecord3);
                }else if(huruf[n]=='V') {
                    key3 = datain[j+1];
                    sizeK3 = Integer.parseInt(key3);
                }
            }
        }
        
        //pemanggilan method menu utama
        menuUtama(data2,data3,data4,sizeB,sizeP,sizeR,sizeJR,sizeK,sizeR2,sizeJR2,sizeK2,sizeR3,sizeJR3,sizeK3);
            
        
        String query="";
        
        String[] part = query.split(";");
        String[] atribut = part[0].split(" ");
        
        for (int i=0; i<atribut.length;i++) {
            System.out.println(atribut[i]);
        }
        
        String text = query;
        String pattern = "SELECT";
        String patternslct = "select";
        String pattern1 = "FROM";
        String patternfrm = "from";
        String pattern2 = " ;";
        String pattern3 = "JOIN";
        String patternjoin = "join";
        String pattern4 = "USING";
        String patternusing = "using";
        System.out.println(pattern2);
        StringMatch c = new StringMatch(text, pattern2);
        
        if (c.run()==true) {
            StringMatch a = new StringMatch(text, pattern);
            System.out.println(a.idx);
            StringMatch ai = new StringMatch(text, patternslct);
            if (a.run()||ai.run() && a.idx==1||ai.idx==1) {
                StringMatch b = new StringMatch(text, pattern1);
                StringMatch bi = new StringMatch(text, patternfrm);
                if(b.run() || bi.run()) {
                    
                        //String[] part = text.split(";");
                       // String[] atribut = part[0].split(" ");
                        boolean found = false;
                        String[] colum = new String[10];
                        int j=1;
                        int l=1;
                        while (j<atribut.length) {
                            int k=1;
                            while (k<data1.length) {
                                if (atribut[j]==data1[k]) {
                                    found = true;
                                    colum[l] = data1[k];
                                    l++;
                                }
                                k++;
                            }
                            j++;
                        }
                        j=1;
                        while (j<atribut.length) {
                            int k=0;
                            while (k<data2.length) {
                                if (atribut[j]==data2[k]) {
                                    found = true;
                                    colum[l] = data2[k];
                                    l++;
                                }
                                k++;
                            }
                            j++;
                        }
                        j=1;
                        while (j<atribut.length) {
                            int k=0;
                            while (k<data3.length) {
                                if (atribut[j]==data3[k]) {
                                    found = true;
                                    colum[l] = data3[k];
                                    l++;
                                }
                                k++;
                            }
                            j++;
                        }
                        if (found==true) {
                            System.out.println("Tabel itemukan");
                            for (int i = 1; i <= 3; i++) {
                                System.out.println("Tabel ("+i+") : ");
                                System.out.print("List Kolom : ");
                                int m =0;
                                while(m<colum.length) {
                                    System.out.print(colum[m]+", ");
                                     m++;
                                }
                            }
                        }else {
                            System.out.println("Tabel tidak ditemukan");
                        }
                    System.out.println("SYNTAX BERHASIL");
                }else {
                    System.out.println("SQL Error (Syntax Error)");
                    System.out.println("Syntax tidak ditemukan dalam string (Missing from)");
                }
            } else {
                    System.out.println("SQL Error (Syntax Error)");
                    System.out.println("Syntax tidak ditemukan dalam string (Missing select)");
                    
            }             
        }else  {
            System.out.println("SQL Error (Missing ;)");
        }

    }
    
    // METHOD MENU UTAMA
    public static void menuUtama(String[] data2, String[] data3, String[] data4, float sizeB, float sizeP, float sizeR, float sizeJR, float sizeK, float sizeR2, float sizeJR2, float sizeK2, float sizeR3, float sizeJR3, float sizeK3) {
        //MENU UTAMA
        System.out.println();
        Scanner choose = new Scanner(System.in);
        System.out.println(">> Menu Utama :");
        System.out.println("    1. Tampilkan BFR dan Fanout Rasio Setiap Tabel");
        System.out.println("    2. Tampilkan Total Blok Data + Blok Index Setiap Tabel");
        System.out.println("    3. Tampilkan Jumlah Blok yang Diakses Untuk Pencarian Record");
        System.out.println("    4. Tampilkan QEP dan Cost");
        System.out.println("    5. Tampilkan Isi File Shared Pool");
        System.out.print(">> Masukkan Pilihan Anda : "); int pil = choose.nextInt();
        
        //lanjut ke if pilihan
        if (pil==1) {
            menu1(data2,data3,data4,sizeB,sizeJR,sizeR,sizeK,sizeP,sizeR2,sizeJR2,sizeK2,sizeR3,sizeJR3,sizeK3);
        } else if (pil==2) {
            menu2(data2,data3,data4,sizeR,sizeJR,sizeB,sizeK,sizeP,sizeR2,sizeJR2,sizeK2,sizeR3,sizeJR3,sizeK3);
        } else if (pil==3) {
            menu3(data2,data3,data4,sizeB,sizeR,sizeJR,sizeK,sizeP,sizeR2,sizeJR2,sizeK2,sizeR3,sizeJR3,sizeK3);
        } else if (pil==4) {
            
        } else if (pil==5) {
            
        }
    }
    
    //METHOD MENU 1
    public static void menu1(String[] data2, String[] data3, String[] data4, float sizeB, float sizeR, float sizeJR, float sizeK, float sizeP, float sizeR2, float sizeJR2, float sizeK2, float sizeR3, float sizeJR3, float sizeK3) {
        System.out.println();
        Scanner press = new Scanner(System.in);
        float bfr = sizeB / sizeR;
        float fan = sizeB / (sizeK+sizeP);
        System.out.println("BFR Lagu : "+(int) Math.floor(bfr));
        System.out.println("Fan Out Ratio Lagu : "+(int) Math.floor(fan));
        float bfr2 = sizeB / sizeR2;
        float fan2 = sizeB / (sizeK2+sizeP);
        System.out.println("BFR Pendengar : "+(int) Math.floor(bfr2));
        System.out.println("Fan Out Ratio Pendengar : "+(int) Math.floor(fan2));
        float bfr3 = sizeB / sizeR3;
        float fan3 = sizeB / (sizeK3+sizeP);
        System.out.println("BFR Playlist_premium : "+(int) Math.floor(bfr3));
        System.out.println("Fan Out Ratio Playlist_premium : "+(int) Math.floor(fan3));
        System.out.println("");
        System.out.print("Ketik 0 Press enter untuk kembali..."); press.next();
        menuUtama(data2,data3,data4,sizeB,sizeP,sizeR,sizeJR,sizeK,sizeR2,sizeJR2,sizeK2,sizeR3,sizeJR3,sizeK3);
    }
    
    //METHOD MENU 2
    public static void menu2(String[] data2, String[] data3, String[] data4, float sizeR, float sizeJR, float sizeB, float sizeK, float sizeP, float sizeR2, float sizeJR2, float sizeK2, float sizeR3, float sizeJR3, float sizeK3) {
        System.out.println();
        Scanner pres = new Scanner(System.in);
        float bfr = sizeB / sizeR;
        float td = (float) (sizeJR / Math.floor(bfr));
        int tds = (int) Math.ceil(td);
        float fan = sizeB / (sizeK+sizeP);
        float fans = sizeB / fan;
        int tdi = (int) (tds + Math.ceil(fans));
        System.out.println("Tabel Data Lagu : "+tds+" blok");
        System.out.println("Indeks Lagu : "+tdi+" blok");
        float bfr2 = sizeB / sizeR2;
        float td2 = (float) (sizeJR2 / Math.floor(bfr2));
        int tds2 = (int) Math.ceil(td2);
        float fan2 = sizeB / (sizeK2+sizeP);
        float fans2 = sizeB / fan2;
        int tdi2 = (int) (tds2 + Math.ceil(fans2));
        System.out.println("Tabel Data Pendengar : "+tds2+" blok");
        System.out.println("Indeks Pendengar : "+tdi2+" blok");
        float bfr3 = sizeB / sizeR3;
        float td3 = (float) (sizeJR3 / Math.floor(bfr3));
        int tds3 = (int) Math.ceil(td3);
        float fan3 = sizeB / (sizeK3+sizeP);
        float fans3 = sizeB / fan3;
        int tdi3 = (int) (tds3 + Math.ceil(fans3));
        System.out.println("Tabel Data Playlist_premium : "+tds3+" blok");
        System.out.println("Indeks Playlist_premium : "+tdi3+" blok");
        System.out.println("");
        System.out.print("Ketik 0 Press enter untuk kembali..."); pres.next();
        menuUtama(data2,data3,data4,sizeB,sizeP,sizeR,sizeJR,sizeK,sizeR2,sizeJR2,sizeK2,sizeR3,sizeJR3,sizeK3);
    }
    
    //METHOD MENU 3
    public static void menu3(String[] data2, String[] data3, String[] data4,float sizeB, float sizeR, float sizeJR, float sizeK, float sizeP, float sizeR2, float sizeJR2, float sizeK2, float sizeR3, float sizeJR3, float sizeK3) {
        System.out.println();
        Scanner pres = new Scanner(System.in);
        float bfr = sizeB / sizeR;
        float fan = sizeB / (sizeK+sizeP);
        float bfr2 = sizeB / sizeR2;
        float fan2 = sizeB / (sizeK2+sizeP);
        float bfr3 = sizeB / sizeR3;
        float fan3 = sizeB / (sizeK3+sizeP);
        Scanner rec = new Scanner(System.in);
        Scanner tab = new Scanner(System.in);
        System.out.println("Input :");
        System.out.print(">> Cari Record ke : "); int recor = rec.nextInt();
        System.out.print(">> Nama Tabel : "); String tabel = tab.next();
        System.out.println("");
        System.out.println("Output :");
        int status = cariTabel(tabel,data2,data3,data4);
        System.out.println("status : "+status);
        float ri = 0,r = 0;
        if (status==1) {
            ri=recor/bfr;
            r=recor/fan;
        } else if (status==2) {
            ri=recor/bfr2;
            r=recor/fan2;
        } else if (status==3) {
            ri=recor/bfr3;
            r=recor/fan3;
        } else {
            System.out.println("tabel tidak ditemukan");
        }
        System.out.println(">> Menggunakan Indeks, jumlah blok yang diakses : "+(int) Math.ceil(r)+" blok");
        System.out.println(">> Tanpa Indeks, jumlah blok yang diakses : "+(int) Math.ceil(ri)+" blok");
        System.out.print("Ketik 0 Press enter untuk kembali..."); pres.next();
        menuUtama(data2,data3,data4,sizeB,sizeP,sizeR,sizeJR,sizeK,sizeR2,sizeJR2,sizeK2,sizeR3,sizeJR3,sizeK3);
    }
    
    //METHOD MENU 4
    public static void menu4() {
        Scanner read = new Scanner(System.in);
        System.out.println("Masukkan SQL Statement : "); 
        String query = read.nextLine();
    }
    
    //METHOD MENU 5
    public static void menu5() {
        
    }
    
    //METHOD FUNCTION CARI TABEL
    public static int cariTabel(String cari, String[] data2, String[] data3, String[] data4) {
        int j = 0;
        System.out.println(cari);
        System.out.println(data2[0]);
        System.out.println(data3[0]);
        System.out.println(data4[0]);
            if (cari.equals(data2[0])) {
                System.out.println("ooioo");
                j = 1;
            }else if (cari.equals(data3[0])) {
                System.out.println("eiei");    
                j = 2;
            }       
            else if (cari.equals(data4[0])) {
                System.out.println("aiaiai");
                j = 3;
            }            
        return j;
    }
}

