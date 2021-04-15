package datediff;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Entry Point for DateDifferenceApplication
 */
public class DateDifferenceApplication {

	/**
	 * Main method to trigger date difference output by reading from a file.
	 *
	 * @param args - expects only 1 argument referring to the path of file containing date inputs.
	 * @throws IOException              - If fails to read file
	 * @throws IllegalArgumentException - If invalid arguments or wrong number of arguments are passed.
	 */
	public static void main(String[] args) throws IOException {

		// validate application parameters.
		if (args == null || !(args.length == 1)) {
			throw new IllegalArgumentException("Invalid number of parameters passed, One parameter expected representing path of file to read");
		}

		// fetch path of file
		Path path = Paths.get(args[0]);

		// read commands from the file
		List<String> lineInput = Files.readAllLines(path);

		DatePairParser datePairParser = new DatePairParser();
		lineInput.stream()
				.map(datePairParser::parsePairOfDates)
				.forEach(System.out::println);
	}
}
