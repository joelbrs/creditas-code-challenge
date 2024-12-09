package br.com.joelf.creditasbackend.application.usecases.strategies;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
interface TriPredicate<T, U, V> {
    boolean test(T t, U u, V v);
}

public class CollateralizedLoanStrategy implements EligiblityStrategy {

    private static final Integer VALID_MAX_AGE = 29;
    private static final String VALID_LOCATION = "SP";

    private static final Map<String, TriPredicate<BigDecimal, String, Integer>> CRITERIAS = new HashMap<>();

    static {
        CRITERIAS.put("first", (income, location, age) -> isLessThan3000(income) && isLocationValid(location) && isAgeValid(age));
        CRITERIAS.put("second", (income, location, age) -> isBetween3000And5000(income) && isLocationValid(location));
        CRITERIAS.put("third", (income, location, age) -> isHigherThan5000(income) && isAgeValid(age));
    }

    @Override
    public boolean isEligible(BigDecimal income, String location, Integer age) {
        return CRITERIAS.entrySet().stream()
                .anyMatch(entry -> entry.getValue().test(income, location, age));
    }

    private static boolean isLessThan3000(BigDecimal income) {
        return income.compareTo(BigDecimal.valueOf(3000)) <= 0;
    }

    private static boolean isBetween3000And5000(BigDecimal income) {
        return !isLessThan3000(income) && income.compareTo(BigDecimal.valueOf(5000)) < 0;
    }

    private static boolean isHigherThan5000(BigDecimal income) {
        return !isLessThan3000(income) && !isBetween3000And5000(income);
    }

    private static boolean isAgeValid(Integer age) {
        return age != null && age >= 18 && age <= VALID_MAX_AGE;
    }

    private static boolean isLocationValid(String location) {
        return location != null && location.equals(VALID_LOCATION);
    }
}
