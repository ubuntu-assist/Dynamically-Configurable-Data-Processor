
# 🚀 Engineering a Dynamically Reconfigurable Data Processor 🚀

Welcome to the repository for **"Engineering a Dynamically Reconfigurable Data Processor"**. This project dives deep into the architecture and design of a flexible, scalable data processing pipeline capable of switching between multiple operational modes and databases on the fly.

## Project Overview

This repository contains the code and documentation for a dynamically reconfigurable data processor designed to operate in three primary modes:

1. **Dump Mode**: Discards the data.
2. **Passthrough Mode**: Inserts the data directly into a configured database.
3. **Validate Mode**: Validates the data against a configured database before insertion.

The system is built to toggle seamlessly between different databases—**Postgres, Redis, and Elastic**—each with its own implementation for data insertion and validation. The processor is also designed to be extendable, allowing for the addition of new modes and databases with minimal changes to the existing codebase.

## Design Approach

### Key Principles
- **SOLID Principles**: The design adheres to SOLID principles to ensure modularity and maintainability. For example, the Open/Closed Principle facilitates adding new modes and databases with minimal disruption.
- **Design Patterns**: The use of design patterns such as Strategy and Factory is integral to managing the various modes and databases. The Strategy pattern enables the processor to select different behaviors at runtime, while the Factory pattern simplifies database connection creation, making the system easily extendable.

### UML Class Diagram

The following structure is outlined in the UML class diagram:

- **Processor Class**: The core of the system, implementing a `configure` method to set the mode and database, and a `process` method to handle data based on the current configuration.
- **Database Interface**: Defines the contract for `connect`, `insert`, and `validate` methods, with concrete implementations for Postgres, Redis, and Elastic databases.
- **Mode Enum**: Identifies the operational mode, controlling how data is processed.
- **Database Enum**: Identifies the active database, controlling where data is stored or validated.
- **DataPoint Class**: Represents the data, both raw and processed, that flows through the system.

### Extending the System

Adding a new mode or database can be done by following the principles outlined in the design. Implement the required interface and update the relevant enums to incorporate the new functionality.

## Contributing

Contributions are welcome! Please submit a pull request or open an issue to discuss potential changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Acknowledgements

This project is a testament to the power of clean, scalable design and demonstrates the ability to tackle complex architectural challenges.

Stay tuned for more updates as the system evolves!
