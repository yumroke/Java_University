import java.util.InputMismatchException;
import java.util.Scanner;

public class test {
        public static void Input(int[][] massive, Scanner sc){
            //Введення масиву
            for(int i = 0; i < massive.length; i++) {
                for(int j = 0; j < massive.length; j++) {
                    System.out.print("Введіть число матриці [" + (i + 1) + "][" + (j+1) + "]");
                    massive[i][j] = sc.nextInt();
                }
            }
        }

        public static int Find(int[][] massive, Scanner sc, int j){
            //Пошук стовпця
            int fnumber = sc.nextInt();     //шуканий стовпець
            System.out.println("Стовпець " + fnumber + ": ");
            for (int i = 0; i < massive.length; i++){
                System.out.println(massive[i][fnumber-1]);
            }
            return (int)massive[j][fnumber-1];
        }
        public static void Output(int massive[][], Scanner sc){
            for (int i = 0; i < massive.length; i++){
                Find(massive,sc,i);
            }
        }
        public static void main(String[] arghs) {
            //Головний клас
            int amount_line = 0;     //кількість рядків
            int amount_row = 0;     //кількість стовпців
            int massive[][];   //масив стовпців

            Scanner sc = new Scanner(System.in, "cp1251");

            try {
                System.out.print("Введіть кількість рядків:");
                amount_line = sc.nextInt();

                System.out.print("Введіть кількість стовпців:");
                amount_row = sc.nextInt();

                massive = new int[amount_line][amount_row];
                Input(massive,sc);

                System.out.print("Введіть шуканий стовпець:");
                try {
                    Output(massive,sc);
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Немає стовпця з таким номером.");
                }
                catch (InputMismatchException e){
                    System.out.println("Ви ввели рядок замість числа.");
                }
            }
            catch (InputMismatchException e){
                System.out.println("Ви ввели рядок замість числа.");
            }
        }
    }

