/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Создайте зубчатый массив, в котором хранится температура воздуха в нашем городена весь год.
//Массив должен содержать 12 строк, количество столбцов -количество дней в месяце.
//Заполните массив случайными числами. Температура зависит от времени года.
//Программа должна вывести на экран:
//  погоду на указанную дату (месяц, день –пользователь вводит данные с помощью клавиатуры)
//  в какие дни была самая теплая и самая холодная погода
//  среднюю температуру по каждому месяцу
package arrtask2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author spetu
 */
public class ArrTask2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        int [][] yearTemp = new int [12][];
        int temp;
        yearTemp[0] = new int [31];
        yearTemp[1] = new int [28];
        yearTemp[2] = new int [31];
        yearTemp[3] = new int [30];
        yearTemp[4] = new int [31];
        yearTemp[5] = new int [30];
        yearTemp[6] = new int [31];
        yearTemp[7] = new int [31];
        yearTemp[8] = new int [30];
        yearTemp[9] = new int [31];
        yearTemp[10] = new int [30];
        yearTemp[11] = new int [31];
        for (int i = 0; i < 12; i++) {
            System.out.println("Month " + (i+1) + "");
            switch (i) {
                case 0:
                case 1:
                case 11:
                    temp = -15;
                    break;
                case 2:
                case 3:
                case 4:
                    temp = 2;
                    break;
                case 5:
                case 6:
                case 7:
                    temp = 20;
                    break;
                default:
                    temp = 5;
                    break;
            }
            
            for (int j = 0; j < yearTemp[i].length; j++) {
                yearTemp[i][j] = rand.nextInt(10) + temp;
                System.out.println("day " + (j+1) + ". " + "temp: " + yearTemp[i][j] + "°c\t");
            }
        }
        
        System.out.print("\nEnter Month: ");
        int month = scanner.nextInt();
        System.out.print("\nEnter Day: ");
        int day = scanner.nextInt();
        System.out.println("Month: " + month + " Day: " + day + " Temp: " + yearTemp[month-1][day-1]);
        int minTemp = yearTemp[0][0];
        int maxTemp = yearTemp[0][0];
        float[] average = new float[12];
        
        for (int i = 0; i < yearTemp.length; i++){
            for (int j : yearTemp[i])
            {
                if ( j < minTemp) {
                    minTemp = j;
                }
                if ( j > maxTemp) {
                    maxTemp = j;
                }
                average[i] += j;
            }
            average[i] = average[i]/yearTemp[i].length;
        }
        System.out.println("_________________");
        System.out.println("\nMin temp: " + minTemp);
        
        for (int i = 0; i < yearTemp.length; i++){
            for (int j = 0; j < yearTemp[i].length; j++)
            {
                if ( yearTemp[i][j] == minTemp) {
                    System.out.println("Month: " + (i+1) + " Day: " + (j+1));
                }
            } 
        }
        System.out.println("_________________");
        System.out.println("\nMax temp: " + maxTemp);
        for (int i = 0; i < yearTemp.length; i++){
            for (int j = 0; j < yearTemp[i].length; j++)
            {
                if ( yearTemp[i][j] == maxTemp) {
                    System.out.println("Month: " + (i+1) + " Day: " + (j+1));
                }
            } 
        }
        System.out.println("\nAverage temp");
        for (int i = 0; i < average.length; i++){
            System.out.printf((i+1) + "\t%.1f\n", average[i]);
        }
        
        
    } 
}
