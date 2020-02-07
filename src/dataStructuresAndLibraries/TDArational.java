package dataStructuresAndLibraries;

import java.util.Scanner;

public class TDArational {

    public static int valores[] = new int[4];

    public static boolean verificaExpressao(String expressao) {

        String operadores = "+-/*";
        int indice = 0;

        for (int i = 0; i < expressao.length(); i += 4) {
            if (!Character.isDigit(expressao.charAt(i))) {
                return false;
            } else {
                int x = (int) expressao.charAt(i) - 48;
                if (x < 1 || x > 1000) {
                    return false;
                } else {
                    valores[indice] = x;
                    indice++;
                }
            }
        }

        for (int i = 1; i < expressao.length(); i += 2) {
            if (!Character.isSpaceChar(expressao.charAt(i))) {
                return false;
            }
        }

        if (!(expressao.charAt(6) == '+' || expressao.charAt(6) == '-' || expressao.charAt(6) == '*'
                || expressao.charAt(6) == '/')) {
            return false;
        }

        if (!(expressao.charAt(2) == '/' && expressao.charAt(10) == '/')) {
            return false;
        }

        if (expressao.length() != 13) return false;

        return true;
    }

    public static boolean verificaNumero(int N) {
        if (N < 1 || N > 1 * Math.pow(10, 4)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = 1; //sc.nextInt();
        String expressao = sc.nextLine();
        if (verificaNumero(N) && verificaExpressao(expressao)) {
            int n1 = valores[0];
            int d1 = valores[1];
            int n2 = valores[2];
            int d2 = valores[3];
            if (expressao.charAt(6) == '+') {
//                Sum: (N1*D2 + N2*D1) / (D1*D2)
                int numerador = (n1 * d2 + n2 * d1);
                int denominador = (d1 * d2);
                System.out.println(numerador + "/" + denominador);
            }
        }
    }
}
