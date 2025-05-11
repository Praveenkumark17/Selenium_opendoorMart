🛠️ Selenium Automation Testing - E-Commerce Client
Project URL: E-Commerce Client

📌 Project Overview
This project automates various test cases for the e-commerce platform using Selenium & TestNG. It covers functionalities such as: ✅ Login & Authentication ✅ Product Management (Add, Edit, Delete) ✅ Category Handling ✅ Search & Pagination Validation ✅ Brand List Table Testing

🔧 Setup & Installation
1️⃣ Clone the Repository
bash
git clone https://github.com/YOUR-REPO-NAME.git
cd YOUR-REPO-NAME
2️⃣ Install Dependencies
Ensure you have Java, Maven, and Selenium WebDriver installed. Install dependencies using Maven:

bash
mvn install
3️⃣ Configure WebDriver
Download and set up ChromeDriver or GeckoDriver (for Firefox). Example for ChromeDriver:

java
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
WebDriver driver = new ChromeDriver();

4️⃣ Run the Tests
Execute TestNG test cases:

bash

mvn test

📁 Project Structure
selenium-project/
│── src/
│   ├── test/java/
│   │   ├── org/TestNG/
│   │   │   ├── TS_001.java
│   │   │   ├── TS_002.java
│   │   │   ├── TS_003.java
│   │   │   ├── TS_004.java
│   │   │   ├── ...
│── testng.xml
│── pom.xml
│── README.md
│── drivers/
│── reports/

📜 Key Features & Test Coverage
✔ Cross-browser testing: Chrome, Firefox ✔ Data-driven testing: Uses TestNG XML configuration ✔ Page Object Model (POM) for structured test cases ✔ Extensive test reporting (Allure or TestNG Reports)

❗ Contributing
Fork the repository

Create a new branch (git checkout -b feature-name)

Commit changes (git commit -m "Added new test case")

Push the branch (git push origin feature-name)

Create a Pull Request 🚀

📧 Contact & Support
For any queries, create an issue or reach out to the maintainer at praveenkrishh01@gmail.com.
