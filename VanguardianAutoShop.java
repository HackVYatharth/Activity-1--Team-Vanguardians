import java.util.*;
public class VanguardianAutoShop {
    public static void main(String[] args) {

        //To take user inputs
        Scanner sc = new Scanner(System.in);
        int ct = 0;

        //Welcoming to Our Auto Shop
        System.out.println();
        System.out.println("WELCOME TO THE VANGUARDIAN'S CAR SHOP");
        System.out.println();
        System.out.println("Enter Car Type that You Want to Buy!");
        String type = sc.next();
        
        //Validation of the car type entered
        if(!isValidType(type))
        {
            System.out.println("Invalid Car Type, Sorry! We Currently do not have the car type you entered.");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
            System.exit(0);
        }
        else if(type.equalsIgnoreCase("Sedan"))//Checks whether the required car type is sedan
        {
            System.out.println("Enter The No. of Sedans you want to enquire about: ");
            int en =sc.nextInt();
        
            //To  ensure that we can call more than one instance of the sedan class
            ct = en;
            while(en > 0){

                if(ct > en){
                    System.out.println("Enter the details of the next car:");
                }

                System.out.println("Enter the desired speed of the Sedan(in kmph): ");
                int speed = sc.nextInt();
                
                System.out.println("Enter the Required Color of the Sedan: ");
                String color = sc.next();
                
                System.out.println("Enter the Regular Price of the Sedan(in Rupees): ");
                double price = sc.nextDouble();

                //Validation of the price entered
                if(price < 500000)
               {
                System.out.println("We don't have Sedans in that price range.");
                System.out.println();
                System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
                System.out.println();
                return;
               }
               
               System.out.println("Enter the year of manufacturing, you want your Sedan to be(in YYYY):");
               int year = sc.nextInt();

               //Validation of the Year
               if(year < 2018 || year >2025)
               {
                System.out.println("Sedan is not available for the desired year of manufacturing.");
                System.out.println();
                System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
                System.out.println();
                return;
               }

               //Instances of Sedan Class
               Sedan sedan = new Sedan(speed, price, color, year);
               System.out.println("The Final Sales price of your favourite Sedan after discount is : Rs."+sedan.getSalePrice());
               System.out.println();
               sedan.SedanSuggestions(price);

               en = en-1;
            }
        }
        else
        {
            System.out.println("Enter The No. of SUV's you want to enquire about: ");
            int en =sc.nextInt();
            
            //To  ensure that we can call more than one instance of the sedan class
            ct = en;
            while(en > 0){
                
                if(ct > en){
                    System.out.println("Enter the details of the next car:");
                }

            System.out.println("Enter the desired speed of the SUV(in kmph):");
            int speed = sc.nextInt();
        
            System.out.println("Enter the Required Color of your SUV");
            String color = sc.next();
            
            System.out.println("Enter the Regular Price of the SUV(in Rupees):");
            double price = sc.nextDouble();
            
            //Validation for SUV price 
            if(price < 1000000)
            {
             System.out.println("Sorry! We don't have SUV's in that price range.");
             System.out.println();
             System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
             System.out.println();
             System.exit(0);
            }

            System.out.println("Enter the maximum weight you want your SUV to be(in Kg):");
            int weight = sc.nextInt();
            
            //Validation for weight
            if(weight < 500)
            {
                System.out.println("Sorry! We currently do not have any SUV's available in the desired weight.");
                System.out.println();
                System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
                System.out.println();
                return;
            }
            //Instance of SUV class
            SUV suv = new SUV(speed, price, color, weight);
            System.out.println("The Final Sales price of your favourite SUV after discount is : "+suv.getSalePrice());
            System.out.println();
            suv.SUVSuggestions(price);
            System.out.println();
            en=en-1;
        }
    }
        sc.close();
    }

    public static boolean isValidType(String type)
    {
        ArrayList<String> list = new ArrayList<>();
        list.add("Sedan");
        list.add("SUV");
        
        return list.contains(type);
    }
}
