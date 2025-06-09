package ru.academy;

public class Runner implements Runnable {
    private final String name;
    private final FinishRegister register;
    public Runner(String name, FinishRegister register) {
        this.name = name;
        this.register = register;

    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep((long) (Math.random() * 2000));//скорость между барьерами, меняется после каждоо барьера
                System.out.println("Бегун " + name + " преодолел барьер №" + i);
            }

            register.register(name);
            System.out.println("Бегун " + name + " финишировал");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(name + " был прерван!");
        }
    }
}