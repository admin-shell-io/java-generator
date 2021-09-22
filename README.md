# The AAS Code Generation Tool for Java

This is a tool for the automated creation of a Java library containing all classes, properties and enumerations of the Asset Administration Shell (AAS) Metamodel. The tool itself is completly written in Java and uses the shapes constraint language (SHACL) to specify annotations and cardinalities for the Java classes.



# Build and Use

You can build the project using Maven by simply executing at the repository
root:

`mvn clean package -P <Profile Name>`


# Project Structure

The project contains several modules:

- `aas` Maven parent module that contains the respective de-/serializers for the different data formats.
- `util` Location of the general classes and interfaces that are used by more than one de-/serializer.
- `generator` AASX de-/serializer


# How to Contribute

We always look for contributions, bug reports, feature requests etc. Simply open an [issue](https://github.com/admin-shell-io/java-generator/issues) or - even better - directly propose a change through a [pull request](https://github.com/admin-shell-io/java-generator/pulls).

# Documentation

A detailed documentation how to use the tool and how to prepare the input and the environment is provided [here](./aas/README.md).

# Contributors

| Name        | Affiliation           | Github Account | Parent | AAS  | Util | Generator |
--- | --- | --- | :---: | :---: | :---: | :---: |
| Sebastian Bader | Fraunhofer IAIS | [sebbader](https://github.com/sebbader) | x | x | x | x |
| Matthias Böckmann | Fraunhofer IAIS | [maboeckmann](https://github.com/maboeckmann) | x | x | x | x |

This project was initiated by SAP and Fraunhofer to provide a foundation for the
AAS development and to foster its dissemination.
