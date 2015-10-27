package ListTester;

public class ListTester {

  public static void main(String[] args) {
    int totalTests = 17;
    int success = 0;
    boolean flag = false;
    int count = 0;
    String item = "";
    int index = -1;
    OurList<String> l1 = new OurArrayList<>();

    flag = l1.isEmpty();
    System.out.print("Empty test. Expected true, received: " + flag);
    if (flag) {
      System.out.println(" : Succeeded.");
      success++;
    } 
    else System.out.println(" : Failed.");

    try {
      l1.add(4, "four");
      System.out.println("Shouldn't add at index 4 : Failed.");
    }
    catch (IndexOutOfBoundsException e) {
      System.out.println("Shouldn't add at index 4 : Succeeded.");
      success++;
    }

    l1.add("zero");
    l1.add("one");
    l1.add("two");
    l1.add("three");
    count = l1.size();
    System.out.print("Getting size, expecting 4, received " + count);
    if (count == 4) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");


    try {
      l1.remove(4);
      System.out.println("Shouldn't remove from index 4 : Failed.");
    }
    catch (IndexOutOfBoundsException e) {
      System.out.println("Shouldn't remove from index 4 : Succeeded.");
      success++;
    }

    item = l1.get(2);
    System.out.print("Getting from index 2, expecting 'two', received '" + item + "'");
    if (item.equals("two")) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    l1.remove(0);
    item = l1.get(0);
    System.out.print("Getting from index 0, expecting 'one', received '" + item + "'");
    if (item.equals("one")) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    l1.clear();
    flag = l1.isEmpty();
    System.out.print("Clear test. Expected true, received: " + flag);
    if (flag) {
      System.out.println(" : Succeeded.");
      success++;
    } 
    else System.out.println(" : Failed.");

    l1.add("zero");
    l1.add("one");
    l1.add("two");
    l1.add("three");
    l1.add(2, "five");
    item = l1.get(4);
    System.out.print("Getting from index 4, expecting 'three', received '" + item + "'");
    if (item.equals("three")) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    try {
      l1.set(7, "four");
      System.out.println("Shouldn't add at index 7 : Failed.");
    }
    catch (IndexOutOfBoundsException e) {
      System.out.println("Shouldn't add at index 7 : Succeeded.");
      success++;
    }

    l1.set(3, "six");
    item = l1.get(3);
    System.out.print("Getting from index 3, expecting 'six', received '" + item + "'");
    if (item.equals("six")) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    flag = l1.contains("five");
    System.out.print("List contains 'five', expecting true, received " + flag);
    if (flag) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    flag = l1.contains("nine");
    System.out.print("List contains 'nine', expecting false, received " + flag);
    if (!flag) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    index = l1.indexOf("three");
    System.out.print("Getting index of 'three', expecting 4, received " + index);
    if (index == 4) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    index = l1.indexOf("nine");
    System.out.print("Getting index of 'nine', expecting -1, received " + index);
    if (index == -1) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    flag = l1.remove("twelve");
    System.out.print("Removing 'twelve', expecting false, received " + flag);
    if (!flag) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    flag = l1.remove("five");
    System.out.print("Removing 'five', expecting true, received " + flag);
    if (flag) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    flag = l1.contains("five");
    System.out.print("List contains 'five', expecting false, received " + flag);
    if (!flag) {
      System.out.println(" : Succeeded.");
      success++;
    }
    else System.out.println(" : Failed.");

    System.out.println("Tests Passed: " + success);
    System.out.println("Tests Failed: " + (totalTests - success));
  }
  
}