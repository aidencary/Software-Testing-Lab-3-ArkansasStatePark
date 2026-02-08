# Arkansas State Park – Stay Price Calculator

For my peers on Peerceptive, please look at the "Lab 3 Software Testing.pdf" file in resources for the test design deliverables with the TCIs and test cases
This is a Spring Boot project that calculates the cost of staying at Arkansas State Parks. It applies discounts based on age, residency, and veteran status. This project was created for a software testing lab.

## What It Does

- Base price: $50 per night  
- Discounts:
  - Children (0–12): 50% off  
  - Seniors (65+): 20% off  
  - Arkansas residents: $10 off  
  - Veterans: 10% off  
- Valid stay length: 1–14 nights

## Input Rules
The program throws an error if:
- Nights are not between 1 and 14
- Age is less than 0

## Requirements

- Java 25+
- Maven (or included wrapper)

## Setup

- Clone the project and build it
- Run tests using "./mvnw test" in the terminal or right-click on StayPriceCalculatorTest class and click "Run"
