package org.example;

public class ConversorDeNumeroRomano {

    // Arrays que representam os valores e símbolos dos algarismos romanos
    private static final int[] VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] ROMAN_NUMERALS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


/* Este método converte um número decimal em seu equivalente em algarismos romanos.
Ele verifica se o número está dentro do intervalo válido (1 a 3999) e,
em seguida, realiza a conversão usando uma lógica de subtração e concatenação de símbolos romanos.*/
    public String numeroRomano(int numero) {
        if (numero <= 0 || numero > 3999) {
            throw new IllegalArgumentException("O número não pode ser convertido para algarismos romanos.");
        }

        StringBuilder result = new StringBuilder();
        int i = 0;
        while (numero > 0) {
            if (numero >= VALUES[i]) {
                result.append(ROMAN_NUMERALS[i]);
                numero -= VALUES[i];
            } else {
                i++;
            }
        }
        return result.toString();
    }

    /* Este método converte um número romano em seu equivalente em número decimal.
    Ele verifica se o número romano fornecido é válido de acordo com as regras e,
    em seguida, realiza a conversão, adicionando os valores correspondentes aos símbolos romanos.
     */
    public int numeroDecimal(String romano) {
        if (!numeroRomanoValido(romano)) {
            throw new IllegalArgumentException("O número romano fornecido não é válido.");
        }
        int result = 0;
        int i = 0;
            while (i < romano.length()) {
                int valorAtual = getValue(romano.charAt(i));
                if (i + 1 < romano.length()) {
                    int nextVal = getValue(romano.charAt(i + 1));
                    if (valorAtual < nextVal) {
                        result += nextVal - valorAtual;
                        i += 2;
                    } else {
                        result += valorAtual;
                        i++;
                    }
                } else {
                    result += valorAtual;
                    i++;
                }
            }
            return result;
        }

/* Este método verifica se um número romano fornecido é válido, de acordo com as
 regras estabelecidas. Ele usa uma expressão regular para validar o número romano.*/
        private boolean numeroRomanoValido(String roman) {
            return roman.matches("^(M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3}))$");
        }
/*Este método retorna o valor correspondente a um símbolo romano. Caso o símbolo seja inválido, ele lança uma exceção.*/
        private int getValue(char digitoRomano) {
            switch (digitoRomano) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default: throw new IllegalArgumentException("Caractere romano inválido: " + digitoRomano);
            }
        }

}
