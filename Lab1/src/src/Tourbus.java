
public class Tourbus extends Bus{

    Tourbus(String VIN, String plateNO, String make, String model, int year)
    {
        super(VIN, plateNO, make, model, year);
    }
    public void displayExpressBus()
    {
        System.out.println("The Vin Number is: "+ super.getVIN());
        System.out.println("The plate number Number is: "+ super.getPlateNO());
        System.out.println("The Tour Bus make is: "+ super.getMake());
        System.out.println("The Tour Bus model is: "+ super.getModel());
        System.out.println("The Tour Bus year is: "+ super.getYear());
    }
}
