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

    public static String format(String fullName) {
        String[] nameAndSuffix = fullName.split(",", 2);
        String[] nameParts = nameAndSuffix[0].trim().split("\\s+");

        String prefix = "";
        String firstName;
        String middleName = "";
        String lastName = nameParts[nameParts.length - 1];
        String suffix = "";

        int startIndex = 0;

        if (nameParts[0].endsWith(".")) {
            prefix = nameParts[0];
            startIndex = 1;
        }

        firstName = nameParts[startIndex];

        if (nameParts.length - startIndex > 2) {
            middleName = nameParts[startIndex + 1];
        }

        if (nameAndSuffix.length > 1) {
            suffix = nameAndSuffix[1].trim();
        }

        return format(prefix, firstName, middleName, lastName, suffix);
    }

    private static boolean hasText(String text) {
        return text != null && !text.isBlank();
    }
}
