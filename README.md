# MyApplications

This repository contains two Java applications: `CsvProcessorApp` and `FakeStoreApiApp`. The `CsvProcessorApp` processes CSV files and evaluates formulas, while `FakeStoreApiApp` demonstrates calling the FakeStore API to retrieve and add product data.

## Table of Contents

- [1. CsvProcessorApp](https://github.com/arupx3492/Prospecta/tree/main/Prospecta_Assignment/CSVReaderApplication)
- [2. RemoteAPICall](https://github.com/arupx3492/Prospecta/tree/main/Prospecta_Assignment/Prospecta_Assignement)
- [2. Theoretical Challenge](https://github.com/arupx3492/Prospecta/blob/main/Prospecta_Assignment/CSVReaderApplication/src/TheoreticalQuestions.txt)

---

## Applications Overview

1. **CsvProcessorApp**: Reads a CSV file with numeric values and formulas, evaluates the formulas, and writes the evaluated results to a new CSV file.
2. **FakeStoreApiApp**: Interacts with the FakeStore API to retrieve product details by category and add new products.


---

## 1. CsvProcessorApp

### Features

- Reads a CSV file from a specified location.
- Detects and processes simple formulas (like `=A1+B1`) within the CSV.
- Evaluates cell values and writes the output to a new CSV file.
- 

### Files

- `CsvFormulaEvaluator.java`: The main class that processes the CSV and evaluates the formulas.
- `data.csv`: Sample input CSV file that contains numbers and formulas.

### Usage

The application reads a CSV file, processes any formulas present, and outputs a CSV file with evaluated values. You can specify the path to the input file in the code or via the command line.

---

## 2. FakeStoreApiApp

### Features

- Retrieves product details from the FakeStore API by category.
- Allows the user to add a new product via the FakeStore API.

### API Endpoints

- **Retrieve Product by Category**: Uses `GET /products/category/{category}` to fetch products based on the provided category.
- **Add a New Product**: Uses `POST /products` to add a new product with relevant properties such as `title`, `price`, `description`, etc.
