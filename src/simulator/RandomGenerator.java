package simulator;

import java.util.Random;

public class RandomGenerator {
    private int randomNumber = 0;

    public int getRandomNumber() {
        return randomNumber;
    }
    public int createRandomNumber(int bounder){
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(bounder);
    }

}
