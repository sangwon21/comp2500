package academy.pocu.comp2500.assignment3.app;

import academy.pocu.comp2500.assignment3.*;
import academy.pocu.comp2500.assignment3.registry.Registry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        // write your code here
        {
            Registry registry = new Registry();
            App app = new App(registry);
            registry.validate();
        }
        {
            SimulationManager simulationManager = SimulationManager.getInstance();

            Unit u0 = new Wraith(new IntVector2D(15, 0));
            Unit u1 = new Marine(new IntVector2D(4, 3));
            Unit u2 = new Marine(new IntVector2D(10, 5));
            Unit u3 = new Turret(new IntVector2D(3, 4));
            Unit u4 = new Wraith(new IntVector2D(14, 7));
            Unit u5 = new Mine(new IntVector2D(14, 6), 3);
            Unit u6 = new Mine(new IntVector2D(5, 0), 3);
            Unit u7 = new SmartMine(new IntVector2D(8, 0), 3, 2);
            Unit u8 = new Mine(new IntVector2D(4, 2), 3);
            Unit u9 = new Tank(new IntVector2D(9, 6));
            Unit u10 = new Turret(new IntVector2D(3, 7));
            Unit u11 = new SmartMine(new IntVector2D(14, 3), 3, 1);
            Unit u12 = new Tank(new IntVector2D(8, 0));
            Unit u13 = new SmartMine(new IntVector2D(2, 4), 4, 1);
            Unit u14 = new Wraith(new IntVector2D(10, 0));
            Unit u15 = new Wraith(new IntVector2D(4, 5));


            ArrayList<Unit> units = new ArrayList<>();

            units.add(u0);
            units.add(u1);
            units.add(u2);
            units.add(u3);
            units.add(u4);
            units.add(u5);
            units.add(u6);
            units.add(u7);
            units.add(u8);
            units.add(u9);
            units.add(u10);
            units.add(u11);
            units.add(u12);
            units.add(u13);
            units.add(u14);
            units.add(u15);


            for (Unit unit : units) {
                simulationManager.spawn(unit);
            }

            SimulationVisualizer visualizer = new SimulationVisualizer(units);
            for (int i = 0; i < 12; ++i) {
                clearConsole();
                visualizer.visualize(i, simulationManager.getUnits());
                simulationManager.update();
//                continueOnEnter();
            }
        }
    }

    public static void continueOnEnter() {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Press enter to continue");
            reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {
        try {
            new ProcessBuilder("bash", "-c", "clear").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
