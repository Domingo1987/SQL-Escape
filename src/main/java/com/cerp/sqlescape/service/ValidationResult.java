package com.cerp.sqlescape.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Result of a syntax validation process.
 */
public class ValidationResult {
    private boolean valid;
    private List<String> errors = new ArrayList<>();
    private List<String> warnings = new ArrayList<>();

    public ValidationResult(boolean isValid) {
        this.valid = isValid;
    }

    public void addError(String error) {
        errors.add(error);
    }

    public void addWarning(String warning) {
        warnings.add(warning);
    }

    public List<String> getErrors() {
        return errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public boolean isValid() {
        return valid && errors.isEmpty();
    }
}
