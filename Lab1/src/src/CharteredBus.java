
public class CharteredBus extends Bus{

    CharteredBus(String VIN, String plateNO, String make, String model, int year)
    {
        super(VIN, plateNO, make, model, year);
    }
    public void displayCharteredBus()
    {

        System.out.println("The Vin Number is: "+ super.getVIN());
        System.out.println("The plate number Number is: "+ super.getPlateNO());
        System.out.println("The Chartered Bus make is: "+ super.getMake());
        System.out.println("The Chartered Bus model is: "+ super.getModel());
        System.out.println("The Chartered Bus year is: "+ super.getYear());
    }
}
