import java.io.*;
import java.util.*;

public class CashRegister {

    int[] register = new int[6];
    int[] value = {20, 10, 5, 2, 1};

    public String show() {

        String out = "$";

        for (int i : register) {
            out += String.valueOf(i) + " ";
        }

        return out.trim();
    }

    public String put(String input) {
        String arr[] = input.split(" ");

        for (int i = 0; i < 5; i++) {
            register[i + 1] += Integer.parseInt(arr[i]);
            register[0] += value[i] * Integer.parseInt(arr[i]);
        }

        return this.show();
    }

    public boolean check(String arr[]) {

        boolean flag = true;

        for (int i = 1; i < register.length; i++) {
            if (register[i] < Integer.parseInt(arr[i - 1])) {
                flag = false;
            }
        }
        return flag;
    }

    public String take(String remove) {
        String arr[] = remove.split(" ");

        if (check(arr)) {
            for (int i = 0; i < 5; i++) {
                register[i + 1] -= Integer.parseInt(arr[i]);
                register[0] -= value[i] * Integer.parseInt(arr[i]);
            }
        } else {
            return "Not enough denomination to take";
        }

        return this.show();
    }

    public String change(String change) {

        int amount = Integer.parseInt(change);
        ArrayList<Integer> list = new ArrayList();
        for(int i=0;i<value.length;i++){
            for(int j=0;j<register[i+1];j++){
                list.add(value[i]);
            }
        }

        int req = amount;
        boolean[][] dp =new boolean[list.size()+1][amount+1];
        int[][][] res = new int[list.size()+1][amount+1][5];
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(20,0);
        map.put(10,1);
        map.put(5,2);
        map.put(2,3);
        map.put(1,4);
        dp[0][0] = true;
        res[0][0]  = new int[]{0,0,0,0,0};
        for(int i=1;i<=list.size();i++){
            res[i][0] = new int[]{0,0,0,0,0};
            dp[i][0] = true;
            int currAmount = list.get(i-1);
            for(int j=1;j<=amount;j++){
                if(j>1){
                    dp[i][j] = dp[i-1][j];
                    res[i][j] = new int[]{res[i-1][j][0], res[i-1][j][1], res[i-1][j][2],
                            res[i-1][j][3], res[i-1][j][4]};
                } else {
                    res[i][j] = new int[]{0,0,0,0,0};
                }
                if(!dp[i][j] && j>=currAmount && dp[i-1][j-currAmount]){
                    dp[i][j] = true;
                    res[i][j] = new int[]{res[i-1][j-currAmount][0], res[i-1][j-currAmount][1], res[i-1][j-currAmount][2]
                    , res[i-1][j-currAmount][3], res[i-1][j-currAmount][4]};
                    res[i][j][map.get(currAmount)]++;
                }
            }
        }
        if(!dp[list.size()][amount]){
            return "Sorry";
        }
        String str = "";
        for(int i=0;i<5;i++) {
            str += res[list.size()][amount][i] + " ";
        }
        this.take(str.trim());
        return str.trim();

    }
    public void quit() {

        System.out.println("Bye");
        System.exit(0);
    }

}

class Main {
    public static void main(String args[]) {

        System.out.println("Enter the function with the function name and values as String separated by space");
        System.out.println("Example: put 1 2 3 4 5");
        Scanner input = new Scanner(System.in);

        CashRegister register = new CashRegister();

        while (input.hasNextLine()) {
            String in = input.nextLine().trim();
            if (in != "") {
                String[] check = in.split(" ");

                switch (check[0]) {

                    case "put":
                        System.out.println(register.put(in.substring(4)));
                        break;
                    case "take":
                        System.out.println(register.take(in.substring(5)));
                        break;
                    case "change":
                        System.out.println(register.change(in.substring(7)));
                        break;
                    case "show":
                        System.out.println(register.show());
                        break;
                    case "quit":
                        register.quit();
                        break;
                    default:
                        System.out.println("Please enter a valid function");
                }
            }

        }
    }
}

