public class Validator {

    /**
     * Checks if the given input is a number and not less than 0.
     * @param input the input from the user
     * @return true or false depending on the result
     */
    public boolean validateInput(String input) {
        if (!isNumber(input)) {
            return false;
        } else return isBiggerOrEqualToZero(input);
    }

    /**
     * Checks if the given string is a valid number or not
     * @param input the input from the user
     * @return true or false depending on the result
     */
    private boolean isNumber(String input) {
        try {
            Long.parseLong(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if the given input is a number that not less than 0
     * @param input the input from the user
     * @return true or false depending on the result
     */
    private boolean isBiggerOrEqualToZero(String input) {
        long number = Long.parseLong(input);
        return number >= 0;
    }
}
