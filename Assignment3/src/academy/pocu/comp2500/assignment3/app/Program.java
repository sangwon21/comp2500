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
//        {
//            // K01_SimulationTest1
//            SimulationManager simulationManager = SimulationManager.getInstance();
//
//            Unit u0 = new Tank(new IntVector2D(0, 2));
//            Unit u1 = new Tank(new IntVector2D(0, 6));
//            Unit u2 = new Mine(new IntVector2D(9, 7), 2);
//            Unit u3 = new Mine(new IntVector2D(3, 3), 3);
//            Unit u4 = new Mine(new IntVector2D(7, 0), 4);
//            Unit u5 = new Mine(new IntVector2D(4, 3), 4);
//            Unit u6 = new Mine(new IntVector2D(1, 4), 4);
//            Unit u7 = new Mine(new IntVector2D(6, 3), 4);
//            Unit u8 = new Mine(new IntVector2D(14, 3), 2);
//            Unit u9 = new Mine(new IntVector2D(12, 1), 1);
//            Unit u10 = new Mine(new IntVector2D(0, 3), 2);
//            Unit u11 = new Mine(new IntVector2D(9, 1), 4);
//            Unit u12 = new Mine(new IntVector2D(6, 3), 3);
//            Unit u13 = new Mine(new IntVector2D(0, 5), 3);
//            Unit u14 = new Mine(new IntVector2D(15, 2), 3);
//            Unit u15 = new Mine(new IntVector2D(2, 6), 2);
//
//
//            ArrayList<Unit> units = new ArrayList<>();
//
//            units.add(u0);
//            units.add(u1);
//            units.add(u2);
//            units.add(u3);
//            units.add(u4);
//            units.add(u5);
//            units.add(u6);
//            units.add(u7);
//            units.add(u8);
//            units.add(u9);
//            units.add(u10);
//            units.add(u11);
//            units.add(u12);
//            units.add(u13);
//            units.add(u14);
//            units.add(u15);
//
//
//            for (Unit unit : units) {
//                simulationManager.spawn(unit);
//            }
//
//            SimulationVisualizer visualizer = new SimulationVisualizer(units);
//            for (int i = 0; i < 3; ++i) {
//                clearConsole();
//                visualizer.visualize(i, simulationManager.getUnits());
//                simulationManager.update();
////                continueOnEnter();
//            }
//        }
//        {
//            // K02_SimulationTest2
//            SimulationManager simulationManager = SimulationManager.getInstance();
//
//            Unit u0 = new Turret(new IntVector2D(6, 0));
//            Unit u1 = new Wraith(new IntVector2D(5, 2));
//            Unit u2 = new Wraith(new IntVector2D(0, 0));
//            Unit u3 = new Marine(new IntVector2D(3, 3));
//            Unit u4 = new Tank(new IntVector2D(6, 0));
//            Unit u5 = new SmartMine(new IntVector2D(5, 0), 4, 1);
//            Unit u6 = new Tank(new IntVector2D(1, 0));
//            Unit u7 = new Marine(new IntVector2D(1, 2));
//            Unit u8 = new Marine(new IntVector2D(4, 3));
//            Unit u9 = new SmartMine(new IntVector2D(5, 0), 1, 3);
//            Unit u10 = new Tank(new IntVector2D(1, 1));
//            Unit u11 = new Marine(new IntVector2D(3, 0));
//            Unit u12 = new Mine(new IntVector2D(3, 3), 3);
//            Unit u13 = new Wraith(new IntVector2D(3, 0));
//            Unit u14 = new Wraith(new IntVector2D(1, 0));
//            Unit u15 = new SmartMine(new IntVector2D(0, 2), 2, 2);
//
//
//            ArrayList<Unit> units = new ArrayList<>();
//
//            units.add(u0);
//            units.add(u1);
//            units.add(u2);
//            units.add(u3);
//            units.add(u4);
//            units.add(u5);
//            units.add(u6);
//            units.add(u7);
//            units.add(u8);
//            units.add(u9);
//            units.add(u10);
//            units.add(u11);
//            units.add(u12);
//            units.add(u13);
//            units.add(u14);
//            units.add(u15);
//
//
//            for (Unit unit : units) {
//                simulationManager.spawn(unit);
//            }
//
//            SimulationVisualizer visualizer = new SimulationVisualizer(units);
//            for (int i = 0; i < 2; ++i) {
//                clearConsole();
//                visualizer.visualize(i, simulationManager.getUnits());
//                simulationManager.update();
////                continueOnEnter();
//            }
//        }
        {
            // K00_SimulationTest0
            SimulationManager simulationManager = SimulationManager.getInstance();

            Unit u0 = new Marine(new IntVector2D(12, 6));
            Unit u1 = new Turret(new IntVector2D(7, 4));
            Unit u2 = new SmartMine(new IntVector2D(2, 5), 2, 2);
            Unit u3 = new Mine(new IntVector2D(7, 3), 2);
            Unit u4 = new Mine(new IntVector2D(7, 7), 4);
            Unit u5 = new Turret(new IntVector2D(1, 6));
            Unit u6 = new Mine(new IntVector2D(11, 0), 4);
            Unit u7 = new SmartMine(new IntVector2D(3, 0), 2, 1);
            Unit u8 = new Turret(new IntVector2D(10, 0));
            Unit u9 = new Turret(new IntVector2D(13, 3));
            Unit u10 = new Turret(new IntVector2D(14, 2));
            Unit u11 = new Tank(new IntVector2D(14, 6));
            Unit u12 = new SmartMine(new IntVector2D(10, 0), 1, 3);
            Unit u13 = new Marine(new IntVector2D(12, 6));
            Unit u14 = new Wraith(new IntVector2D(8, 7));
            Unit u15 = new Wraith(new IntVector2D(15, 7));


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
            for (int i = 0; i < 14; ++i) {
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
