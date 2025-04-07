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
    
    

    @Override
    public double getSalePrice()
    {
        return getRegularPrice() - manufacturerDiscount;
    }
}
    
