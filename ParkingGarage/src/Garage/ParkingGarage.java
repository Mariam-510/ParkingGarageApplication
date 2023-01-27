package Garage;

//Control Class
public class ParkingGarage implements IParkingGarage
{
    //Attributes that the class uses
    private ParkIn parkIn;
    private ParkOut parkOut;
    private VehicleCalculation vehicleCalculation;
    private SlotHandling slotHandling;
    private VehicleHandling vehicleHandling;
    private TotalIncome total;
    private Configuration configuration;
    private ISlotSelector slotselector;

    //Constructor to initialize attributes
    public ParkingGarage (int con)
    {
        total = TotalIncome.getInstance();
        slotHandling = SlotHandling.getInstance();
        vehicleHandling =VehicleHandling.getInstance();
        vehicleCalculation = new VehicleCalculation();
        //strategy pattern
        configuration = new Configuration(con);
        slotselector = configuration.setSelector(slotselector);

        parkIn = new ParkIn(slotselector);
        parkOut = new ParkOut();
    }

    //getter for all attributes
    public VehicleCalculation getVehicleCalculation()
    {
        return vehicleCalculation;
    }
    public ParkIn getParkIn ()
    {
        return parkIn;
    }
    public ParkOut getParkOut ()
    {
        return parkOut;
    }
    public SlotHandling getSlotHandling()
    {
        return slotHandling;
    }
    public VehicleHandling getVehicleHandling()
    {
        return vehicleHandling;
    }
    public TotalIncome getTotal ()
    {
        return total;
    }
    public Configuration getConfiguration()
    {
        return configuration;
    }
}
