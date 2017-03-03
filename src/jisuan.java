/**
 * Created by acer-pc on 2017/3/3.
 */
import java.util.Random;
import java.util.Scanner;
public class jisuan {
    public static void main(String[] args) {
        int a[][]=new int[10][3];
        int a1[][]=new int[10][5];
        String b[]=new String[10];
        String b1[]=new String[10];
        int mark[]=new int[2];
        int x;
        int y=0;//计数
        Scanner s=new Scanner(System.in);
        for(int i=0;i<10;i++)
        {
            if((int)(1+Math.random()*2)==1)
            {
                a[i][0]=(int)(1+Math.random()*99);
                a[i][1]=(int)(1+Math.random()*4);
                a[i][2]=(int)(1+Math.random()*99);

                switch(a[i][1])
                {
                    case 1:
                        System.out.println(a[i][0]+"+"+a[i][2]+"=");
                        b[i]=a[i][0]+a[i][2]+"";
                        break;
                    case 2:
                        System.out.println(a[i][0]+"-"+a[i][2]+"=");
                        b[i]=a[i][0]-a[i][2]+"";
                        break;
                    case 3:
                        System.out.println(a[i][0]+"*"+a[i][2]+"=");
                        b[i]=a[i][0]*a[i][2]+"";
                        break;
                    case 4:
                        x=GCM(a[i][0],a[i][2]);
                        System.out.println(a[i][0]+"/"+a[i][2]+"=");
                        b[i]=a[i][0]/x+"/"+a[i][2]/x;
                        break;
                }
            }
            else
            {
                a1[i][1]=(int)(2+Math.random()*9);
                a1[i][0]=(int)(1+Math.random()*(a1[i][1]-1));
                x=GCM(a1[i][1],a1[i][0]);
                System.out.print(a1[i][0]/x+"/"+a1[i][1]/x);
                a1[i][4]=(int)(1+Math.random()*4);
                a1[i][3]=(int)(2+Math.random()*9);
                a1[i][2]=(int)(1+Math.random()*(a1[i][3]-1));

                switch(a1[i][4])
                {
                    case 1:
                        System.out.print("+");
                        x=(GCM(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2],a1[i][1]*a1[i][3]));
                        b[i]=(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])/x+"/"+a1[i][1]*a1[i][3]/x;
                        if((a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])==0)
                            b[i]="0";
                        if(a1[i][1]*a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])/x+"";
                        break;
                    case 2:
                        System.out.print("-");
                        x=(GCM(a1[i][0]*a1[i][3]-a1[i][1]*a1[i][2],a1[i][1]*a1[i][3]));
                        b[i]=(a1[i][0]*a1[i][3]-a1[i][1]*a1[i][2])/x+"/"+a1[i][1]*a1[i][3]/x;
                        if((a1[i][0]*a1[i][3]-a1[i][1]*a1[i][2])==0)
                            b[i]="0";
                        if(a1[i][1]*a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])/x+"";
                        break;
                    case 3:
                        System.out.print("*");
                        x=(GCM(a1[i][0]*a1[i][2],a1[i][1]*a1[i][3]));
                        b[i]=(a1[i][0]*a1[i][2])/x+"/"+a1[i][1]*a1[i][3]/x;;
                        if(a1[i][1]*a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][2])/x+"";
                        break;
                    case 4:
                        System.out.print("/");
                        x=(GCM(a1[i][0]*a1[i][3],a1[i][1]*a1[i][2]));
                        b[i]=(a1[i][0]*a1[i][3])/x+"/"+a1[i][1]*a1[i][2]/x;
                        if(a1[i][1]*a1[i][2]/x==1)
                            b[i]=(a1[i][0]*a1[i][3])/x+"";
                        break;

                }
                x=GCM(a1[i][3],a1[i][2]);
                System.out.println(a1[i][2]/x+"/"+a1[i][3]/x+"=");
            }
            b1[i]=s.next();
            if(b1[i].compareTo(b[i])==0)
            {
                y++;
                System.out.println("true");
            }
            else
            {
                System.out.println("false");
            }


        }
        System.out.println( "true :"+y+"        false:"+(10-y)+"     accuracy:"+y*1.0/10);

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
