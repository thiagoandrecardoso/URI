package dataStructuresAndLibraries;

import java.util.Scanner;

public class TDArational {

    public static int valores[] = new int[4];
    public static String operador;


    public static boolean verificaExpressao(String expressao) {

        String arrayExpressao[] = expressao.split(" ");

        int indice = 0;

        for (int i = 0; i < arrayExpressao.length; i += 2) {
            try {
                int numero = Integer.parseInt(arrayExpressao[i]);
                if (numero < 1 || numero > 1000) {
                    return false;
                } else {
                    valores[indice] = numero;
                    indice++;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        if (!(arrayExpressao[3].equals("+") || arrayExpressao[3].equals("-") || arrayExpressao[3].equals("*")
                || arrayExpressao[3].equals("/"))) {
            return false;
        }

        if (!(arrayExpressao[1].equals("/") && arrayExpressao[5].equals("/"))) {
            return false;
        }

        if (arrayExpressao.length != 7) return false;

        operador = arrayExpressao[3];

        return true;
    }

    public static boolean verificaNumero(int N) {
        if (N < 1 || N > 1 * Math.pow(10, 4)) {
            return false;
        }
        return true;
    }

    public static int mdc(int dividendo, int divisor) {
        if (dividendo % divisor == 0) {
            return divisor;
        } else {
            return mdc(divisor, (dividendo % divisor));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String lixo = sc.nextLine();
        StringBuilder sb = new StringBuilder("");
        if (verificaNumero(N)) {
            for (int i = 0; i < N; i++) {
                String expressao = sc.nextLine();
                if (verificaExpressao(expressao)) {
                    int numerador = 0;
                    int denominador = 0;
                    int n1 = valores[0];
                    int d1 = valores[1];
                    int n2 = valores[2];
                    int d2 = valores[3];

                    if (operador.equals("+")) {
                        numerador = (n1 * d2 + n2 * d1);
                        denominador = (d1 * d2);
                    } else if (operador.equals("-")) {
                        numerador = (n1 * d2 - n2 * d1);
                        denominador = (d1 * d2);
                    } else if (operador.equals("*")) {
                        numerador = (n1 * n2);
                        denominador = (d1 * d2);
                    } else if (operador.equals("/")) {
                        numerador = (n1 * d2);
                        denominador = (n2 * d1);
                    }
                    int mdc_valor = mdc(numerador, denominador);
                    if (mdc_valor == 1) {
                        sb.append(numerador + "/" + denominador + " = " + numerador + "/" + denominador + "\n");
                    } else {
                        int numerador_simpl = numerador / mdc_valor;
                        int denominador_simpl = denominador / mdc_valor;
                        if (denominador_simpl < 0) {
                            denominador_simpl *= -1;
                            numerador_simpl *= -1;
                        }
                        sb.append(numerador + "/" + denominador + " = " + numerador_simpl + "/" + denominador_simpl + "\n");
                    }
                }
            }
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.println(sb.toString());
    }
}
