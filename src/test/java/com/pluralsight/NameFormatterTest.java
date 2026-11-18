package com.pluralsight;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class NameFormatterTest {

    @Test
    public void format_should_returnLastNameCommaFirstName() {
        assertEquals("Johnson, Mel", NameFormatter.format("Mel", "Johnson"));
    }

    @Test
    public void format_should_includeAllNameComponents() {
        assertEquals("Johnson, Dr. Mel B, PhD", NameFormatter.format("Dr.", "Mel", "B", "Johnson", "PhD"));
    }

    @Test
    public void format_should_excludeEmptyOptionalComponents() {
        assertEquals("Johnson, Mel", NameFormatter.format("", "Mel", "", "Johnson", ""));
    }

    @Test
    public void format_should_excludeNullOptionalComponents() {
        assertEquals("Johnson, Mel", NameFormatter.format(null, "Mel", null, "Johnson", null));
    }

    @Test
    public void format_should_excludeWhitespaceOptionalComponents() {
        assertEquals("Johnson, Mel", NameFormatter.format(" ", "Mel", " ", "Johnson", " "));
    }

    @Test
    public void format_should_includeMiddleNameAndSuffixWithoutPrefix() {
        assertEquals("Johnson, Mel B, PhD", NameFormatter.format("", "Mel", "B", "Johnson", "PhD"));
    }

    @Test
    public void format_should_includePrefixWithoutMiddleNameOrSuffix() {
        assertEquals("Johnson, Dr. Mel", NameFormatter.format("Dr.", "Mel", "", "Johnson", ""));
    }

    @Test
    public void formatFullName_should_formatNameWithAllComponents() {
        assertEquals("Johnson, Dr. Mel B, PhD", NameFormatter.format("Dr. Mel B Johnson, PhD"));
    }

    @Test
    public void formatFullName_should_formatNameWithoutOptionalComponents() {
        assertEquals("Johnson, Mel", NameFormatter.format("Mel Johnson"));
    }

    @Test
    public void formatFullName_should_formatNameWithoutPrefix() {
        assertEquals("Johnson, Mel B, PhD", NameFormatter.format("Mel B Johnson, PhD"));
    }
}