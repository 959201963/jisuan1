import sun.misc.GC;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by acer-pc on 2017/3/24.
 */
public class Recurrence {
    ArrayList<String> a=new ArrayList<String>();


    Recurrence(ArrayList<String> a) {
        this.a=a;
    }
    public String answer(ArrayList<String> a) {
        ArrayList<String> b=new ArrayList<String>();
        ArrayList<String> fb=new ArrayList<String>();

        Stack<String> number=new Stack<String>();
        Stack<String> mark=new Stack<String>();
        String zz;
        int j=0;

        for(int i=0;i<a.size();i++) {
            if (a.get(i).charAt(0)>='0'&&a.get(i).charAt(0)<='9'||(a.get(i).charAt(0)=='-'&&a.get(i).length()>1)) {
                number.push(a.get(i));
                if(!mark.empty()) {


                    if (mark.peek().equals("×")) {
                        number.push(calculate(number.pop(), number.pop(), '×'));
                        mark.pop();
                    } else if (mark.peek().equals("÷")) {
                        if(number.peek().equals("0"))
                            return "FALSE";
                        number.push(calculate(number.pop(), number.pop(), '÷'));
                        mark.pop();
                    }
                }

            }
            else {
                if(!mark.empty()){
                    if(mark.peek().equals("+")&&(a.get(i).equals("+")||a.get(i).equals("-"))) {
                        number.push(calculate(number.pop(), number.pop(), '+'));
                        mark.pop();
                    }
                    else if(mark.peek().equals("-")&&(a.get(i).equals("+")||a.get(i).equals("-"))) {
                        number.push(calculate(number.pop(), number.pop(), '-'));
                        mark.pop();
                    }
                    else if(mark.peek().equals("×")&&(a.get(i).compareTo("(")!=0) ){
                        number.push(calculate(number.pop(), number.pop(), '×'));
                        mark.pop();
                    }
                    else if(mark.peek().equals("÷")&&(a.get(i).compareTo("(")!=0)) {
                        if(number.peek().equals("0"))
                            return "FALSE";
                        number.push(calculate(number.pop(), number.pop(), '÷'));
                        mark.pop();
                    }

                }
                mark.push(a.get(i));



                if(a.get(i).charAt(0)==')') {
                    mark.pop();
                    while(mark.peek().compareTo("(")!=0) {
                        b.add(number.pop());
                        b.add(mark.pop());
                    }
                    b.add(number.pop());
                    mark.pop();
                    j=b.size();
                    while(j>0){
                        fb.add(b.get(--j));
                    }
                    number.push(answer(fb));

                    b.clear();
                    fb.clear();
                    //zz=mark.pop();
                    if(!mark.empty()) {


                        if (mark.peek().equals("×")) {
                            number.push(calculate(number.pop(), number.pop(), '×'));
                            mark.pop();
                        } else if (mark.peek().equals("÷")) {
                            if(number.peek().equals("0"))
                                return "FALSE";
                            number.push(calculate(number.pop(), number.pop(), '÷'));
                            mark.pop();
                        }
                    }


                }
            }
        }
        while(!mark.empty()) {
            if (mark.peek().equals("+")) {
                number.push(calculate(number.pop(), number.pop(), '+'));
                mark.pop();
            } else if (mark.peek().equals("-")) {
                number.push(calculate(number.pop(), number.pop(), '-'));
                mark.pop();
            } else if (mark.peek().equals("×")) {
                number.push(calculate(number.pop(), number.pop(), '×'));
                mark.pop();
            } else if (mark.peek().equals("÷")) {
                if(number.peek().equals("0"))
                    return "FALSE";
                number.push(calculate(number.pop(), number.pop(), '÷'));
                mark.pop();
            }
        }
        String []n1=number.peek().split("/");
        if(n1.length>1)
            if(n1[1].compareTo("1")==0)
                return n1[0];
        return number.pop();
    }
    String calculate(String b1,String a1,char operator){
        int x1,x2,y1,y2,z;
        if(a1.indexOf("/")<0)
            a1=a1+"/1";
        if(b1.indexOf("/")<0)
            b1=b1+"/1";

        String []stra=a1.split("/");
        String []strb=b1.split("/");
        x1=Integer.parseInt(stra[0]);
        y1=Integer.parseInt(stra[1]);
        x2=Integer.parseInt(strb[0]);
        y2=Integer.parseInt(strb[1]);

        if(operator=='+'){
            z=GCM(x1*y2+x2*y1,y1*y2);
            return (x1*y2+x2*y1)/z+"/"+y1*y2/z;
        }

        if(operator=='-'){
            z=GCM(x1*y2-x2*y1,y1*y2);
            return (x1*y2-x2*y1)/z+"/"+y1*y2/z;
        }

        if(operator=='×'){
            z= GCM(x1*x2,y1*y2);
            return (x1*x2)/z+"/"+(y1*y2)/z;
        }

        if(operator=='÷'){
            z=GCM(x1*y2,y1*x2);
            //乘上一个负的分数时要考虑
            if(x2<0) {
                x1 = x1*-1;
                x2 = x2*-1;
            }
            /*if((y1*x2)/z==1)
                return (x1*y2)/z+"";*/
            return (x1*y2)/z+"/"+(y1*x2)/z;
        }

        return "";
    }
    public static int GCM(int m,int n)//   求最大公约数
    {
        int r=1;
        m=Math.abs(m);
        n=Math.abs(n);
        while (r != 0)
        {
            r = m % n;
            m = n;
            n = r;
        }
        return m;
    }


}
