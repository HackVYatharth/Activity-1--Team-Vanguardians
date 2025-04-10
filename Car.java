class Car implements Saleable {
    protected int speed;
    protected double regularPrice;
    protected String color;

    public int getSpeed()
    {
        return speed;
    }
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }
    public void setRegularPrice(double regularPrice)
    {
        this.regularPrice = regularPrice;
    }

    public String getColor()
    {
        return color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    
    Car(int speed, double regularPrice, String color) 
    {
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }

    @Override
    public double getSalePrice() {
        return regularPrice;
    }
}

