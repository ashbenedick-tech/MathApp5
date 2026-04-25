package com.example.MathApp5;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MathApp5 {

    private static final Logger logger = Logger.getLogger(MathApp5.class.getName());

    public static int max(int number1, int number2) {
        return (number1 > number2) ? number1 : number2;
    }

    public static double average(int number1, int number2) {
        return (number1 + number2) / 2.0;
    }

    private static void runCalculation(int number1, int number2) {
        int maxResult = max(number1, number2);
        double averageResult = average(number1, number2);

        logger.info("Input values: " + number1 + ", " + number2);
        logger.info("Max result: " + maxResult);
        logger.info("Average result: " + averageResult);

        System.out.println("max(" + number1 + ", " + number2 + ") = " + maxResult);
        System.out.println("average(" + number1 + ", " + number2 + ") = " + averageResult);
    }

    public static void main(String[] args) {
        String environment = System.getenv().getOrDefault("APP_ENV", "local");
        String keepAliveSecondsText = System.getenv().getOrDefault("KEEP_ALIVE_SECONDS", "60");
        String simulateFailure = System.getenv().getOrDefault("SIMULATE_FAILURE", "false");

        logger.info("MathApp5 started");
        logger.info("Environment: " + environment);
        logger.info("KEEP_ALIVE_SECONDS: " + keepAliveSecondsText);

        try {
            runCalculation(5, 15);
            runCalculation(37, -11);

            if ("true".equalsIgnoreCase(simulateFailure)) {
                throw new RuntimeException("Simulated application failure for incident response demo.");
            }

            int keepAliveSeconds = Integer.parseInt(keepAliveSecondsText);
            logger.info("Application will stay running for " + keepAliveSeconds + " seconds.");

            Thread.sleep(keepAliveSeconds * 1000L);

            logger.info("MathApp5 completed successfully in " + environment + " environment.");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Application error occurred: " + e.getMessage(), e);
            System.exit(1);
        }
    }
}