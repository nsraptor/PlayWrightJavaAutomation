# Use an image with Maven, Java, and Chrome pre-installed
FROM maven:3.8.4-openjdk-11-slim

# Set working directory
WORKDIR /usr/src/app

# Copy the pom.xml file to download dependencies
COPY pom.xml .

# Download dependencies
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Command to run the tests
CMD ["mvn", "clean", "test"]