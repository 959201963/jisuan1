import java.util.ArrayList;

/**
 * Created by acer-pc on 2017/4/17.
 */
public class Main {
    public static void main(String[] args) {
        int length=1000,i;
        createExpression expression = new createExpression();
        ArrayList<String> a1 = new ArrayList<String>();
        ArrayList<ArrayList<String>> a2=new ArrayList<ArrayList<String>>();
        Recurrence z = new Recurrence(a1);
        User u1=new User();
        String result,uAnswer;
        int y=0,m,k;

        for(i=0;i<length;i++) {
            a1 = expression.createExpression();
            //测试
            /*String aa="8 - ( 8 - 6 ) × ( 6 + 5 ) - 10";
            String []bb=aa.split(" ");
            for(int j=0;j<bb.length;j++)
            {
                a1.add(bb[j]);
            }*/
            result = z.answer(a1);

            //如果计算过程中出现分母为0时，重新创建表达式
            if(result.equals("FALSE")) {
                i--;
                continue;
            }


            expression.outPut(a1);
            a2.add(a1);
            //判断是否重复

            for(k=0;k<a2.size()-1;k++){
                for(m=0;m<a1.size();m++){
                    if(!a2.get(k).get(m).equals(a1.get(m)))
                        break;
                }
                if(m>=a1.size())
                    break;
            }
            if(k<a2.size()-1){
                i--;
                continue;
            }
            uAnswer=u1.userAnswer();
            if (uAnswer.compareTo("#") == 0) //输入# 退出答题
                break;


            if(uAnswer.compareTo(result)==0) {
                y++;
                System.out.println("right");
            }
            else {
                System.out.println("false");
                System.out.println("答案为:"+result);
            }

        }
        if(i==0)
        {
            System.out.println("Did not answer a question");
        }
        else
            System.out.println( "right :"+y+"        false:"+(i-y)+"     accuracy:"+y*1.0/i);
    }
}
