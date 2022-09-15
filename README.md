# :warning: Migration to Eclipse Digital Twin Top Level Project
 **NOTE:** We are hounoured to be part of the [Eclipse Foundation](https://projects.eclipse.org/projects/dt) as [Eclipse AAS Model for Java (AAS4J)](https://projects.eclipse.org/projects/dt.aas4j) and this project will be maintained here ([Eclipse AAS4J GitHub Repository](https://github.com/eclipse-digitaltwin/aas4j-model-generator)). See you there! 
 
***Please*** :point_right: use our new repository [Eclipse AAS4J GitHub Repository](https://github.com/eclipse-digitaltwin/aas4j-model-generator) for contributions and subscribe to our mailing list to interact with our community at the Eclipse Foundation.

# The AAS Code Generation Tool for Java

This is a tool for the automated creation of a Java library containing all classes, properties and enumerations of the Asset Administration Shell (AAS) Metamodel. The tool itself is completly written in Java and uses the shapes constraint language (SHACL) to specify annotations and cardinalities for the Java classes.



# Build and Use

Before running the tool, a profile needs to be created. This profile contains information about where the ontology sources reside. In the [pom.xml](pom.xml), add your own profile with a (local) path to your ontology. There are multiple profiles present already which can be used as reference.

Once the profile has been created, you can build the project using Maven by simply executing at the repository root:

`mvn clean package -P <Profile Name>`



# Project Structure

The project contains several modules:

- `aas` Module containing shapes translating RDF into Java classes matching specific requirements of projects regarding the Asset Administration Shell.
- `common` Module containing shapes translating RDF into Java classes.
- `util` Module containing some generic utility classes, such as custom annotations.
- `generator` This module loads all data required for the translation process from RDF ontologies to Java classes, including the shapes and the ontology.


# How to Contribute

We always look for contributions, bug reports, feature requests etc. Simply open an [issue](https://github.com/admin-shell-io/java-generator/issues) or - even better - directly propose a change through a [pull request](https://github.com/admin-shell-io/java-generator/pulls).

# Documentation

A detailed documentation how to use the tool and how to prepare the input and the environment is provided [here](./aas/README.md).

# Contributors

| Name        | Affiliation           | Github Account | Parent | AAS  | Util | Generator |
--- | --- | --- | :---: | :---: | :---: | :---: |
| Sebastian Bader | Fraunhofer IAIS | [sebbader](https://github.com/sebbader) | x | x | x | x |
| Matthias Böckmann | Fraunhofer IAIS | [maboeckmann](https://github.com/maboeckmann) | x | x | x | x |
| Pascal Linden | Fraunhofer IAIS | [pnlinden](https://github.com/pnlinden) | x | x | x | x |

This project was initiated by SAP and Fraunhofer to provide a foundation for the
AAS development and to foster its dissemination.
