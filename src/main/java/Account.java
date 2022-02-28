import io.qameta.allure.Step;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (nameIsNull(name)) {
            return false;
        } else if (nameIsEmpty(name)) {
            return false;
        } else if (nameIsToLong(name)) {
            return false;
        } else if (nameIsToShort(name)) {
            return false;
        } else if (nameIsBlank(name)) {
            return false;
        } else if (nameIsStartWithBlank(name)) {
            return false;
        } else if (nameIsEndWithBlank(name)) {
            return false;
        } else if (nameIsWithoutSurname(name)) {
            return false;
        } else return !nameIsWithPatronymic(name);
    }

    @Step("Имя отсутствует")
    public boolean nameIsEmpty(String name) {
        return name.isEmpty();
    }

    @Step("Имя слишком длинное")
    public boolean nameIsToLong(String name) {
        return name.length() > 19;
    }

    @Step("Имя слишком короткое")
    public boolean nameIsToShort(String name) {
        return name.length() < 3;
    }

    @Step("Имя не должно состоять из пробелов")
    public boolean nameIsBlank(String name) {
        return name.isBlank();
    }

    @Step("Имя не должно содержать пробелов в начале")
    public boolean nameIsStartWithBlank(String name) {
        return name.startsWith(" ");
    }

    @Step("Имя не должно содержать пробелов в конце")
    public boolean nameIsEndWithBlank(String name) {
        return name.endsWith(" ");
    }

    @Step("Не указана фамилия")
    public boolean nameIsWithoutSurname(String name) {
        String[] split = name.split(" ");
        return split.length < 2;
    }

    @Step("Отчество не нужно указывать")
    public boolean nameIsWithPatronymic(String name) {
        String[] split = name.split(" ");
        return split.length > 2;
    }

    @Step("Имя Null")
    public boolean nameIsNull(String name) {
        return name == null;
    }
}

