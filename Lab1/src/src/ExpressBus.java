
public class ExpressBus extends Bus{

    ExpressBus(String VIN, String plateNO, String make, String model, int year)
    {
        super(VIN, plateNO, make, model, year);
    }
    public void displayTourBus()
    {
        System.out.println("The Vin Number is: "+ super.getVIN());
        System.out.println("The plate number Number is: "+ super.getPlateNO());
        System.out.println("The Express Bus make is: "+ super.getMake());
        System.out.println("The Express Bus model is: "+ super.getModel());
        System.out.println("The Express Bus year is: "+ super.getYear());
    }
}
