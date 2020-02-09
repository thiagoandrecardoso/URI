package mathematics;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TheTrip {

    public static List<Double> listValores;
    public static List<Double> listDiferencaEntreValores = new ArrayList<Double>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroDeAlunos = -1;

        while (numeroDeAlunos != 0) {
            numeroDeAlunos = sc.nextInt();
            String lixo = sc.nextLine();
            listValores = new ArrayList<Double>();

            if (verificaNumeroDeViagens(numeroDeAlunos)) {
                for (int i = 0; i < numeroDeAlunos; i++) {
                    Double valor = sc.nextDouble();
                    if (verificaValor(valor)) {
                        listValores.add(valor);
                    }
                }
            }
            if (numeroDeAlunos != 0) listDiferencaEntreValores.add(calculoDaDiferenca(listValores, media(listValores)));
        }
        for (Double valor : listDiferencaEntreValores) {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            System.out.println(decimalFormat.format(valor));
        }
    }

    public static boolean verificaNumeroDeViagens(int numero) {
        if (numero < 1 || numero > 1000) {
            return false;
        }
        return true;
    }

    public static boolean verificaValor(Double valor) {
        if (valor < 0.0 || valor > 10000.00) {
            return false;
        }
        return true;
    }

    public static Double media(List<Double> listValores) {
        Double soma = 0.0;
        for (Double valor : listValores) {
            soma += valor;
        }
        return soma / listValores.size();
    }

    public static Double calculoDaDiferenca(List<Double> listValores, Double media) {
        Collections.sort(listValores);
        Double diferenca = 0.0;
        for (Double valor : listValores) {
            if (valor < media) {
                diferenca += media - valor;
            }
        }
        return diferenca;
    }

}
