package some.other.packagename;

import de.fraunhofer.iais.eis.Dataset;
import de.fraunhofer.iais.eis.DatasetBuilder;
import de.fraunhofer.iais.eis.DatasetImpl;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;

/**
 * Created by christian on 19.01.17.
 */
public class Invoke {

    public static void main(String[] args) {
        DatasetBuilder datasetBuilder = new DatasetBuilder();
        try {
            Dataset ds = datasetBuilder.creationDate(null).build();
            //ds.setFormat("bla");
        } catch (ConstraintViolationException e) {
            e.printStackTrace();
        }

    }

}
