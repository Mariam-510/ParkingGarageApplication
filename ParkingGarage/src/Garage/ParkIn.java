package Garage;
import java.util.Scanner;

public class ParkIn
{
    //Attributes that the class uses
    private ISlotSelector slotselector;
    private SlotHandling slotHandling;
    private VehicleHandling vehicleHandling;

    //Constructor to initialize attributes
    public ParkIn (ISlotSelector slotselector)
    {
        this.slotselector = slotselector;
        slotHandling = SlotHandling.getInstance();
        vehicleHandling =VehicleHandling.getInstance();
    }

    //park in function
    public Vehicle park_in (Vehicle v)
    {
        //Pick slot for this vehicle
        Slot s;
        s = slotselector.selectSlot(slotHandling.getAvailableSlots(),v);

        //Check if slotselector found slot or not
        if (s.getWidth()!=-1 && s.getDepth()!=-1)
        {
            //Remove slot from array of available slots
            slotHandling.RemoveAvailableSlot(s);
            //Add vehicle to array
            vehicleHandling.addVehicle(v,s);
            //get last vehicle to set new information to its card
            Vehicle vec = new Vehicle(vehicleHandling.getVehicle().get(vehicleHandling.getNumberOfVehicles()));
            //Set time in to new vehicle
            vec.getCard().getTime().setTimeIn();
            //Increase number Of vehicles
            vehicleHandling.increaseNumberOfVehicles();
            return vec;
        }
        return new Vehicle();
    }
}
