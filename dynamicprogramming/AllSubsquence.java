package pers.jack.dynamicprogramming;

public class AllSubsquence {
    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res); //不要這個位置
        printAllSub(str, i + 1, res + String.valueOf(str[i])); //要這個位置
    }

    public static void main(String[] args) {
        String test = "abc";
        printAllSub(test.toCharArray(), 0, "");
    }
}
