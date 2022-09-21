import java.util.Scanner;
class Film2 {
    String name, genre,country; //назва фільму,жанр,країна
    int year; // рік
    double price; //ціна фільму
}
public class RecordFilm2 {
    public static Film2[] setFilmArr(int k) {
        //Введення массиву фільмів
        Scanner sc = new Scanner(System.in, "cp1251");
        Film2 film2[] = new Film2[k];
        System.out.println("Введіть інформацію про фільми:");
        for (int i = 0; i < film2.length; i++) {
            film2[i] = new Film2();
            System.out.print("Назва" + " " + (i + 1) + "-ого фільму => ");
            film2[i].name = sc.nextLine();
            System.out.print("Рік виходу" + " " + (i + 1) + "-ого фільму => ");
            film2[i].year = sc.nextInt();
            System.out.print("Країна виробництва " + " " + (i + 1) + "-ого фільму => ");
            film2[i].country = sc.next();
            System.out.print("Ціна" + " " + (i + 1) + "-ого фільму => ");
            film2[i].price = sc.nextDouble();
            System.out.print("Жанр" + " " + (i + 1) + "-ого фільму => ");
            film2[i].genre = sc.next();
            sc.nextLine(); // очищення буфера
        }
        return film2;
    }
    public static void showArray(Film2[] movie) {
        //Виведення масиву
        for (int i = 0; i < movie.length; i++) {
            System.out.println("" + movie[i].name + "\t" + movie[i].year + " рік"
                    + "\t" + movie[i].country + "\t" + movie[i].genre + "\t" + movie[i].price + " .грн");
        }
    }
    public static void showFilm(Film2 movie) {
        //Інформація про один фільм
        System.out.println("" + movie.name + "\t" + movie.year + " рік"
                + "\t" + movie.country + "\t" + movie.genre + "\t" + movie.price + " .грн");
    }
    public static int Oldestmovie(Film2[] movie) {
        //Найстаріший фільм
        int nommin = 0; //номер елемента для найстарішого фільму(початкове значення)
        double min = movie[nommin].year; //мінімальне значення року(початкове значення)
        for (int i = 0; i < movie.length; i++)
            if (movie[i].year <min){
                min = movie[i].year;
                nommin = i;
            }
        return nommin;
    }
    public static double avgPrice(Film2[] movie) {
        //Середня ціна
        double s = 0; //сумарна ціна всіх фільмів
        for (int i = 0; i < movie.length; i++)
            s += movie[i].price;
        double sr = s / movie.length; //середня ціна
        return sr;
    }
    public static Film2[] PriceMoreavg(Film2 movie[]) {
        //Фільм зціною більше середньої
        double sred = avgPrice(movie);
        int kol = 0; //к-сть фільмів
        for (int i = 0; i < movie.length; i++) {
            if (movie[i].price > sred)
                ++kol;
        }
        if (kol != 0) {
            Film2[] BigPrice = new Film2[kol];
            int n = -1;
            for (int i = 0; i < movie.length; i++)
                if (movie[i].price > sred) {
                    BigPrice[++n] = movie[i];
                }
            return BigPrice;
        } else return null;
    }
    public static void sortName(Film2 [] movie) {
// Сортування фільмів за назвою
        for (int i = 0; i < movie.length-1; i++)
        for (int j = 0; j < movie.length-i-1; j++)
        if(movie[j].name.compareTo(movie[i+1].name)>0){
            Film2 rab=movie[j]; // rab – робоча змінна для перестановки
            movie[j]=movie[j+1];
            movie[j+1]=rab;
        }
    }
    public static Film2 findForName(Film2 movie[], String name) {
        //Пошук фільму за назвою
        int n=-1; //-1-шуканий фільм відсутній
        for (int i=0;i< movie.length;i++)
            if (name.equalsIgnoreCase(movie[i].name))
                n=i;
        if (n!=-1) {
            return movie[n];
        } else return null;
    }
    public static void editFilm(String name, Film2 movie[], Scanner sc) { //редагування масиву
        int nom = -1;
        for (int i = 0; i < movie.length; i++)
            if (name.equalsIgnoreCase(movie[i].name)) nom = i;
        if (nom != -1) {
            System.out.println("\nЯкщо хочете відредагувати фільм напишіть: 'n' - назва фільму, 'y' - рік виходу фільму, 'p' - ціна фільму, 'g' - жанр фільму.");
            System.out.println("=> ");
            String in = sc.nextLine();
            switch (in) {
                case "n": {
                    System.out.println("Введіть нову назву фільму:"); String newvar = sc.nextLine();
                    movie[nom].name = newvar;
                    break;
                }
                case "y": {
                    System.out.println("Введіть новий рік виходу фільму:"); String newvar = sc.nextLine();
                    movie[nom].genre = newvar;
                    break;
                }
                case "p": {
                    System.out.println("Введіть нову ціну фільму:"); int newvar = sc.nextInt();
                    movie[nom].price = newvar;
                    break;
                }
                case "g": {
                    System.out.println("Введіть новий жанр фільму:");
                    int newvar = sc.nextInt();
                    movie[nom].year = newvar;
                    break;
                }
                default: {
                    System.out.println("Ви ввели не правильні данні! Будь ласка спробуйте ще раз:");
                    editFilm(name, movie, sc);
                }
            }
            System.out.println("\nОновленні дані про фільм: " + "\n" + ""+ movie[nom].name + "\t" + movie[nom].year + " рік"
                    + "\t" + movie[nom].country + "\t" + movie[nom].genre + "\t" + movie[nom].price + " .грн");
        }
    }
    public static void main(String[] args) {
        //Головний клас з методами
        Scanner sc = new Scanner(System.in, "cp1251");
        System.out.print("Введіть кількість фільмів => ");
        int n = sc.nextInt(); //к-сть фільмів
        Film2 film2[] = setFilmArr(n); //Введення інформації фільми
        System.out.println("\nХарактеристика фільмів: ");
        showArray(film2); // Виведення отриманої інформації
        //Найстаріший фільм
        int nommin = Oldestmovie(film2);
        System.out.println("\nНайстаріший фільм: "); showFilm(film2[nommin]);
        //Середня ціна
        System.out.println("Середня ціна фільмів: "+ avgPrice(film2));
        //Фільм з ціною більше середньої
        System.out.println("\nФільм з ціною більше середньої: "); Film2[] biggestprice = PriceMoreavg(film2);
        showArray(biggestprice);
        //Сортування фільмів за абеткою
        sortName(film2);
        System.out.println("\nВідсортований список фільмів за абеткою: "); showArray(film2);
        //Пошук за назвою та редагування фільму
        System.out.println("\nВведіть назву шуканого фільму => ");
        sc.nextLine();
        String sname = sc.nextLine();
        Film2 sfind = findForName(film2, sname);
        if (sfind != null) {
            showFilm(sfind);
            editFilm(sname,film2,sc);
        } else {
            System.out.println("Такого фільму немає у списку!");
        }
    }
}
