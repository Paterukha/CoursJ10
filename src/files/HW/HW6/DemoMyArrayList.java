package files.HW.HW6;


import files.HW.HW6.collections.MyArrayList;


public class DemoMyArrayList {
    private MyArrayList<String> myArrayList = new MyArrayList<>();

    public DemoMyArrayList(){
        showDemo();
    }

    private void showDemo() {

        System.out.println("Add elements to MyArrayList:");
        myArrayList.add("Yana1");
        myArrayList.add("Yana2");
        myArrayList.add("Yana0");
        myArrayList.add("Yana1");
        showInfo();

        int index = 2;
        System.out.println("Get element by index " + index + ":");
        Object arrayListElement = myArrayList.get(index);
        if (arrayListElement != null) {
            System.out.println("Element " + index + " is " + arrayListElement);
        }
        System.out.println();

        index = 2;
        System.out.println("Remove element " + index + " from MyArraylist:");
        myArrayList.remove(index);
        showInfo();

        System.out.println("Clear MyArraylist:");
        myArrayList.clear();
        showInfo();
    }

    private void showInfo(){
        myArrayList.print();
        System.out.println("Size is " + myArrayList.size());
        System.out.println();
    }
}
