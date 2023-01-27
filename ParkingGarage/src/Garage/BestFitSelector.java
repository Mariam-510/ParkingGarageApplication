package Garage;
import java.util.Vector;

public class BestFitSelector implements ISlotSelector
{
    //override function
    //the class implements the body of this function to find best fit slot
    public Slot selectSlot (Vector<Slot> availableSlots, Vehicle v)
    {
        int j;
        Slot s;
        for (j = 0; j < availableSlots.size(); j++)
        {
            if (availableSlots.get(j).getWidth() >= v.getWidth() && availableSlots.get(j).getDepth() >= v.getDepth())
            {
                break;
            }
        }

        if (j==availableSlots.size())
            s = new Slot(-1,-1);

        else
        {
            s = new Slot(availableSlots.get(j));
            for (int i = j; i < availableSlots.size(); i++) {
                if (availableSlots.get(i).getWidth() >= v.getWidth() && availableSlots.get(i).getDepth() >= v.getDepth())
                {
                    if (availableSlots.get(i).getWidth() <= s.getWidth() && availableSlots.get(i).getDepth() <= s.getDepth())
                    {
                        s = availableSlots.get(i);
                    }
                }
            }
        }

        return s;
    }
}


