class Sedan extends Car {
    int year;
    double manufacturerDiscount;

    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year = year;
    }
    
    Sedan(int speed, double regularPrice, String color, int year) 
    {
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = 0.0;

        double price = getRegularPrice();

        if(price > 1500000 || year < 2023)
        {
            this.manufacturerDiscount = price * 0.15;
        }
        else{
             this.manufacturerDiscount = price * 0.10;
        }
    }

    public void SedanSuggestions(double price){

        if(price <= 1500000)
        {
            System.out.println("These are some sedans you can buy in the given range(5-15 lakh) -");
            System.out.println("1. Maruti Suzuki Dzire - Rs.6.5 - Rs.9.5 Lakh");
            System.out.println("2. Honda Amaze - Rs.7 - Rs.10.5 Lakh");
            System.out.println("3. Volkswagen Virtus - Rs.11.5 - Rs.18.5 Lakh(base variant fits here)");
            System.out.println("4. Skoda Slavia - Rs.11.5 - Rs.19 Lakh(base variants fits here)");
            System.out.println("5. Tata Tigor - Rs.6.5 - Rs.9 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else if(price > 1500000 && price <= 3000000)
        {
            System.out.println("These are some sedans you can buy in the given range(15-30 lakh) -");
            System.out.println("1. Hyundai Elantra - Rs.18 - Rs.21 Lakh");
            System.out.println("2. Honda City Hybrid - Rs.19 - Rs.21 Lakh");
            System.out.println("3. Toyota Camry(Hybrid) - Rs.25 - Rs.30 Lakh");
            System.out.println("4. Skoda Octavia - Rs.28 - Rs.30 Lakh");
            System.out.println("5. Volkswagen Virtus/Skoda Slavia(top variants)");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else if(price > 3000000 && price <= 4500000)
        {
            System.out.println("These are some sedans you can buy in the given range(30-45 lakh) -");
            System.out.println("1. Audi A4 - Rs.45 - Rs.52 Lakh(lower variants might dip under 45 lakhs after discounts)");
            System.out.println("2. BMW 2 Series Gran Coupe - Rs.43 - Rs.47 Lakh");
            System.out.println("3. Mercedes-Benz A-Class Limousine - Rs.45 - Rs.50 Lakh(lower variants recommeded)");
            System.out.println("4. Skoda Superb - Rs.35 - Rs.40 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else if(price > 4500000 && price <= 6000000)
        {
            System.out.println("These are some sedans you can buy in the given range(45-60 lakh) -");
            System.out.println("1. BMW 3 Series - Rs.50 - Rs.60 Lakh");
            System.out.println("2. Mercedes-Benz C-Class - Rs.57 - Rs.65 Lakh");
            System.out.println("3. Audi A4(top variants)");
            System.out.println("4. Volvo S60 - Rs.48 - Rs.56 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else{
            System.out.println("These are some sedans you can buy in the given range(Above 60 lakh) -");
            System.out.println("1. BMW 5 Series - Rs.70 - Rs.85 Lakh");
            System.out.println("2. Audi A6 - Rs.70 - Rs.85 Lakh");
            System.out.println("3. Mercedes-Benz E-Class - Rs.75 - Rs.95 Lakh");
            System.out.println("4. Volvo S90 - Rs.68 - Rs.80 Lakh");
            System.out.println("5. Jaguar XF - Rs.72 - Rs.85 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
    }
    
    

    @Override
    public double getSalePrice()
    {
        return getRegularPrice() - manufacturerDiscount;
    }
}
    
