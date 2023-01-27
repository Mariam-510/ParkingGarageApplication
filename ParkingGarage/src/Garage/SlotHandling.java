package Garage;
import java.util.Vector;

public class SlotHandling
{
    //Attributes that the class uses
    private int numberOfSlots;
    private Vector<Slot> allSlots;
    private Vector<Slot> availableSlots;

    //Apply singleton pattern
    private static SlotHandling instance = null;
    private SlotHandling ()
    {
        availableSlots = new Vector<Slot>();
        allSlots = new Vector<Slot>();
    }

    public static SlotHandling getInstance()
    {
        if (instance == null)
        {
            synchronized(SlotHandling.class)
            {
                if (instance == null)
                {
                    instance = new SlotHandling();
                }
            }
        }
        return instance;
    }

    //remove slot from array
    public void RemoveAvailableSlot (Slot s)
    {
        //remove slot
        for (int i = 0; i < availableSlots.size(); i++)
        {
            //if found the slot
            if (availableSlots.get(i).getId() == s.getId())
            {
                availableSlots.remove(i);
                for (int j=0;j<numberOfSlots;j++)
                {
                    if (allSlots.get(j).getId() == s.getId())
                    {
                        //change its availability to false
                        allSlots.get(j).setAvailability(false);
                        break;
                    }
                }
                break;
            }
        }
    }

    //add slot
    public void addAvailableSlot (Slot s)
    {
        //add slot at vector
        availableSlots.add(s);
        //change its availability to true
        for (int j=0;j<numberOfSlots;j++)
        {
            if (allSlots.get(j).getId() == s.getId())
            {
                //change its availability to true
                allSlots.get(j).setAvailability(true);
                break;
            }
        }
    }

    //set number of all slots at the start of program
    public void setNumberOfSlots (int num)
    {
        numberOfSlots = num;
    }

    //set slot in array at the start of program
    public void setSlot (Slot s)
    {
        availableSlots.add(s);
        allSlots.add(s);
    }

    //getter for attributes
    public Vector<Slot> getAvailableSlots ()
    {
        return availableSlots;
    }

    public int getNumberOfAvailableSlots ()
    {
        return availableSlots.size();
    }

    public Vector<Slot> getAllSlots ()
    {
        return allSlots;
    }

    public int getNumberOfSlots ()
    {
        return numberOfSlots;
    }


}
