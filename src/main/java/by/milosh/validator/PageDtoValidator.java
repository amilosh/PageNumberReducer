package by.milosh.validator;

import by.milosh.exception.IncorrectFormatException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PageDtoValidator {

    private static final String ALLOWED_SYMBOLS = "(\\d+)(,\\d+)*";

    public void validate(String raw) throws IncorrectFormatException {
        if (!raw.matches(ALLOWED_SYMBOLS)) {
            throw new IncorrectFormatException("Incorrect format. List of pages should be contains only commas and numbers without spaces.");
        } else if (containsEqualElements(raw)) {
            throw new IncorrectFormatException("Incorrect format. List contains the same numbers in different places.");
        }
    }

    private boolean containsEqualElements(String raw) {
        String[] array = raw.split(",");
        Set<String> set = new HashSet<String>();
        for (String string : array) {
            if (set.contains(string)) return true;
            set.add(string);
        }
        return false;
    }
}
