package academy.pocu.comp2500.lab3.app;

import academy.pocu.comp2500.lab3.ListItem;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        ArrayList<ListItem> list = new ArrayList<>();

        ListItem listItem1 = new ListItem("My first item");

        ListItem sublistItem1 = new ListItem("This is sublist item1", '>');
        ListItem sublistItem2 = new ListItem("This is sublist item2", '>');

        listItem1.addSublistItem(sublistItem1);
        listItem1.addSublistItem(sublistItem2);

        ListItem listItem2 = new ListItem("My second item");

        ListItem listItem3 = new ListItem("My third item");

        ListItem sublistItem3 = new ListItem("This is sublist item3", '>');
        ListItem subSublistItem1 = new ListItem("This is sub-sublist item1", '-');

        sublistItem3.addSublistItem(subSublistItem1);
        listItem3.addSublistItem(sublistItem3);

        list.add(listItem1);
        list.add(listItem2);
        list.add(listItem3);

        String actual = toString(list);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* My first item%s", System.lineSeparator()));
        sb.append(String.format("    > This is sublist item1%s", System.lineSeparator()));
        sb.append(String.format("    > This is sublist item2%s", System.lineSeparator()));
        sb.append(String.format("* My second item%s", System.lineSeparator()));
        sb.append(String.format("* My third item%s", System.lineSeparator()));
        sb.append(String.format("    > This is sublist item3%s", System.lineSeparator()));
        sb.append(String.format("        - This is sub-sublist item1%s",
                System.lineSeparator()));

        String expected = sb.toString();

        assert expected.equals(actual);

        ArrayList<ListItem> newList = new ArrayList<>();
        ListItem listItem4 = new ListItem("My first item");

        newList.add(listItem4);

        String actual2 = toString(newList);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("* My first item%s", System.lineSeparator()));


        String expected2 = sb2.toString();
        System.out.println(actual2);
        assert expected2.equals(actual2);

//        ArrayList<ListItem> list = new ArrayList<>();
//
//        ListItem listItem = new ListItem("Let the cat out of the bag");
//
//        ListItem sublistItem1 = new ListItem("Call a spade a spade", '>');
//        ListItem sublistItem2 = new ListItem("Blast from the past - A", '>');
//
//        listItem.addSublistItem(sublistItem1);
//        listItem.addSublistItem(sublistItem2);
//
//        ListItem listItem2 = new ListItem("Share and share alike");
//        ListItem listItem3 = new ListItem("Christmas card verses");
//
//        sublistItem2.addSublistItem(listItem2);
//        sublistItem2.addSublistItem(listItem3);
//
//        ListItem listItem4 = new ListItem("High and mighty");
//        ListItem listItem5 = new ListItem("Stump up");
//        ListItem listItem6 = new ListItem("Country bumpkin");
//        ListItem listItem7 = new ListItem("Can't hold a candle to");
//
//        listItem3.addSublistItem(listItem4);
//        listItem3.addSublistItem(listItem5);
//        listItem3.addSublistItem(listItem6);
//        listItem3.addSublistItem(listItem7);
//
//        listItem4.addSublistItem(new ListItem("Let not poor Nelly starve"));
//
//        ListItem listItem8 = new ListItem("Al fresco");
//        ListItem listItem9 = new ListItem("Don't get mad, get even");
//        ListItem listItem10 = new ListItem("Cat's pajamas - The");
//
//        listItem8.addSublistItem(listItem9);
//        listItem8.addSublistItem(listItem10);
//
//        listItem6.addSublistItem(listItem8);
//
//        list.add(listItem);
//
//        System.out.println(listItem3.getSublistItem(0));
//        String s = toString(list);
//
//        System.out.println(s);
    }

    private static String toString(ArrayList<ListItem> list) {
        StringBuilder sb = new StringBuilder();
        for (ListItem item : list) {
            sb.append(item);
        }

        return sb.toString();
    }
}
