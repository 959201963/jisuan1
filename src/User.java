/**
 * Created by acer-pc on 2017/4/17.
 */
import java.util.Scanner;
public class User {
    public String userAnswer()
    {
        Scanner s=new Scanner(System.in);
        String b1;
        int j;
        while(true)
        {
            System.out.print("输入答案（输入#退出答题）：");
            b1 = s.next();
            if (b1.compareTo("#") == 0) //输入# 退出答题
                break;
            String[] str = b1.split("/");
            if (str.length > 1)
                if (str[1].compareTo("0") == 0)
                {
                    System.out.println("分母不能为0，重新输入");
                    continue;
                }

            for (j = 0; j < b1.length(); j++)
            {
                if (j == 0)
                {
                    if (b1.charAt(0) != '-' && (b1.charAt(j) < '0' || b1.charAt(j) > '9'))
                        break;

                }
                else if ((b1.charAt(j) < '0' || b1.charAt(j) > '9') && (b1.charAt(j) != '/'))
                    break;


            }

            if(j==1&&b1.charAt(0)=='-')
            {
                System.out.println("输入形式错误，重新输入");
                continue;
            }
            if (j < b1.length())
            {
                System.out.println("输入形式错误，重新输入");
                continue;
            }
            break;
        }

        return b1;
    }
}
