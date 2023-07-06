import java.util.ArrayList;

/**
 * A class with methods to add a correct, readable text of a duration to the Duration object
 */
public class DurationFormatter {
    private final Duration duration;
    private final StringBuilder stringBuilder;
    private int counter = 0;
    private final ArrayList<Long> durationList;

    /**
     * A constructor fot the formatter that takes a Duration object
     * @param duration a Duration object that already has values converted to years, days, hours, minutes and
     *                 seconds
     */
    public DurationFormatter(Duration duration) {
        this.duration = duration;
        this.stringBuilder = new StringBuilder();
        this.durationList = new ArrayList<>();
    }

    /**
     * Creates a string of the duration by the required format. Different parts must be separated by a comma
     * except the last two element, there has to be an 'and' between them
     */
    public void formatDuration() {
        addCounter();

        if (counter == 0) {
            duration.setFormattedText("now");
        } else if (counter == 1) {
            for (Long aLong : durationList) {
                if (aLong > 0) {
                    stringBuilder.append(aLong)
                    .append(" ")
                    .append(chooseWord(durationList.indexOf(aLong), aLong));
                }
            }
            duration.setFormattedText(stringBuilder.toString());
        } else if (counter > 1) {
            for (int i = 0; i < durationList.size(); i++) {
                if (durationList.get(i) > 0) {
                    stringBuilder.append(durationList.get(i))
                    .append(" ")
                    .append(chooseWord(i, durationList.get(i)));
                    counter--;
                    if (counter > 1) {
                        stringBuilder.append(", ");
                    } else if (counter == 1) {
                        stringBuilder.append(" and ");
                    }
                }

            }
            duration.setFormattedText(stringBuilder.toString().trim());
        }
    }

    /**
     * Adds a counter by counting all the values that are more than 0.
     */
    private void addCounter() {
        durationList.add(duration.getYears());
        durationList.add(duration.getDays());
        durationList.add(duration.getHours());
        durationList.add(duration.getMinutes());
        durationList.add(duration.getSeconds());

        for (Long aLong : durationList) {
            if (aLong > 0) {
                counter++;
            }
        }
    }

    /**
     * Selects the correct word by the position of the number in the list and the correct form - singular or
     * plural - by the value of the number.
     * @param index the position of the number in the list it comes from
     * @param duration the value of the number
     * @return a text in singular or plural form
     */
    private String chooseWord(int index, Long duration) {
        switch (index) {
            case 0 -> {
                if (duration == 1L) {
                    return "year";
                } else {
                    return "years";
                }
            }
            case 1 -> {
                if (duration == 1L) {
                    return "day";
                } else {
                    return "days";
                }
            }
            case 2 -> {
                if (duration == 1L) {
                    return "hour";
                } else {
                    return "hours";
                }
            }
            case 3 -> {
                if (duration == 1L) {
                    return "minute";
                } else {
                    return "minutes";
                }
            }
            case 4 -> {
                if (duration == 1L) {
                    return "second";
                } else {
                    return "seconds";
                }
            }
            default -> {
                return "";
            }
        }
    }


}
