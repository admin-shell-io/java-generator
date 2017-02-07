package de.fraunhofer.iais.eis.generate;

import fr.inria.acacia.corese.exceptions.EngineException;
import fr.inria.edelweiss.kgram.core.Mappings;
import fr.inria.edelweiss.kgraph.core.Graph;
import fr.inria.edelweiss.kgraph.query.QueryProcess;
import fr.inria.edelweiss.kgtool.load.Load;
import fr.inria.edelweiss.kgtool.print.ResultFormat;
import fr.inria.edelweiss.kgtool.print.TripleFormat;

/**
 * Created by christian on 06.02.17.
 */
public class Generator {

    public static void main(String[] args) throws EngineException {

        // input: (start)template
        // output: ttl files

        Graph graph = Graph.create();
        Load ld = Load.create(graph);
        ld.load("/home/christian/projects/ids/rdf-codegen/src/main/resources/vocab/DatasetAndCommunication.ttl");
        QueryProcess exec = QueryProcess.create(graph);
        String query = "template{st:apply-templates-with('/home/christian/projects/ids/rdf-codegen/src/main/resources/templates')} where {}";
        Mappings map = exec.query(query);

        ResultFormat f1 = ResultFormat.create(map);
        System.out.println(f1);
        TripleFormat f2 = TripleFormat.create(graph);
        System.out.println(f2);
    }

}
