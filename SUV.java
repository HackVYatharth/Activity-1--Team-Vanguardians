class SUV extends Car {
    int weight;

    public int getWeight()
    {
        return weight;
    }
    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    SUV(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }
    public void SUVSuggestions(double price){
        if(price <= 2500000)
        {
            System.out.println("These are some SUV's you can buy in the given range(10-25 lakh) -");
            System.out.println("1. Tata Nexon - Rs.9 - Rs.15.5 Lakh");
            System.out.println("2. Hyundai Creta - Rs.11 - Rs.20 Lakh");
            System.out.println("3. Kia Seltos - Rs.11 - Rs.20 Lakh");
            System.out.println("4. Maruti Grand Vitara - Rs.11 - Rs.20 Lakh");
            System.out.println("5. Mahindra XUV700 - Rs.14 - Rs.25 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else if(price > 2500000 && price<=4000000)
        {
            System.out.println("These are some SUV's you can buy in the given range(25-40 lakh) -");
            System.out.println("1. Tata Harrier/Safari - Rs.20 - Rs.30 Lakh");
            System.out.println("2. Hyundai Tucson - Rs.29 - Rs.36 Lakh");
            System.out.println("3. Toyota Fortuner - Rs.35 - Rs.50 Lakh(Base Variant)");
            System.out.println("4. MG Gloster - Rs.32 - Rs.40 Lakh");
            System.out.println("5. Skoda Kodiaq - Rs.38 - Rs.42 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else if(price > 4000000 && price <=5500000)
        {
            System.out.println("These are some SUV's you can buy in the given range(40-55 lakh) -");
            System.out.println("1. BMW X1 - Rs.49 - Rs.53 Lakh");
            System.out.println("2. Mercedes-Benz GLA - Rs.50 - Rs.55 Lakh");
            System.out.println("3. Audi Q3 - Rs.48 - Rs.55 Lakh");
            System.out.println("4. Toyota Fortuner Legender/GR-S - Rs.45 - Rs.55 Lakh");
            System.out.println("5. Volvo XC40/XC40 Recharge(EV) - Rs.45 - Rs.55 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else if(price>5500000 && price <7000000)
        {
            System.out.println("These are some SUV's you can buy in the given range(55-70 lakh) -");
            System.out.println("1. Audi Q5 - Rs.62 - Rs.68 Lakh");
            System.out.println("2. BMW X3 - Rs.65 - Rs.72 Lakh");
            System.out.println("3. Mercedes-Benz GLC - Rs.68 - Rs.75 Lakh");
            System.out.println("4. Volvo XC60 - Rs.66 - Rs.72 Lakh");
            System.out.println("5. Lexus NX350h - Rs.68 - Rs.75 Lakh");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
        else{
            System.out.println("These are some SUV's you can buy in the given range(above 70 lakh) -");
            System.out.println("1. Audi Q7/Q8 - Rs.90 lakh - Rs.1.3 Cr.");
            System.out.println("2. BMW X5 - Rs.95 lakh - Rs.1.2 Cr.");
            System.out.println("3. Mercedes-Benz GLE - Rs.95 lakh - Rs.1.1 Cr");
            System.out.println("4. Jaguar F-Pace - Rs.80 lakh - Rs.1 Cr.");
            System.out.println("5. Lexus RX500h - Rs.95 lakh - Rs.1 Cr.");
            System.out.println();
            System.out.println("Thank You for Visiting Vanguardian Auto Shop!");
            System.out.println();
        }
    }

    @Override
    public double getSalePrice() {
        if (weight > 2000) {
            return getRegularPrice() * 0.9; // 10% discount
        } else {
            return getRegularPrice() * 0.8; // 20% discount
        }
    }
}
