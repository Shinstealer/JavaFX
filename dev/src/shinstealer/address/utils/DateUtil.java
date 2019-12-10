package shinstealer.address.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	private static final String DATE_PATTERN = "dd-MM-YYYY";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	public static String format(LocalDate date) {
		if (date == null) {
			return null;
		}

		return DATE_FORMATTER.format(date);

	}

}
