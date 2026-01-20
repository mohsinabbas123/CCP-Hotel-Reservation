# CCP Hotel Management System

A clean, object-oriented Java application that simulates core hotel operations. This project focuses on **solid architecture**, **defensive programming**, and **data integrity**.

##  What It Does
* **Hotel & Room Management:** Organizes hotels into chains and categorizes rooms (Deluxe, Standard, etc.).
* **Reservations:** Handles booking logic with strict availability checks.
* **Guest Lifecycle:** Manages the full flow from Check-In to Check-Out.
* **Safety First:** Uses immutable objects and input validation to prevent bugs (e.g., no booking past dates).

##  Tech Stack
* **Language:** Java (JDK 11+)
* **Testing:** JUnit 5

##  Quick Start

### Run the App
1.  Clone the repo.
2.  Open `src/ccp/hotel/Main.java`.
3.  Run the file. You'll see a console demonstration of the entire workflow (Setup → Reservation → Check-In → Check-Out).

### Run the Tests
1.  Open the project in any IDE (IntelliJ, Eclipse, VS Code).
2.  Go to `src/ccp/hotel/test`.
3.  Run all tests to verify the logic.

##  Project Structure
* `ccp.hotel` → Core logic (Hotel, Room, Reservation, etc.).
* `ccp.hotel.test` → JUnit test cases covering all critical paths.

---
*Developed by **Mohsin Abbas**.*