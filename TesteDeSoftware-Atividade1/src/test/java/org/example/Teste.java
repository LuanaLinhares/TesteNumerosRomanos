import org.example.ConversorDeNumeroRomano;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Teste {
    private ConversorDeNumeroRomano converter;

    /*Este método é executado antes de cada teste e inicializa a instância do `ConversorDeNumeroRomano`
    para que os testes possam usá-la.
     */
    @BeforeEach
    public void setUp() {
        converter = new ConversorDeNumeroRomano();
    }

    /*Este teste parametrizado verifica se a conversão de números decimais em algarismos romanos está correta para vários casos.
    Ele usa `@CsvSource` para fornecer pares de entrada/saída.
     */
    @ParameterizedTest
    @CsvSource({"1, 'I'", "3, 'III'", "4, 'IV'","8, 'VIII'", "9, 'IX'","19, 'XIX'","34, 'XXXIV'", "58, 'LVIII'", "1994, 'MCMXCIV'", "3999, 'MMMCMXCIX'"})
    public void testeParaNumeroRomano(int decimal, String expectedRoman) {
        String roman = converter.numeroRomano(decimal);
        assertEquals(expectedRoman, roman);
    }
/*Este teste parametrizado verifica se o código lida corretamente com números romanos inválidos, como "IIII" e "XIIII".
 */
    @ParameterizedTest
    @ValueSource(strings = {"IIII", "XIIII"})
    public void testeParaNumeroRomanoInvalido(String invalidRoman) {
        Executable executable = () -> converter.numeroDecimal(invalidRoman);
        assertThrows(IllegalArgumentException.class, executable);
    }
/*Este teste parametrizado verifica se a conversão de números romanos em decimais está correta para vários casos.
 */
    @ParameterizedTest
    @CsvSource({"'I', 1", "'III', 3", "'IV', 4","'VIII', 8", "'IX', 9","'XIX', 19", "'XXXIV', 34", "'LVIII', 58", "'MCMXCIV', 1994", "'MMMCMXCIX', 3999"})
    public void testeParaDecimal(String roman, int expectedDecimal) {
        int decimal = converter.numeroDecimal(roman);
        assertEquals(expectedDecimal, decimal);
    }
/*Este teste parametrizado verifica se o código lida corretamente com números decimais inválidos,
como 0 e 4000, e se as mensagens de erro correspondentes são geradas.
 */
    @ParameterizedTest
    @CsvSource({"0, 'O número não pode ser convertido para algarismos romanos.'", "4000, 'O número não pode ser convertido para algarismos romanos.'"})
    public void testeParaNumeroRomanoInvalidoDecimal(int invalidDecimal, String expectedErrorMessage) {
        Executable executable = () -> converter.numeroRomano(invalidDecimal);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, executable);
        assertEquals(expectedErrorMessage, exception.getMessage());
    }
}
