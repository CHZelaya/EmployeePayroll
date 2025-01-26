package org.example;

import java.time.LocalDate;

public enum AlbertaHoliday {
    NEW_YEAR(LocalDate.of(2025, 1, 1)), // New Year's Day
    FAMILY_DAY(LocalDate.of(2025, 2, 17)), // Family Day (3rd Monday in February)
    GOOD_FRIDAY(LocalDate.of(2025, 4, 18)), // Good Friday
    EASTER_MONDAY(LocalDate.of(2025, 4, 21)), // Easter Monday
    VICTORIA_DAY(LocalDate.of(2025, 5, 19)), // Victoria Day (Monday before May 25)
    CANADA_DAY(LocalDate.of(2025, 7, 1)), // Canada Day
    LABOUR_DAY(LocalDate.of(2025, 9, 1)), // Labour Day (1st Monday in September)
    THANKSGIVING(LocalDate.of(2025, 10, 13)), // Thanksgiving (2nd Monday in October)
    REMEMBRANCE_DAY(LocalDate.of(2025, 11, 11)), // Remembrance Day
    CHRISTMAS(LocalDate.of(2025, 12, 25)), // Christmas
    BOXING_DAY(LocalDate.of(2025, 12, 26)), // Boxing Day
    HERITAGE_DAY(LocalDate.of(2025, 8, 4)), // Heritage Day
    NATIONAL_DAY_OF_TRUTH_AND_RECONCILIATION(LocalDate.of(2025, 9, 30)); // National Day of Truth and Reconciliation

    private final LocalDate date;

    AlbertaHoliday(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFormattedDate() {
        return String.format("%02d-%02d-%04d", date.getDayOfMonth(), date.getMonthValue(), date.getYear());
    }
}