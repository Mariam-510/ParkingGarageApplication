package Garage;

import java.util.Vector;

public class VehicleHandling
{
    //Attributes that the class uses
    private int numberOfVehicles;
    private Vector<Vehicle> vehicle;

    //Apply singleton pattern
    private static VehicleHandling instance = null;
    private VehicleHandling()
    {
        numberOfVehicles=0;
        vehicle = new Vector<Vehicle>();
    }
    public static VehicleHandling getInstance()
    {
        if (instance == null)
        {
            synchronized(VehicleHandling.class)
            {
                if (instance == null)
                {
                    instance = new VehicleHandling();
                }
            }
        }
        return instance;
    }

    //getter list of vehicles
    public Vector<Vehicle> getVehicle ()
    {
        return vehicle;
    }

    //get number of vehicles
    public int getNumberOfVehicles ()
    {
        return numberOfVehicles;
    }

    //increase number of vehicles after park in
    public void increaseNumberOfVehicles ()
    {
        numberOfVehicles++;
    }

    //Add vehicle to list
    public void addVehicle (Vehicle v,Slot s)
    {
        //add vehicle
        vehicle.add(v);
        vehicle.get(numberOfVehicles).getCard().setSlot(s);
    }

}
