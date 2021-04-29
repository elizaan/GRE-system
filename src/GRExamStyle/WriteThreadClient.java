package GRExamStyle;

import util.NetworkUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil nc;
    String name;

    public WriteThreadClient(NetworkUtil nc, String name) {
        this.nc = nc;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        FileReader f=null;
        try {

            String filename=(String)nc.read()+".txt";
            System.out.println(filename);
            f = new FileReader(filename);

            char[] buff = new char[1000];
            int size = f.read(buff);
            String full=new String(buff,0,size);
            System.out.println(full);
            System.out.println(nc);
            nc.write(full);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(WriteThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WriteThreadClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                f.close();
            } catch (IOException ex) {
                Logger.getLogger(WriteThreadClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
