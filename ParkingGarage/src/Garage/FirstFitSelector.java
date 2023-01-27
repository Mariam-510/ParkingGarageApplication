package Garage;
import java.util.Vector;

public class FirstFitSelector implements ISlotSelector
{
    //override function
    //the class implements the body of this function to find first fit slot
    public Slot selectSlot (Vector<Slot> availableSlots, Vehicle v)
    {
        Slot s = new Slot (-1,-1);
        for (int i = 0; i < availableSlots.size(); i++)
        {
            if (availableSlots.get(i).getWidth() >= v.getWidth() && availableSlots.get(i).getDepth() >= v.getDepth())
            {
                s = availableSlots.get(i);
                break;
            }
        }

        return s;
    }
}
