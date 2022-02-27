import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import io.qameta.allure.junit4.DisplayName;


import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final Boolean expected;


    public AccountTest(String name, Boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][] {
                {" Петр Великий", false},
                {"Петр Великий ", false},
                {"ПетрВеликий", false},
                {" Петр Первый Великий ", false},
                {"Петр Первый Великий", false},
                {"ПВ", false},
                {"Петр", false},
                {"ПетрПервый  Великий", false},
                {"ПетрПервый ОченьОченьВеликий", false},
                {"", false},
                {"Петр Первый", true},
        };
    }

    @Test
    @DisplayName("Параметризированный тест")
    public void nameWillBeValid() {
        Account account = new Account(name);
        assertEquals(expected, account.checkNameToEmboss());
    }

}
