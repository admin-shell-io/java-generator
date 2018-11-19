package de.fraunhofer.iais.eis;

import org.eclipse.rdf4j.model.BNode;
import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;

import java.io.*;
import java.util.*;

public class Generator {

    private static final Map<String,String> contextMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.out.println("call with dest directory path and infomodel path");
        } else {
            File target  = new File(args[0]);
            if(target.exists()) {
                System.out.println("existing file is overwritten");
                target.delete();
                target.createNewFile();
            }
            File infomodelPath = new File(args[1]);
            PrintWriter printer = new PrintWriter(target);
            printer.write(generate(infomodelPath));
            printer.flush();
            printer.close();
        }
    }

    public static String generate(File infomodelPath) throws IOException {
        List<File> sourceTtl = getSourceTurtleFiles(infomodelPath);
        sourceTtl.forEach(sourceFile -> {
            try {
                InputStream in = new FileInputStream(sourceFile);
                System.out.println(sourceFile.getName());
                Model model = Rio.parse(in, "/", RDFFormat.TURTLE);
                model.getNamespaces().forEach(ns -> contextMap.put(ns.getPrefix(), ns.getName()));
                model.subjects().stream().distinct()
                        .filter(subj -> ! (subj instanceof BNode))
                        .map(subj -> subj.stringValue())
                        .forEach(subj -> {
                            String simplePropertyOrClassName = subj.substring(subj.lastIndexOf("/") + 1); // after last slash
                            Map.Entry<String, String> namespacePair = contextMap.entrySet().stream().filter(entry -> subj.contains(entry.getValue()))
                                    .findAny().orElseThrow(() -> new UnsupportedOperationException("every property/class has to have a namespace" + subj));
                            String prefixedName = subj.replace(namespacePair.getValue(), namespacePair.getKey() + ":");
                            contextMap.put(simplePropertyOrClassName, prefixedName);
                        });
            } catch (IOException e) {
                throw new RuntimeException(e); // hack to propagate exception
            }
        });
        return buildContextString();
    }

    private static List<File> getSourceTurtleFiles(File root) {
        List<File> sourceFiles = new ArrayList<>();
        if(root.isFile() && root.getName().endsWith(".ttl")) {
            sourceFiles.add(root); // recursion end
        } else if(root.isDirectory() && !root.getAbsolutePath().contains("/references")) {
            Arrays.stream(root.listFiles()).forEach(dir -> sourceFiles.addAll(getSourceTurtleFiles(dir))); // root.listFiles() should never be null
        }

        return sourceFiles; // includes case root == null
    }

    private static String buildContextString() {
        final StringBuilder sbuilder = new StringBuilder();
        sbuilder.append("{\r\n\"@context\" : {\r\n");
        contextMap.entrySet().forEach(entry -> sbuilder.append("\t\"" + entry.getKey() + "\" : \"" + entry.getValue() + "\",\r\n"));
        sbuilder.deleteCharAt(sbuilder.lastIndexOf(",")); // remove comma after last entry
        sbuilder.append("}\r\n}\r\n");
        return sbuilder.toString();
    }
}
