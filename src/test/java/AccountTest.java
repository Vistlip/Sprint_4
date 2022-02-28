import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {
    static String str = null;
    private final String name;
    private final Boolean expected;
    private final String message;


    public AccountTest(String name, Boolean expected, String message) {
        this.name = name;
        this.expected = expected;
        this.message = message;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][]{
                {" Петр Великий", false, "Проверка - пробел в начале строки"},
                {"Петр Великий ", false, "Проверка - пробела в конце строки"},
                {"ПетрВеликий", false, "Проверка - наличия пробела между именем и фамилие"},
                {str, false, "Проверка - Null"},
                {"Петр Первый Великий", false, "Проверка - вводено отчество"},
                {"ПВ", false, "Проверка - в строке меньше 3 символов"},
                {"П В", true, "Проверка - граничное значения в 3 символа"},
                {"ПетрПервый  Великий", false, "Проверка - пробел должен быть только 1"},
                {"ПетрПервый ОченьОченьВеликий", false, "Проверка - в строке больше 19 символов"},
                {"", false, "Проверка - имя не должно быть пустым"},
                {"Петр Первый", true, "Проверка - имя корректно"},
                {"Девятнадцать Символ", true, "Проверка - граничное значение в 19 символов"},
        };
    }

    @Test
    @DisplayName("Параметризованный тест")
    public void nameWillBeValidTest() {
        Account account = new Account(name);
        assertEquals("", expected, account.checkNameToEmboss());
    }
}
