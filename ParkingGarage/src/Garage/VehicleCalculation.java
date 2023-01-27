package Garage;

public class VehicleCalculation
{
    //Number of vehicles in garage now
    public int calculateNumberOfVehicles (SlotHandling sh)
    {
        return (sh.getNumberOfSlots()-sh.getNumberOfAvailableSlots());
    }
}
