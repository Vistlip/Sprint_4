public class Praktikum {

    public static void main(String[] args) {
        String name = "Петр Великий";
        Account account = new Account(name);
        if (account.checkNameToEmboss()) {
            System.out.println("Имя: " + name + " - можно использовать");
        } else {
            System.out.println("Имя: " + name + " - нельзя использовать");
        }
    }

}

