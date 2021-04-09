# CodeGenTool: Visualization

## TODO!!!

## Usage


### How classes are translated:
A basic class and the datatype properties that have that class as domain are translated by `process-class-to-uml.rq`. There are three different szenarios how properties can be translated.
1. A datatype property with pointing with its range to a *basic* datatype, which can directly be translated into a Java datatype, e.g. `xsd:string` $\rightarrow$ `String`.
2. An object property pointing to a class within the namespace of the currently translated ontology.
3. An object property pointing to a class outside of the namespace of the currently translated ontology.

##### Case 1.
A datatype property is translated directly as an attribute within the class:

```
ex:Animal rdfs:type rdf:Class ;
    ...

ex:name rdfs:type rdf:DatatypeProperty ;
    rdfs:domain ex:Animal ;
    rdfs:range xsd:string ;
    ...
```

$\Rightarrow$

```
class Animal {
# name : java.util.ArrayList<String>
}
```

If there exists a Shacl shape defining cardinality constraints, the generated plantuml changes accordingly:
```
shapes:AnimalShape rdfs:type sh:NodeShape ;
    sh:targetClass ex:Animal ;
    sh:property [
        rdfs:type sh:PropertyShape ;
        sh:path ex:name ;
        sh:range xsd:string ;
        sh:maxCount 1;
        ...
    ]
    ...
```

$\Rightarrow$

```
class Animal {
# name : String
}
```