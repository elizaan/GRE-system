package GRExamStyle;

import java.io.Serializable;

public class dataflow  implements Serializable{

    public String q, op1, op2, op3, op4;
    public int answer;

    dataflow(String text, String s2, String s3, String s4, String s5, int ans) {
        this.answer = ans;
        this.q = text;
        this.op1 = s2;
        this.op2 = s3;
        this.op3 = s4;
        this.op4 = s5;//To change body of generated methods, choose Tools | Templates.
    }

   dataflow() {
        q=new String();
        op1=new String();
        op2=new String();
        op3=new String();
        op4=new String();


   }
    //To change body of generated methods, choose Tools | Templates.



}
