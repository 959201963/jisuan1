import sun.misc.GC;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by acer-pc on 2017/3/24.
 */
public class shuntingYardAlgorithm {
    ArrayList<String> a=new ArrayList<String>();


    shuntingYardAlgorithm(ArrayList<String> a) {
        this.a=a;
    }
    public String answer(ArrayList<String> a) {
        ArrayList<String> b=new ArrayList<String>();
        ArrayList<String> fb=new ArrayList<String>();

        Stack<String> number=new Stack<String>();
        Stack<String> mark=new Stack<String>();
        int j=0;

        for(int i=0;i<a.size();i++) {
            if (a.get(i).charAt(0)>='0'&&a.get(i).charAt(0)<='9'||(a.get(i).charAt(0)=='-'&&a.get(i).length()>1)) {
                number.push(a.get(i));

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
                    if(!mark.empty()) {


                        if (mark.peek().equals("×")) {
                            number.push(calculate(number.pop(), number.pop(), '×'));
                            mark.pop();
                        } else if (mark.peek().equals("÷")) {
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
                number.push(calculate(number.pop(), number.pop(), '÷'));
                mark.pop();
            }
        }

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
    /*public static void main(String[] args) {
        Scanner s=new Scanner(System.in);


        ArrayList<String> a1=new ArrayList<String>();
        String x;
        int i=0;
        String  result;
        //输入表达式
        while((x=s.next()).compareTo("=")!=0 )
        {
            a1.add(x);
        }

        shuntingYardAlgorithm z=new shuntingYardAlgorithm(a1);
        //调用函数计算
        result=z.answer(a1);


        System.out.println(result);

    }*/

}
