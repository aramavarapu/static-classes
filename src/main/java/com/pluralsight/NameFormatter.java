package com.pluralsight;

public class NameFormatter {

    private NameFormatter() {
    }

    public static String format(String firstName, String lastName) {
        return lastName + ", " + firstName;
    }

    public static String format(String prefix, String firstName, String middleName, String lastName, String suffix) {
        String name = lastName + ", ";
        if (hasText(prefix)) {
            name += prefix + " ";
        }

        name += firstName;

        if (hasText(middleName)) {
            name += " " + middleName;
        }

        if (hasText(suffix)) {
            name += ", " + suffix;
        }

        return name;
    }

    private static boolean hasText(String text) {
        return text != null && !text.isBlank();
    }
}
