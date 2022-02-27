public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        String[] split = name.split(" ");

        if (name.isEmpty()) {
            System.out.println("Имя отсутствует.");
            return false;
        } else if (name.length() > 19) {
            System.out.println("Имя слишком длинное");
            return false;
        } else if (name.length() < 3) {
            System.out.println("Имя слишком короткое.");
            return false;
        } else if (name.isBlank()) {
            System.out.println("Имя не должно состоять из пробелов");
            return false;
        } else if (name.startsWith(" ")) {
            System.out.println("Имя не должно содержать пробелов в начале");
            return false;
        } else if (name.endsWith(" ")) {
            System.out.println("Имя не должно содержать пробелов в конце");
            return false;
        } else if (split.length<2) {
            System.out.println("Имя должно состоять из имени и фамилии");
            return false;
        } else if (split.length>2) {
            System.out.println("Имя должно состоять из имени и фамилии");
            return false;
        }
        System.out.println("Подходящее имя");
        return true;
    }
}
