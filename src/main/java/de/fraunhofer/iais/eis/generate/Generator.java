package de.fraunhofer.iais.eis.generate;

import fr.inria.acacia.corese.exceptions.EngineException;
import fr.inria.edelweiss.kgram.core.Mappings;
import fr.inria.edelweiss.kgraph.core.Graph;
import fr.inria.edelweiss.kgraph.query.QueryProcess;
import fr.inria.edelweiss.kgtool.load.Load;
import fr.inria.edelweiss.kgtool.print.ResultFormat;
import fr.inria.edelweiss.kgtool.print.TripleFormat;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Generator {

    private Graph graph = Graph.create();

    public static void main(String[] args) throws EngineException, URISyntaxException, IOException {
        new Generator().generate();
    }

    private void generate() throws URISyntaxException, IOException, EngineException {
        File vocabDir = new File(this.getClass().getClassLoader().getResource("vocab").toURI());

        loadVocabularyFiles(vocabDir.listFiles());
        doQuery(getStartQuery());
    }

    private void loadVocabularyFiles(File[] files) {
        Load ld = Load.create(graph);
        Arrays.stream(files).forEach(file -> ld.load(file.getAbsolutePath()));
    }

    private String getStartQuery() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("start.rq");
        return IOUtils.toString(is, Charset.defaultCharset());
    }

    private void doQuery(String query) throws EngineException {
        QueryProcess exec = QueryProcess.create(graph);
        exec.query(query);
    }

}
