package ru.academy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int N = 5; // количество бегунов
        FinishRegister register = new FinishRegister();
        Thread[] runners = new Thread[N];

        for (int i = 0; i < N; i++) {
            String runnerName = "r" + (i + 1);
            runners[i] = new Thread(new Runner(runnerName, register));
            runners[i].start();
        }

        for (Thread runner : runners) {
            runner.join();
        }

        System.out.println("\nРезультаты гонки:");
        System.out.println("Победитель: " + register.getFirstFinisher());
        System.out.println("Последний: " + register.getLastFinisher());
    }
}