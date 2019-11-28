
package checkdigitprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckDigitProgramming {

   
    public static void main(String[] args) {
        
        
        
        Scanner input = new Scanner (System.in);
        
        List<Integer> code = new ArrayList<>();
        
        System.out.println("Enter a 12 digit code");
        
        System.out.println("Enter Digits ");
        for (int i = 1; i < 13; i++) {
            System.out.print(i + ": ");
//            int digit = input.nextInt();
            try{
                int digit = input.nextInt();
                while(true){
                  if(digit>10 || digit<0){
                    System.out.println("out of bounds, try again");
                      System.out.print(i +": ");
                    digit=input.nextInt();
                }else{
                  code.add(digit);
                  break;
                }  
                }
            }catch (Exception e){
                System.out.println("Error: " +e);
                System.out.println("Exiting...");
                System.exit(0);
            }
        }
        
        int sumBlue = 0;
        for (int j = 0; j < 12; j+=2) {
            sumBlue+=code.get(j);
        }
        int sumRed = 0;
        for (int j = 1; j < 12; j+=2) {
            
            sumRed+=code.get(j);
        }
        sumRed*=3;
        
        sumRed+=sumBlue;
        
        int checkdigit = sumRed;
        while(checkdigit%10!=0){
            checkdigit++;
        }
        checkdigit/=10;
        
        code.add(checkdigit);
        
        for (int j = 0; j < code.size(); j++) {
            System.out.print(code.get(j) + " ");
        }
        System.out.println();
        System.out.println("(check digit = " +checkdigit+ ")");
    }
    
}
    
