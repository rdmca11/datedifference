# Problem Statement
Create an application that can read in pairs of dates in the following
format -

    DD MM YYYY, DD MM YYYY

Validate the input data, and compute the difference between the two dates in days.

Output of the application should be of the form -

    DD MM YYYY, DD MM YYYY, difference

Where the first date is the earliest, the second date is the latest and the difference is the number of days.

Constraints:

The application may not make use of the platform / SDK libraries for date manipulation
(for example Date, Calendar classes).

# Tech Stack
* JDK 11
* jUnit 4
* Maven

# Build
Project can be build using maven commands
> mvn install

# Running the application from command line
> datediff.DateDifferenceApplication <input file path with pair of dates>
