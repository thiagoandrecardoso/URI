package mathematics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class TheTrip {

    public static List<Double> listValores;
    public static List<Double> listDiferencaEntreValores = new ArrayList<Double>();

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
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
                if (numeroDeAlunos != 0)
                    listDiferencaEntreValores.add(calculoDaDiferenca(listValores, media(listValores)));
            }
        }
        StringBuilder sb = new StringBuilder("");
        for (Double valor : listDiferencaEntreValores) {
            DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
            decimalFormat.setRoundingMode(RoundingMode.DOWN);
            sb.append("$" + decimalFormat.format(valor) + "\n");
            sb.deleteCharAt(sb.indexOf(","));
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        System.out.println(sb.toString());
    }

    public static boolean verificaNumeroDeViagens(int numero) {
        if (numero < 1 || numero > 1000) {
            return false;
        }
        return true;
    }

    public static boolean verificaValor(Double valor) {
        if (valor < 0.0 || valor > 100000) {
            return false;
        }
        return true;
    }

    public static Double media(List<Double> listValores) {
        Double soma = 0.0;
        for (Double valor : listValores) {
            soma += valor;
        }
        Double media = soma / listValores.size();
        BigDecimal bd = BigDecimal.valueOf(media).setScale(2, RoundingMode.HALF_EVEN);
        media = bd.doubleValue();
        return media;
    }

    public static Double calculoDaDiferenca(List<Double> listValores, Double media) {
        Collections.sort(listValores);
        Double diferenca = 0.0;
        if (quantidadeDeValoresAcimaDaMediaEhMinoria(listValores, media)) {
            for (int i = listValores.size() - 1; i >= 0; i--) {
                if (listValores.get(i) > media) {
                    diferenca += listValores.get(i) - media;
                }
            }
        } else {
            for (Double valor : listValores) {
                if (valor < media) {
                    diferenca += media - valor;
                }
            }
        }
        return diferenca;
    }

    public static boolean quantidadeDeValoresAcimaDaMediaEhMinoria(List<Double> listValores, Double media) {
        int acima = 0;
        int abaixo = 0;
        for (Double valor : listValores) {
            if (valor > media) {
                acima++;
            } else {
                abaixo++;
            }
        }
        return (abaixo > acima);
    }

}
