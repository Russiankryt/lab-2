
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Laba2 {

    public static void main(String[] args) {
        // Установка кодировки UTF-8 для консоли
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println("UTF-8 encoding is not supported!");
        }

        Establishment cafe = new Cafe("Уютное кафе", "Кофе и выпечка");
        Establishment shop = new Shop("Все для дома", "Посуда и текстиль");
        Establishment library = new Library("Центральная библиотека", "Книги и остальное");

        cafe.describe();
        shop.describe();
        library.describe();

        System.out.println("Всего создано заведений: " + Establishment.getEstablishmentCount());
    }
}

abstract class Establishment {

    private final String name; // Сделано final
    private final String specialty; // Сделано final
    private static int establishmentCount = 0;

    public Establishment(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
        establishmentCount++;
        System.out.println("Создано заведение: " + name + " (Специализация: " + specialty + ")");
    }

    public abstract void describe();

    public String getName() {
        return name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public static int getEstablishmentCount() {
        return establishmentCount;
    }
}

class Cafe extends Establishment {

    public Cafe(String name, String specialty) {
        super(name, specialty);
    }

    @Override
    public void describe() {
        System.out.println(getName() + " предлагает " + getSpecialty());
    }
}

class Shop extends Establishment {

    public Shop(String name, String specialty) {
        super(name, specialty);
    }

    @Override
    public void describe() {
        System.out.println(getName() + " продает " + getSpecialty());
    }
}

class Library extends Establishment {

    public Library(String name, String specialty) {
        super(name, specialty);
    }

    @Override
    public void describe() {
        System.out.println(getName() + " имеет " + getSpecialty());
    }
}
