package GRExamStyle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import util.NetworkUtil;

import javax.swing.plaf.LabelUI;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Server {

    private ServerSocket serverSocket;
    public int i = 1;

    public static final String INFO_FILE = "regsave.txt";
    public static final String INPUT_FILE_NAME = "questions.txt";
    public static final String OTHER_INPUT_FILE_NAME = "engques.txt";

    public static int interval;
    public static int delay;
    public static int period;

    static Timer timer;

    public Hashtable<String, NetworkUtil> table;

    Server() {
        table = new Hashtable<>();
        try {
            serverSocket = new ServerSocket(3333);
            new WriteThreadServer(table, "localhost");
            while (true) {
                dataflow a = new dataflow();
                Socket clientSocket = serverSocket.accept();
                serve(clientSocket);
            }
        } catch (Exception e) {
            System.out.println("Server starts:" + e);
        }
    }


    /*public static int time()
    {

        delay = 1000;
        period = 1000;
        timer = new Timer();
        interval = 30;

        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {
               // System.out.println(setInterval());

                if (interval == 1)
                    timer.cancel();
               // return --interval;

            }
        }, delay, period);

        return --interval;
    }*/





    public void serve(Socket clientSocket) {
        NetworkUtil nc = new NetworkUtil(clientSocket);
        System.out.println(nc);
        String clientName = (String) nc.read();
        table.put(clientName, nc);
        new WriteThreadClient(nc,clientName);
        new ReadThread(nc);
    }

    public static void main(String args[])
    {
        Server server = new Server();


    }


}

