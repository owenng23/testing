import java.util.Scanner;
public class KevFinance
{
   public static void main (String[] args)
   {
      Scanner input = new Scanner(System.in);
      //store variables for later usage with a define data type (int, double, etc) and putting it outside the loop so these defined data type variables can be used in any lines.
      int options,years,months,start,index; 
      double invest,interest,final_Amount,gain,annual_income,MYRtax,MYRnet_income,Taxrate,Month_stay,NonMYRtax_1,NonMYRtax_2,NonMYRnet_income_1,NonMYRnet_income_2;
      MYRtax = 0; //A variable with a value to be initiate for the result value information after finish calculation
      MYRnet_income = 0;
      char resident;
      String record,result;
      int historyCount = 0;//a historyCount used to check the amount of times the user had inputted into either "Investment Calculator" or "Income Tax Calculator" function.
      String[] history = new String[5]; //An array list defined to be used for tracking history, the user inputted up to 5 line history information.
      
      while(true)// Initializing the while loop with the true value to run infinitely until the user exit.
      {
        //Main Menu Display with four options for the user input
        System.out.println("========================");
        System.out.println("|     MONEY SYSTEM     |");
        System.out.println("========================");
        System.out.println("1. Investment Calculator");
        System.out.println("2. Income tax Calculator");
        System.out.println("3. Display History");
        System.out.println("4. Exit");
        System.out.print("Option:");
        options = input.nextInt();
        
        if (options == 1)
        {
            //Investment Calculator Display and Calculation
            //A space gap in between lines to make the display not clump together (applys to all that had "" display)
            System.out.println("");
            System.out.println("---------------------");
            System.out.println("INVESTMENT CALCULATOR");
            System.out.println("---------------------");
            
            System.out.print("Enter the amount to invest:");
            invest = input.nextDouble();
            System.out.print("Enter annual interest rate (in %):");
            interest = input.nextDouble();
            System.out.print("Years to invest:");
            years = input.nextInt();
            //variable for calculating the final amount and gain from investment
            final_Amount = invest * Math.pow(1 + (interest/100),years);
            gain = final_Amount - invest;
            
            if (invest < 0 || interest < 0 || years < 0) //Using if statement to check for errors.
            {
               System.out.println("Error: Invalid input.");
               System.out.println(""); 
            }
            
            if (invest >= 0 && interest >= 0 && years >=0)
            {
               //Summary result after user input and finish calculation
               System.out.println("");
               System.out.println("SUMMARY");
               System.out.println("-------");
               System.out.printf("%-14s:%12.2f\n","Initial Amount",invest); //Initializing printf to format the summary result information much cleaner and readable
               System.out.printf("%-14s:%12.2f\n","Final Amount",final_Amount);
               System.out.printf("%-14s:%12.2f\n","Gain",gain);
               System.out.println("");
               
               /*record used as a placeholder for the string format into the result, 
               and the uses of String.format is to be able to have a variable with the format system
               so that the money value will be in 2 decimal place.*/
               record = ("%-6s: %.2f rm, %.2f %% and %d years, it will result %.2f rm gain");
               result = String.format(record,"INVEST",invest,interest,years,gain);
               
               // Saving result into history
               history[historyCount % 5] = result; //Utilising modular(%) for the historyCount to determine when user inputted this record.
               historyCount++;//Adding the historyCount by one from the one user inputted
            }
        }
        
        else if (options == 2)
        {
           //Income Tax Calculator Display and Calculation
           System.out.println("");
           System.out.println("---------------------");
           System.out.println("INCOME TAX CALCULATOR");
           System.out.println("---------------------");
           System.out.print("Enter your annual income:");
           annual_income = input.nextDouble();
           input.nextLine();//a dummy input.nextLine() system to clear the buffer of input.nextDouble()
           System.out.print("Are you a Malaysia resident? (Y/N):");
           //Utilizing toUpperCase() to ensure the user input works if they inputted in a smaller case letter than upper case.
           /*Utilizing charAt(0) so that java will scan and store the first character of the user input and determine if it satisfies the if statement
           in case of user inputting more than one character like "no" */
           resident = input.nextLine().toUpperCase().charAt(0);
           
           if (resident == 'Y')
           {
              /*Using if and else if statement to calculate the tax for Malaysian resident 
              with different tax percentage amount between the range like RM 0 to RM 5000 and RM 5000.01 to RM 35000.*/
              if (annual_income < 0)//Error checking if the user inputted a negative number.
              {
                  System.out.println("ERROR: Invalid Income.");
                  System.out.println("");
              }
              
              else
              {
              //Tax and Net Income calculation result for Malaysian Resident
                 if (annual_income >= 0 && annual_income <= 5000)
                 {
                     MYRtax = annual_income * 0;
                     MYRnet_income = annual_income - MYRtax;

                 }
                 
                 else if (annual_income > 5000 && annual_income <= 35000)
                 {
                     MYRtax = 5000 * 0 + (annual_income - 5000) * 0.015;
                     MYRnet_income = annual_income - MYRtax;
                     
                 }
                 
                 else if (annual_income > 35000 && annual_income <= 72000)
                 {
                     MYRtax = 5000 * 0 + 30000 * 0.015 + (annual_income - 35000) * 0.07;
                     MYRnet_income = annual_income - MYRtax; 
                     
                 }
                 
                 else if (annual_income > 72000 && annual_income <= 200000)
                 {
                     MYRtax = 5000 * 0 + 30000 * 0.015 + 37000 * 0.07 + (annual_income - 72000) * 0.245;
                     MYRnet_income = annual_income - MYRtax;
                
                 }
                 
                 else if (annual_income > 200000 && annual_income <= 450000)
                 {
                     MYRtax = 5000 * 0 + 30000 * 0.015 + 37000 * 0.07 + 128000 * 0.245 + (annual_income - 200000) * 0.29;
                     MYRnet_income = annual_income - MYRtax;
                 }
                 
                 else if (annual_income > 450000)
                 {
                     MYRtax = 5000 * 0 + 30000 * 0.015 + 37000 * 0.07 + 128000 * 0.245 + 250000 * 0.29 + (annual_income - 450000) * 0.355;
                     MYRnet_income = annual_income - MYRtax; 
                     
                 }
                 
                 //Summary result after user input and finish calculation
                 System.out.println(""); 
                 System.out.println("SUMMARY");
                 System.out.println("-------");
                 System.out.printf("%-13s:%10.2f rm\n","Income",annual_income);
                 System.out.printf("%-13s:%10.2f rm\n","Tax",MYRtax);
                 System.out.printf("%-13s:%10.2f rm\n","Net Income",MYRnet_income);
                 System.out.println("");
                 
                 /*record used as a placeholder for the string format into the result, 
                 and the uses of String.format is to be able to have a variable with the format system
                 so that the money value will be in 2 decimal place.*/
                 record = ("%-6s: Malaysian with %.2f rm will result %.2f rm tax");
                 result = String.format(record,"TAX",annual_income,MYRtax);
                 
                 // Saving result into history
                 history[historyCount % 5] = result; //Utilising modular(%) for the historyCount to determine when user inputted this record.
                 historyCount++;//Adding the historyCount by one from the one user inputted
              }
          }
         else if (resident == 'N')
           {
             System.out.print("Number of months stayed in Malaysia:");
             months = input.nextInt();
             //Calculation variable value for Non-Malaysian resident  
             Taxrate = annual_income * 0.2875;
             Month_stay = 50 * months;
             NonMYRtax_1 = Taxrate + Month_stay;
             NonMYRtax_2 = 0;
             NonMYRnet_income_1 = annual_income - NonMYRtax_1;
             NonMYRnet_income_2 = annual_income - NonMYRtax_2;
             
               if (months >= 0 && months <= 12)
               {
                  if (annual_income > NonMYRtax_1)
                  {
                     //Summary result after user input and finish calculation
                     System.out.println("");
                     System.out.println("SUMMARY");
                     System.out.println("-------");
                     System.out.printf("%-13s:%10.2f rm\n","Income",annual_income);
                     System.out.printf("%-13s:%10.2f rm\n","Tax",NonMYRtax_1);
                     System.out.printf("%-13s:%10.2f rm\n","Net Income",NonMYRnet_income_1);
                     System.out.println("");
                     
                     /*record used as a placeholder for the string format into the result, 
                     and the uses of String.format is to be able to have a variable with the format system
                     so that the money value will be in 2 decimal place.*/
                     record = ("%-6s: Non-Malaysian with %.2f rm and %d months will result %.2f rm tax");
                     result = String.format(record,"TAX",annual_income,months,NonMYRtax_1);
                     
                     // Saving result into history
                     history[historyCount % 5] = result; //Utilising modular(%) for the historyCount to determine when user inputted this record.
                     historyCount++;//Adding the historyCount by one from the user inputted
                  }  
                  
                  else if (annual_income < NonMYRtax_1)
                  {
                     //Summary result after user input and finish calculation
                     System.out.println("");
                     System.out.println("SUMMARY");
                     System.out.println("-------");
                     System.out.printf("%-13s:%10.2f rm\n","Income",annual_income);
                     System.out.printf("%-13s:%10.2f rm\n","Tax",NonMYRtax_2);
                     System.out.printf("%-13s:%10.2f rm\n","Net Income",NonMYRnet_income_2);
                     System.out.println("");
                       
                     /*record used as a placeholder for the string format into the result, 
                     and the uses of String.format is to be able to have a variable with the format system
                     so that the money value will be in 2 decimal place.*/
                     record = ("%-6s: Non-Malaysian with %.2f rm and %d months will result %.2f rm tax");
                     result = String.format(record,"TAX",annual_income,months,NonMYRtax_2);
                     
                     // Saving result into history
                     history[historyCount % 5] = result; //Utilising modular(%) for the historyCount to determine when user inputted this record.
                     historyCount++;//Adding the historyCount by one from the one user inputted
                  }
                  
                  else if (annual_income < 0)//Error checking
                  {
                     System.out.println("ERROR: Invalid Income.");
                     System.out.println("");
                  }
               }
               
               else if (months < 0 || months > 12)//Error checking
               {
                  System.out.println("ERROR: Invalid months.");
                  System.out.println("");
               }
           }
           
         if (resident != 'Y' && resident != 'N')// Error checking if the user enter something other than y or n.
           {
               System.out.println("ERROR Invalid input.");
               System.out.println("");
           }
           
        }
        
        else if (options == 3)
        {
            System.out.println("--------");
            System.out.println("HISTORY");
            System.out.println("--------");
            
            if (historyCount == 0)//if the user haven't inputted anything yet for the history information
            {
               System.out.println("No history at the moment.");
               System.out.println("");
            }
            
            else if (historyCount > 0)
            {
               System.out.println("INDEX   TYPE");
               System.out.println("-----------------------------------------------------");
               /*Utilising Math.min in order for the history array to only hold up to and show 5 history information and no more than that, 
               if more than 5 then the oldest will be deleted and include the latest.*/
               int count = Math.min(historyCount, 5); 
               for (int i = 0; i < count; i++) //Using for loop to loop for a certain amount of times before ending it
               {
               /*the index function where "historyCount - 1" would position the most recent "result", 
               the -i to move backwards from 5 to 1 instead of the other way round, and the modular(%) 5 
               is to wrap around the 5 history information slots correctly.*/
                  index = (historyCount - 1 - i) % 5;  
                  System.out.println((historyCount - i) + "       " + history[index]);
               }
               System.out.println("");
            }
        }

        else if (options == 4)
        {
            System.out.println("");
            System.out.println("Thank you for using KevFinance.");
            break; //using break statement to break the loop
        }
        
        else //Error checking if the user type any other number options than the presented ones
        {
            System.out.println("Error try again.");
        }    
      } 
   }
}
