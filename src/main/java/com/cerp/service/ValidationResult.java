package com.cerp.service;

import java.util.ArrayList;
import java.util.List;
import com.cerp.Logger;

/**
 * Result of a syntax validation process.
 */
public class ValidationResult {
    private boolean valid;
    private List<String> errors = new ArrayList<>();
    private List<String> warnings = new ArrayList<>();

    public ValidationResult(boolean isValid) {
        Logger.log("ValidationResult.<init>");
        this.valid = isValid;
    }

    public void addError(String error) {
        Logger.log("ValidationResult.addError");
        errors.add(error);
    }

    public void addWarning(String warning) {
        Logger.log("ValidationResult.addWarning");
        warnings.add(warning);
    }

    public List<String> getErrors() {
        Logger.log("ValidationResult.getErrors");
        return errors;
    }

    public List<String> getWarnings() {
        Logger.log("ValidationResult.getWarnings");
        return warnings;
    }

    public boolean hasErrors() {
        Logger.log("ValidationResult.hasErrors");
        return !errors.isEmpty();
    }

    public boolean isValid() {
        Logger.log("ValidationResult.isValid");
        return valid && errors.isEmpty();
    }
}
