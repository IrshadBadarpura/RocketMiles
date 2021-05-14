public class Test {

    public static void main(String args[]){

        CashRegister test1 = new CashRegister();
        CashRegister test2 = new CashRegister();
        CashRegister test3 = new CashRegister();

        System.out.println("Test 1");
        System.out.println("put 0 0 2 1 1");
        System.out.println(test1.put("0 0 2 1 1"));
        System.out.println("change 8");
        System.out.println(test1.change("8"));
        System.out.println("show");
        System.out.println(test1.show());
        System.out.println("End of Test 1 \n");

        System.out.println("Test 2");
        System.out.println("put 1 2 3 4 5");
        System.out.println(test2.put("1 2 3 4 5"));
        System.out.println("show");
        System.out.println(test2.show());
        System.out.println("put 1 2 3 0 5");
        System.out.println(test2.put("1 2 3 0 5"));
        System.out.println("take 1 4 3 0 10");
        System.out.println(test2.take("1 4 3 0 10"));
        System.out.println("change 11");
        System.out.println(test2.change("11"));
        System.out.println("change 14");
        System.out.println(test2.change("14"));
        System.out.println("End of Test 2 \n");

        System.out.println("Test 3");
        System.out.println("put 1 4 3 2 1");
        System.out.println(test3.put("1 4 3 2 1"));
        System.out.println("change 78");
        System.out.println(test2.change("78"));
        System.out.println("show");
        System.out.println(test3.show());
        System.out.println("End of Test 3");

    }

}
