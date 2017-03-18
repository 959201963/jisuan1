/**
 * Created by acer-pc on 2017/3/3.
 */
import java.util.Scanner;
import java.util.Random;
import java.lang.String.*;


public class jisuan {
    public static void main(String[] args) {
        int a[][]=new int[10][3];
        int a1[][]=new int[10][5];
        String b[]=new String[10];  // 每题的答案
        String b1[]=new String[10];//每次输入的答案
        char zz;
        int mark[]=new int[2];
        int x,j,i,k;
        int y=0;//计数
        Scanner s=new Scanner(System.in);
        for(i=0;i<10;i++)
        {
            if((int)(1+Math.random()*3)==1)//整数运算
            {
                a[i][0]=(int)(1+Math.random()*99);
                a[i][1]=(int)(1+Math.random()*4);
                a[i][2]=(int)(1+Math.random()*99);

                for(k=0;k<i;k++)
                {
                    if(a[i][0]==a[k][0]&&a[i][1]==a[k][1]&&a[i][2]==a[k][2])
                        break;
                    if((a[i][1]==1||a[i][1]==3)&&a[k][0]==a[i][2]&&a[k][2]==a[i][0])
                        break;
                }
                //
                if(k<i)
                {
                    i--;
                    continue;
                }

                switch(a[i][1])
                {
                    case 1:
                        System.out.println(a[i][0]+" + "+a[i][2]+"=");
                        b[i]=a[i][0]+a[i][2]+"";
                        break;
                    case 2:
                        System.out.println(a[i][0]+" - "+a[i][2]+"=");
                        b[i]=a[i][0]-a[i][2]+"";
                        break;
                    case 3:
                        System.out.println(a[i][0]+" * "+a[i][2]+"=");
                        b[i]=a[i][0]*a[i][2]+"";
                        break;
                    case 4:
                        x=GCM(a[i][0],a[i][2]);
                        System.out.println(a[i][0]+" ÷ "+a[i][2]+"=");
                        b[i]=a[i][0]/x+"/"+a[i][2]/x;
                        if(a[i][2]/x==1)
                        b[i]=a[i][0]/x+"";
                        break;

                }

            }
            else if((int)(1+Math.random()*3)==2) //真分数运算
            {
                a1[i][1]=(int)(2+Math.random()*9);
                a1[i][0]=(int)(1+Math.random()*(a1[i][1]-1));
                //x=GCM(a1[i][1],a1[i][0]);

                a1[i][4]=(int)(1+Math.random()*4);
                a1[i][3]=(int)(2+Math.random()*9);
                a1[i][2]=(int)(1+Math.random()*(a1[i][3]-1));
                for(k=0;k<i;k++)
                {
                    if(a1[i][0]==a1[k][0]&&a1[i][1]==a1[k][1]&&a1[i][2]==a1[k][2]&&a1[i][3]==a1[k][3]&&a1[i][4]==a1[k][4])
                        break;
                    if((a1[i][4]==1||a1[i][4]==3)&&a1[i][0]==a1[k][0]&&a1[i][1]==a1[k][1]&&a1[i][2]==a1[k][2]&&a1[i][3]==a1[k][3])
                        break;
                }
                //
                if(k<i)
                {
                    i--;
                    continue;
                }
                System.out.print(a1[i][0]+"/"+a1[i][1]);
                switch(a1[i][4])
                {
                    case 1:
                        System.out.print(" + ");
                        x=(GCM(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2],a1[i][1]*a1[i][3]));
                        b[i]=(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])/x+"/"+a1[i][1]*a1[i][3]/x;
                        if((a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])==0)
                            b[i]="0";
                        if(a1[i][1]*a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])/x+"";
                        break;
                    case 2:
                        System.out.print(" - ");
                        x=(GCM(a1[i][0]*a1[i][3]-a1[i][1]*a1[i][2],a1[i][1]*a1[i][3]));
                        b[i]=(a1[i][0]*a1[i][3]-a1[i][1]*a1[i][2])/x+"/"+a1[i][1]*a1[i][3]/x;
                        if((a1[i][0]*a1[i][3]-a1[i][1]*a1[i][2])==0)
                            b[i]="0";
                        if(a1[i][1]*a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][3]+a1[i][1]*a1[i][2])/x+"";
                        break;
                    case 3:
                        System.out.print(" * ");
                        x=(GCM(a1[i][0]*a1[i][2],a1[i][1]*a1[i][3]));
                        b[i]=(a1[i][0]*a1[i][2])/x+"/"+a1[i][1]*a1[i][3]/x;;
                        if(a1[i][1]*a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][2])/x+"";
                        break;
                    case 4:
                        System.out.print(" ÷ ");
                        x=(GCM(a1[i][0]*a1[i][3],a1[i][1]*a1[i][2]));
                        b[i]=(a1[i][0]*a1[i][3])/x+"/"+a1[i][1]*a1[i][2]/x;
                        if(a1[i][1]*a1[i][2]/x==1)
                            b[i]=(a1[i][0]*a1[i][3])/x+"";
                        break;

                }
               // x=GCM(a1[i][3],a1[i][2]);
                System.out.println(a1[i][2]+"/"+a1[i][3]+"=");

            }
            else //整数和分数运算
            {
                a1[i][0]=(int)(2+Math.random()*9);
                a1[i][1]=(int)(1+Math.random()*4);
                a1[i][3]=(int)(2+Math.random()*9);
                a1[i][2]=(int)(1+Math.random()*(a1[i][3]-1));
                for(k=0;k<i;k++)
                {
                    if(a1[i][0]==a1[k][0]&&a1[i][1]==a1[k][1]&&a1[i][2]==a1[k][2]&&a1[i][3]==a1[k][3])
                        break;
                    if((a1[i][1]==1||a1[i][1]==3)&&a1[i][0]==a1[k][0]&&a1[i][2]==a1[k][2]&&a1[i][3]==a1[k][3])
                        break;
                }
                //
                if(k<i)
                {
                    i--;
                    continue;
                }

                //x=GCM(a1[i][3],a1[i][2]);
                switch(a1[i][1])
                {
                    case 1:
                        System.out.println(a1[i][0]+" + "+a1[i][2]+"/"+a1[i][3]+"=");
                        x=GCM(a1[i][0]*a1[i][3]+a1[i][2],a1[i][3]);
                        b[i]=(a1[i][0]*a1[i][3]+a1[i][2])/x+"/"+a1[i][3]/x;
                        if(a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][3]+a1[i][2])/x+"";
                        break;
                    case 2:
                        System.out.println(a1[i][0]+" - "+a1[i][2]+"/"+a1[i][3]+"=");
                        x=GCM(a1[i][0]*a1[i][3]-a1[i][2],a1[i][3]);
                        b[i]=(a1[i][0]*a1[i][3]-a1[i][2])/x+"/"+a1[i][3]/x;
                        if(a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][3]-a1[i][2])/x+"";
                        break;
                    case 3:
                        System.out.println(a1[i][0]+" * "+a1[i][2]+"/"+a1[i][3]+"=");
                        x=GCM(a1[i][0]*a1[i][2],a1[i][3]);
                        b[i]=(a1[i][0]*a1[i][2])/x+"/"+a1[i][3]/x;
                        if(a1[i][3]/x==1)
                            b[i]=(a1[i][0]*a1[i][2])/x+"";
                        break;
                    case 4:
                        System.out.println(a1[i][0]+" ÷ "+a1[i][2]+"/"+a1[i][3]+"=");
                        x=GCM(a1[i][0]*a1[i][3],a1[i][2]);
                        b[i]=(a1[i][0]*a1[i][3])/x+"/"+a1[i][2]/x;
                        if(a1[i][2]/x==1)
                            b[i]=(a1[i][0]*a1[i][3])/x+"";

                        break;
                }

            }
            while(true)
            {
                System.out.print("输入答案（输入#退出答题）：");
                b1[i] = s.next();
                if (b1[i].compareTo("#") == 0) //输入# 退出答题
                    break;
                String[] str = b1[i].split("/");
                if (str.length > 1)
                    if (str[1].compareTo("0") == 0)
                    {
                        System.out.println("分母不能为0，重新输入");
                        continue;
                    }

                for (j = 0; j < b1[i].length(); j++)
                {
                    if (j == 0)
                    {
                        if (b1[i].charAt(0) != '-' && (b1[i].charAt(j) < '0' || b1[i].charAt(j) > '9'))
                            break;

                    }
                    else if ((b1[i].charAt(j) < '0' || b1[i].charAt(j) > '9') && (b1[i].charAt(j) != '/'))
                        break;


                }

                if(j==1&&b1[i].charAt(0)=='-')
                {
                    System.out.println("输入形式错误，重新输入");
                    continue;
                }
                if (j < b1[i].length())
                {
                    System.out.println("输入形式错误，重新输入");
                    continue;
                }
                break;
            }
            if (b1[i].compareTo("#") == 0) //输入# 退出答题
                break;


            if(b1[i].compareTo(b[i])==0)
            {
                y++;
                System.out.println("right");
            }
            else
            {
                System.out.println("false");
            }


        }
        if(i==0)
        {
            System.out.println("Did not answer a question");
        }
        else
        System.out.println( "right :"+y+"        false:"+(i-y)+"     accuracy:"+y*1.0/i);

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
