package Garage;

import java.util.Vector;

public interface ISlotSelector
{
    public Slot selectSlot (Vector<Slot> availableSlots, Vehicle v);
}
