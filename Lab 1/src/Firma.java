import java.util.Scanner;
class Sotrudnik{
    String fam, im, otch, doljnost;
    int oklad;
}
   // клас у вигляді структури з полями fam, im, otch, doljnost, oklad

public class Firma{		// головний клас
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in,"cp1251");
        System.out.println("Введіть кількість співробітників => ");
        int kol = sc.nextInt();
        sc.nextLine();				//очищення буфера після введення числа
        Sotrudnik[] sotr = new Sotrudnik[kol];//отримано посилання на масив співробітників
        System.out.println("Введіть інформацію про кожного співробітника:");
        for (int i = 0; i < sotr.length; i++) {
            sotr[i]=new Sotrudnik();	// отримано посилання на i-тий елемент

// Присвоєння значень полям
            System.out.print("Введіть прізвище "+(i+1)+" співробітника => ");
            sotr [i]. fam = sc.nextLine ();

            System.out.print("Введіть його ім'я => ");
            sotr[i].im=sc.nextLine();

            System.out.print("Введіть його по батькові => ");
            sotr[i].otch=sc.nextLine();

            System.out.print("Введіть його посаду => ");
            sotr[i].doljnost=sc.nextLine();

            System.out.print("Введіть його оклад => ");
            sotr[i].oklad=sc.nextInt();
            sc.nextLine(); 				//очищення буфера
        } 							// end for
// Виведення інформації про співробітників
        System.out.println("\nСпівробітники фірми:\n фам\tім'я\tотч\t посада \tОклад");
        for (Sotrudnik s: sotr) {

            System.out.println(s.fam+ "\t"+s.im + "\t"+s.otch
                    + "\t" +s.doljnost + "\t\t"+s.oklad);

        }

    }

}

