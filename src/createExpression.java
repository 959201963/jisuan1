import com.sun.org.apache.regexp.internal.RE;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
/**
 * Created by acer-pc on 2017/4/13.
 */
public class createExpression {

    public ArrayList<String> createExpression() {
        int length=5;
        int x,y;
        int z=0;//几个左括号
        ArrayList<String> a=new ArrayList<String>();

        for(int i=0;i<length;i++)
        {
            x=(int)(Math.random()*100+1);
            y=(int)(Math.random()*10+1);



            //左括号出现概率
            if((int)(Math.random()*3)==0) {
                a.add("(");
                a.add(digitalProcessing(x,y));
                z++;
            }
            else if((int)(Math.random()*2)==1&&z>0){
                a.add(digitalProcessing(x,y));
                a.add(")");
                z--;
            }
            else
                a.add(digitalProcessing(x,y));

            switch((int)(Math.random()*4)) {
                case 0:
                    a.add("+");
                    break;
                case 1:
                    a.add("-");
                    break;
                case 2:
                    a.add("×");
                    break;
                case 3:
                    a.add("÷");
                    break;
            }



        }
        x=(int)(Math.random()*100);
        y=(int)(Math.random()*10+1);
        a.add(digitalProcessing(x,y));
        for(int i=0;i<z;i++){
            a.add(")");
        }

        return a;
    }
    public void outPut(ArrayList<String> a){
        for(int i=0;i<a.size();i++){
            System.out.print(a.get(i)+" ");
        }
        System.out.println("=");
    }
    public String digitalProcessing(int x,int y){
        int z;
        z=Recurrence.GCM(x,y);
        if(y==1||y/z==1)
            return x+"";



        return x/z+"/"+y/z;
    }


}
