//package recordcountry;
import java.util.Scanner;
class Film{
    String name; // назва фільму
    int year; // рік випуску
    String country; // країна
    double price; // ціна
    String genre; // жанр
}
public class RecordFilm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
// Введення інформації про фільм
        System.out.println("Введіть кількість фільмів =>");
        int n = sc.nextInt(); // кількість фільмів
        Film film[] = new Film[n];
        System.out.println("Введіть інформацію про фільми:");
        for (int i = 0; i < film.length; i++) {
            sc.nextLine(); // очищення буфера
            film[i] = new Film();
            System.out.print("Назва" + " " + (i + 1) + "-ого фільму => ");
            film[i].name = sc.nextLine();
            System.out.print("Рік виходу" + " " + (i + 1) + "-ого фільму => ");
            film[i].year = sc.nextInt();
            System.out.print("Країна виробництва " + " " + (i + 1) + "-ого фільму => ");
            film[i].country = sc.next();
            System.out.print("Ціна" + " " + (i + 1) + "-ого фільму => ");
            film[i].price = sc.nextDouble();
            System.out.print("Жанр" + " " + (i + 1) + "-ого фільму => ");
            film[i].genre = sc.next();
        }
        // Виведення отриманої інформації
        System.out.println("\nХарактеристики фільму:");
        for (int i = 0; i < film.length; i++) {
            System.out.println("" + film[i].name + "\t" + film[i].year + " рік"
                    + "\t" + film[i].country + "\t" + film[i].genre + "\t" + film[i].price + " .грн");
        }

        // Ціна більше середньої
        double s = 0; //сумарна ціна
        for (int i = 0; i < film.length; i++)
            s += film[i].price;
        double sr = s / film.length;
        ; // середня ціна
        System.out.println("Середня ціна фільму = " + sr);
        System.out.println("\nФільм,з ціною більше середньої ");
        for (int i = 0; i < film.length; i++) {
            if (film[i].price > sr)
                System.out.println(film[i].name + "\t" + film[i].price + " .грн");
        }

        // Найстаріший фільм
        int nommin = 0; //номер елемента для найстарішого фільму(початкове значення)
        double min = film[nommin].year; //мінімальне значення року(початкове значення)
        for (int i = 0; i < film.length; i++)
            if (film[i].year < min) {
                min = film[i].year;
                nommin = i;
            }
        System.out.println("\nНайдавніший фільм ");
        System.out.println("" + film[nommin].name + "\t" + film[nommin].year + " рік");

        // Сортування данних за абеткою
        for (int i = 0; i < film.length - 1; i++)
            for (int j = 0; j < film.length - i - 1; j++)
                if (film[j].name.compareTo(film[i + 1].name) > 0) {
                    Film sort = film[j]; //sort – змінна для перестановки
                    film[j] = film[j + 1];
                    film[j + 1] = sort;
                }
        System.out.println("\nВідсортований список за назвою: ");
        for (int i = 0; i < film.length; i++) {
            System.out.println("" + film[i].name + "\t" + film[i].year + " рік"
                    + "\t" + film[i].country + "\t" + film[i].genre + "\t" + film[i].price + " .грн");
        }

        // Пошук за назвою
        sc.nextLine(); // очищення буфера
        System.out.println("Введіть назву шуканого фільму => ");
        String name = sc.nextLine();
        int nom = -1;  //−1 – країна з шуканою назвою відсутня
        for (int i = 0; i < film.length; i++)
            if (name.equalsIgnoreCase(film[i].name)) nom = i;
        if (nom != -1) {
            System.out.println("Така назва є у списку. Це " + film[nom].name + "\t" + film[nom].year + " рік"
                    + "\t" + film[nom].country + "\t" + film[nom].genre + "\t" + film[nom].price + " .грн");
        } else System.out.println("Такої країни немає у списку");

        //Редагування фільму
        System.out.println("\nЯкщо хочете відредагувати фільм напишіть: 'n' - назва фільму, 'y' - рік виходу фільму, 'p' - ціна фільму, 'g' - жанр фільму.");
        System.out.println("=> ");
        String in = sc.nextLine();
        switch (in) {
            case "n": {
                System.out.println("Введіть нову назву фільму:");
                String newvar = sc.nextLine();
                film[nom].name = newvar;
                break;
            }
            case "y": {
                System.out.println("Введіть новий рік фільму:");
                int newvar = sc.nextInt();
                film[nom].year = newvar;
                break;
            }
            case "p": {
                System.out.println("Введіть нову ціну фільму:");
                int newvar = sc.nextInt();
                film[nom].price = newvar;
                break;
            }
            case "g": {
                System.out.println("Введіть новий жанр фільму:");
                String newvar = sc.nextLine();
                film[nom].genre = newvar;
                break;
            }
            default: {
                System.out.println("Ви ввели не правильні данні!");
            }
        }
        System.out.println("\nОновленні дані про фільм: " + "\n" + "" + film[nom].name + "\t" + film[nom].year + " рік"
                + "\t" + film[nom].country + "\t" + film[nom].genre + "\t" + film[nom].price + " .грн");
    }
}

