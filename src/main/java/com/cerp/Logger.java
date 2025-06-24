package com.cerp;

/**
 * Simple logger utility for console output.
 */
public class Logger {
    public static void log(String message) {
        System.out.println("[LOG] " + message);
    }

        // Códigos de color ANSI
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
        public static final String RESET = "\u001B[0m";

        // Estilos
        public static final String BOLD = "\u001B[1m";
        public static final String UNDERLINE = "\u001B[4m";

        public static void logRed(String message) {
            System.out.println(RED + BOLD + "🔴 " + message + RESET);
        }

        public static void logError(String message) {
            System.out.println(RED + BOLD + "❌ ERROR: " + message + RESET);
        }

        public static void logTest(String message) {
            System.out.println(RED + BOLD + "🧪 TEST: " + message + RESET);
        }



}
