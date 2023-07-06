public class DurationConverter {

    /**
     * Converts the input number - duration in seconds - into years, days, hours, minutes and seconds
     * @param duration a number that represents seconds
     * @return a new Duration object with the converted values
     */
    public Duration convertDuration(Long duration) {
        long seconds = 0L;
        long minutes = 0L;
        long hours = 0L;
        long days = 0L;
        long years = 0L;
        Long remainingDuration = duration;

        while (remainingDuration > 0) {
            Long yearInSeconds = 31536000L;
            Long dayInSeconds = 86400L;
            Long hourInSeconds = 3600L;
            Long minuteInSeconds = 60L;

            if (remainingDuration >= yearInSeconds) {
                years = remainingDuration / yearInSeconds;
                remainingDuration = remainingDuration % yearInSeconds;

            } else if (remainingDuration >= dayInSeconds) {
                days = remainingDuration / dayInSeconds;
                remainingDuration = remainingDuration % dayInSeconds;

            } else if (remainingDuration >= hourInSeconds) {
                hours = remainingDuration / hourInSeconds;
                remainingDuration = remainingDuration % hourInSeconds;

            } else if (remainingDuration >= minuteInSeconds) {
                minutes = remainingDuration / minuteInSeconds;
                remainingDuration = remainingDuration % minuteInSeconds;

            } else {
                seconds = remainingDuration;
                remainingDuration = 0L;
            }
        }

        return new Duration(years, days, hours, minutes, seconds);
    }
}
