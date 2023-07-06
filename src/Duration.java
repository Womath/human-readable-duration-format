/**
 * A duration class for holding the years, days, hours, minutes and seconds, and a
 * humanly readable text of these numbers
 */
public class Duration {
    private final Long years;
    private final Long days;
    private final Long hours;
    private final Long minutes;
    private final Long seconds;
    private String formattedText;

    public Long getYears() {
        return years;
    }

    public Long getDays() {
        return days;
    }

    public Long getHours() {
        return hours;
    }

    public Long getMinutes() {
        return minutes;
    }

    public Long getSeconds() {
        return seconds;
    }

    public String getFormattedText() {
        return formattedText;
    }

    public void setFormattedText(String formattedText) {
        this.formattedText = formattedText;
    }

    public Duration(Long years, Long days, Long hours, Long minutes, Long seconds) {
        this.years = years;
        this.days = days;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
}
