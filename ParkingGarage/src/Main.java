import Garage.ParkingGarage;
import Garage.Slot;
import Garage.Vehicle;

import java.util.Scanner;
import java.util.Vector;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        //Enter configuration
        System.out.print("Enter Configuration 1 (First Fit) or 2 (Best Fit): ");
        int con = input.nextInt();
        while (con != 1 && con !=2)
        {
            System.out.print("Invalid Number .Enter Configuration 1 (First Fit) or 2 (Best Fit) Again: ");
            con = input.nextInt();
        }

        //Create Parking Garage
        ParkingGarage p = new ParkingGarage(con);

        //Enter number of slots
        System.out.print("Enter number of slots: ");
        int num = input.nextInt();
        p.getSlotHandling().setNumberOfSlots(num);

        //Enter slots
        for (int i = 1 ; i<num+1;i++)
        {
            Slot s = new Slot();
            System.out.print("Enter "+i+" Slot width and depth: ");
            double w = input.nextDouble();
            double d = input.nextDouble();
            while (w<1 || d<1)
            {
                //Exception invalid dimensions
                System.out.println("Slot Dimensions are invalid.");
                System.out.print("Enter "+i+" Slot width and depth Again: ");
                w = input.nextDouble();
                d = input.nextDouble();
            }
            s.setWidth(w);
            s.setDepth(d);
            s.setId(i);
            p.getSlotHandling().setSlot(s);
        }

        //Menu
        System.out.println("\n The Menu: ");
        System.out.println("1) Park In");
        System.out.println("2) Park Out");
        System.out.println("3) Display Available Slots");
        System.out.println("4) Display All Slots");
        System.out.println("5) Calculate Total Income");
        System.out.println("6) Calculate Total number of vehicles");
        System.out.println("7) Exit");
        System.out.print("Enter option number: ");
        int option = input.nextInt();

        while (option!=7)
        {
            //Park In
            if (option==1)
            {
                //Check if there are free slots
                if(p.getSlotHandling().getNumberOfAvailableSlots() != 0)
                {
                    //Create vehicle to store its information
                    Vehicle v =new Vehicle();

                    //Enter vehicle information
                    System.out.print("Enter model name: ");
                    String n = input.next();
                    System.out.print("Enter identification number: ");
                    String id = input.next();
                    System.out.print("Enter model year: ");
                    int year = input.nextInt();
                    System.out.print("Enter width and depth: ");
                    double w = input.nextDouble();
                    double d = input.nextDouble();
                    //if user enters invalid dimensions
                    while (w<1 || d<1)
                    {
                        //Exception invalid dimensions
                        System.out.println("Slot Dimensions are invalid.");
                        System.out.print("Enter width and depth Again: ");
                        w = input.nextDouble();
                        d = input.nextDouble();
                    }
                    //set vehicle attributes
                    v.setModelName(n);
                    v.setIdentificationNumber(id);
                    v.setModelYear(year);
                    v.setDimensions(w,d);

                    //call function
                    Vehicle vec = p.getParkIn().park_in(v);

                    if (vec.getIdentificationNumber().equals("-1"))
                    {
                        System.out.println("No Fit Slot Is Available For This Car");
                    }
                    else
                    {
                        //Print found slot and its information
                        System.out.print("The Slot ID in the Garage: ");
                        System.out.print(vec.getCard().getSlot().getId());
                        System.out.print(" (width x depth) = ");
                        System.out.println( "("+vec.getCard().getSlot().getWidth() + " x " +  vec.getCard().getSlot().getDepth()+")");
                        //Print TimeIn
                        System.out.println("TimeIn: " + vec.getCard().getTime().getTimeIn());
                    }
                }
                //there is no free slot
                else
                {
                    System.out.println("No Slots are Available Now");
                }
            }

            //Park Out
            else if (option==2)
            {
                //input vehicle id
                System.out.print("Enter identification number: ");
                String id = input.next();
                //call function
                Vehicle vec = p.getParkOut().park_out(id);

                //not found the vehicle has entered id
                if (vec.getIdentificationNumber().equals("-1"))
                {
                    System.out.println("Id is wrong.");
                }
                //found
                else
                {
                    //print TimeOut
                    System.out.println("TimeOut: " + vec.getCard().getTime().getTimeOut());
                    //Print time of stay
                    System.out.println("TimeOfStay: " + vec.getCard().getTimeAdapter().getTimeOfStay() + " minutes");
                    //Print fees
                    System.out.println("Park Fees: " + vec.getCard().getFeesCalculation().getParkingFees());
                }
            }

            //Display Available Slots
            else if (option==3)
            {
                Vector<Slot> availableSlots = p.getSlotHandling().getAvailableSlots();

                //if no available slots
                if (availableSlots.size()==0)
                {
                    System.out.println("No Slots are Available Now");
                }
                //Print all available slots
                else
                {
                    System.out.println("Available Slots: ");
                    for (int i = 0; i < availableSlots.size(); i++)
                    {
                        System.out.print((i + 1) + ") ");
                        System.out.print("Width x Depth = ");
                        System.out.println(availableSlots.get(i).getWidth() + " x " + availableSlots.get(i).getDepth());
                    }
                }
            }

            //Display All Slots
            else if (option==4)
            {
                Vector<Slot> allSlots = p.getSlotHandling().getAllSlots();

                //if no slots
                if (allSlots.size()==0)
                {
                    System.out.println("No Slots");
                }
                //Print all slots
                else
                {
                    System.out.println("Slots: ");
                    for (int i = 0; i < allSlots.size(); i++)
                    {
                        System.out.print((i + 1) + ") ");
                        System.out.print("Width x Depth = ");
                        System.out.print(allSlots.get(i).getWidth() + " x " + allSlots.get(i).getDepth());
                        if (allSlots.get(i).isAvailable())
                        {
                            System.out.println(" (Available)");
                        }
                        else
                        {
                            System.out.println(" (Not Available)");
                        }
                    }
                }
            }

            //Display Available Slots
            else if (option==5)
            {
                System.out.println("Total Income: " + p.getTotal().calculateTotalIncome());
            }

            //Number Of Vehicles
            else if (option==6)
            {
                System.out.println("Number of Vehicles In Garage Now: "+ p.getVehicleCalculation().calculateNumberOfVehicles(p.getSlotHandling()));
                System.out.println("Number of ALL Vehicles: "+ p.getVehicleHandling().getNumberOfVehicles());
            }

            //Menu
            System.out.println("\n The Menu: ");
            System.out.println("1) Park In");
            System.out.println("2) Park Out");
            System.out.println("3) Display Available Slots");
            System.out.println("4) Display All Slots");
            System.out.println("5) Calculate Total Income");
            System.out.println("6) Calculate Total number of vehicles");
            System.out.println("7) Exit");
            System.out.print("Enter option number: ");
            option = input.nextInt();

        }

    }
}
