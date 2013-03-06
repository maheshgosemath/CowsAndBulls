/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cowsandbulls;

/**
 *
 * @author MahiRaj Gosemath
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CowsAndBulls {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws java.lang.Exception {
        // TODO code application logic here
        int cowsCount=0, bullsCount=0;
        boolean won=false;
        String match;
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        List number=new ArrayList();
        System.out.println("Generating number.");
        generate(number);
        System.out.println("Guess the generated number.");
        for(int i=0;i<10&&!won;i++)
        {
            System.out.println("Enter number. You have "+(10-i)+" chances left.");
            int guess=Integer.parseInt(input.readLine());
            match=breakAndCheck(guess, number);
            if(match!=null)
            {
                cowsCount=Integer.parseInt(match.split(" ")[0]);
                bullsCount=Integer.parseInt(match.split(" ")[1]);
                if(bullsCount==3)
                {
                    System.out.println("You Won. The generated number is "+guess);
                    won=true;        
                }
                else
                {
                    System.out.println(cowsCount+" Cows "+bullsCount+" Bulls");
                }
            }
            else
            {
                System.out.println("No Match Found.");
            }
        }
        System.out.println("Number generated is "+number.get(0)+number.get(1)+number.get(2));
    }
    public static void generate(List number)
    {
        Random random=new Random();
        for(int i=0;i<3;i++){
            int num=random.nextInt(9)+1;
            number.add(num);
        }
    }
    public static String breakAndCheck(int guess, List number)
    {
        int cows=0, bulls=0, count=2;
        while(guess!=0)
        {
            int temp=guess%10;
            if(number.contains(temp))
            {
                if(number.indexOf(temp)==count)
                {
                    bulls++;
                }
                else
                {
                    cows++;
                }
            }
            guess=guess/10;
            count--;
        }
        if(cows==0&&bulls==0) {
            return null;
        }
        else {
            return (cows+" "+bulls);
        }
    }
}
