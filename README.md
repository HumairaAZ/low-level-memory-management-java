# Low-Level Memory Management in Java

## Project Overview

This project demonstrates low-level memory management in Java using the `sun.misc.Unsafe` class to manually allocate and deallocate memory.

## Setup Instructions

1. Clone the repository.
2. Navigate to the project directory.
3. Build the project using Maven:
mvn clean install

4. Run the application:
     -jar target/low-level-memory-management-java-1.0-SNAPSHOT.jar


## Usage

The application will allocate 1KB of memory, set each byte to `1`, and then verify the memory contents before freeing the memory. Successful execution will print `Memory management completed successfully.`.

## CI Setup

This project uses GitHub Actions for continuous integration. The CI pipeline is defined in the `.github/workflows/ci.yml` file.

## Expected Results

The application should run without errors and print `Memory management completed successfully.` to the console.
