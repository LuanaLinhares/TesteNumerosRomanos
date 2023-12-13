package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Instanciação do conversor para realizar as conversões
        ConversorDeNumeroRomano conversor = new ConversorDeNumeroRomano();
        // Instanciação do Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Loop principal para manter o programa em execução
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Converter número decimal para romano");
            System.out.println("2. Converter número romano para decimal");
            System.out.println("0. Sair");

            // Leitura da opção do usuário
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    // Opção para converter número decimal para romano
                    System.out.print("Digite um número decimal: ");
                    int decimal = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        String romano = conversor.numeroRomano(decimal);
                        System.out.println("Número romano: " + romano);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    // Opção para converter número romano para decimal
                    System.out.print("Digite um número romano: ");
                    String romanoInput = scanner.nextLine();
                    try {
                        int decimalResult = conversor.numeroDecimal(romanoInput);
                        System.out.println("Número decimal: " + decimalResult);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    // Opção para encerrar o programa
                    System.out.println("Encerrando o programa.");
                    System.exit(0);
                    break;
                default:
                    // Mensagem para opção inválida
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
