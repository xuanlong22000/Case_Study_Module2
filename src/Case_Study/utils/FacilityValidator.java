package Case_Study.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FacilityValidator {
    private static final String FACILITY_CODE_PATTERN = "^(VL|HO|RO)\\d{2}-\\d{4}$";
    private static final String NAME_PATTERN = "[A-Z][a-z]*";
    private static final Pattern FACILITY_CODE_REGEX = Pattern.compile(FACILITY_CODE_PATTERN);
    private static final Pattern NAME_REGEX = Pattern.compile(NAME_PATTERN);
    private static final int MIN_AREA = 30;
    private static final int MIN_CAPACITY = 1;
    private static final int MAX_CAPACITY = 19;
    private static final int MIN_FLOORS = 1;

    public void validateFacility(String facilityCode, String name, double area, double poolArea, double rentalCost, int maxCapacity, int floors,String birthday) throws InvalidDataException {
        validateFacilityCode(facilityCode);
        validateName(name);
        validateArea(area);
        validateArea(poolArea);
        validateRentalCost(rentalCost);
        validateCapacity(maxCapacity);
        validateFloors(floors);
        validateBirthday(birthday);
    }

    private void validateFacilityCode(String facilityCode) throws InvalidDataException {
        Matcher matcher = FACILITY_CODE_REGEX.matcher(facilityCode);
        if (!matcher.matches()) {
            throw new InvalidDataException("Invalid facility code format! Facility code must be in format SVXX-YYYY, where XX is VL, HO, or RO and YYYY is a 4-digit number.");
        }
    }

    private void validateName(String name) throws InvalidDataException {
        Matcher matcher = NAME_REGEX.matcher(name);
        if (!matcher.matches()) {
            throw new InvalidDataException("Invalid name format! Name must start with an uppercase letter followed by lowercase letters.");
        }
    }

    private void validateArea(double area) throws InvalidDataException {
        if (area <= MIN_AREA) {
            throw new InvalidDataException("Invalid area! Area must be greater than 30m2.");
        }
    }

    private void validateRentalCost(double rentalCost) throws InvalidDataException {
        if (rentalCost <= 0) {
            throw new InvalidDataException("Invalid rental cost! Rental cost must be a positive number.");
        }
    }

    private void validateCapacity(int capacity) throws InvalidDataException {
        if (capacity <= MIN_CAPACITY || capacity >= MAX_CAPACITY) {
            throw new InvalidDataException("Invalid capacity! Capacity must be greater than 0 and less than 20.");
        }
    }

    private void validateFloors(int floors) throws InvalidDataException {
        if (floors <= MIN_FLOORS) {
            throw new InvalidDataException("Invalid number of floors! Number of floors must be a positive integer.");
        }
    }

    public void validateBirthday(String birthday) throws InvalidDataException {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthDate = LocalDate.parse(birthday, formatter);

        if (birthDate.plusYears(18).isAfter(currentDate)) {
            throw new InvalidDataException("Invalid birthday! Must be at least 18 years old.");
        }

        if (birthDate.isBefore(currentDate.minusYears(100))) {
            throw new InvalidDataException("Invalid birthday! Age cannot exceed 100 years.");
        }
    }
}
