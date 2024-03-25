package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        montiHallDontChange();


        montiHallChange();




        //метод генерации комбинации  из двух козликов и машины. Генерим массив из трех козлов  рандом в интеревале о-2 меняем одно
        //значение на машину


    }


    //выбрали рандомную дверь, выбор не меняем, возвращаем стрингу с овтетом
    public static String chosingDoorNotChange(List<String> goatsCar) {
        Random r = new Random();
        int x = r.nextInt(3);
        String result = goatsCar.get(x);
        return result;

    }

    //выбрали рандомную дверь, выбор не меняем, возвращаем стрингу с овтетом
    public static String chosingDoorChange(List<String> goatsCar) {




        Random r = new Random();
        int firstChoice = r.nextInt(3);





        int indexOfGoatAfterFirstChoice = 0;
        for (int i = 0; i <=2 ; i++) {
            if (i != firstChoice){

                String findGoatInTwoDoors = goatsCar.get(i);

                if (findGoatInTwoDoors == "goat"){





                    indexOfGoatAfterFirstChoice=i;



                }
            }

        }

        //у нас есть индекс первого выбор и индекс козла после первого  выбора. Значит результат будет

        String resultChoice="";
        for (int i = 0; i <=2 ; i++) {
            if (i != firstChoice && i != indexOfGoatAfterFirstChoice){

                resultChoice=goatsCar.get(i);



            }

        }



        return resultChoice;





    }

    public static void montiHallDontChange() {
        HashMap<Integer, String> stepResult = new HashMap<>();


        int carCounter = 0;
        int goatCounter = 0;
        int step = 0;


        for (int i = 0; i < 1000; i++) {
            step = i + 1;
            //создаем масиив из трех "дверей" в

            List goats = goatCarArrayGeneration();
            String reusltChoosing = chosingDoorNotChange(goats);
            stepResult.put(step, reusltChoosing);
            if (reusltChoosing == "Car") {
                carCounter = carCounter + 1;
            }
            if (reusltChoosing == "goat") {
                goatCounter = goatCounter + 1;
            }

        }

        System.out.println("Тест, сценария, когда мы не меняем выбор. Пройдено итераций = " + step + ", Автомобиль выпал " + carCounter + " раз, " + " козел выпал " +
                goatCounter + " раз");
        System.out.println(stepResult);


    }


    public static List goatCarArrayGeneration() {

        Random r = new Random();
        int x = r.nextInt(3);

        List<String> goats = new ArrayList<>();
        goats.add("goat");
        goats.add("goat");
        goats.add("goat");
        goats.set(x, "Car");


        return goats;


    }

    public static void montiHallChange() {
        HashMap<Integer, String> stepResult = new HashMap<>();

        //заводим сычетчики
        int carCounter = 0;
        int goatCounter = 0;
        int step = 0;

        //цикл на 1000
        for (int i = 0; i < 1000; i++) {
            step = i + 1;
            //создаем РАНДОМ  масиив из трех "дверей" в

            List goats = goatCarArrayGeneration();

            //метод РАНДОМ  выбора с изминением двери
            String reusltChoosing = chosingDoorChange(goats);
            //сохраняем в хэшмэп результат
            stepResult.put(step, reusltChoosing);
            if (reusltChoosing == "Car") {
                carCounter = carCounter + 1;
            }
            if (reusltChoosing == "goat") {
                goatCounter = goatCounter + 1;
            }

        }

        System.out.println("Тест, сценария, когда мы МЕНЯЕМ выбор. Пройдено итераций = " + step + ", Автомобиль выпал " + carCounter + " раз, " + " козел выпал " +
                goatCounter + " раз");
        System.out.println(stepResult);

    }

}