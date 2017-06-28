package de.fraunhofer.iais.eis.stories;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class StoryUtil {

    private URL operationUrl;

    public DataService describeDataService() throws ConstraintViolationException, MalformedURLException {
        return new DataServiceBuilder()
                .operations(Arrays.asList(describeOperation()))
                .publishes(describeDataAsset())
                .build();
    }

    private DataAsset describeDataAsset() throws MalformedURLException, ConstraintViolationException {
        return new DataAssetBuilder()
                .entityNames(Arrays.asList(new PlainLiteral("Development of company revenue", "en")))
                .coversCategories(Arrays.asList(new URL("http://dbpedia.org/resource/Category:Finance")))
                .build();
    }

    private Operation describeOperation() throws ConstraintViolationException {
        if (operationUrl == null) {
            return new ReadOperationBuilder(operationUrl)
                    .opLabels(Arrays.asList(new PlainLiteral("Retrieve the whole dataset", "en")))
                    .outputs(Arrays.asList(describeOutput()))
                    .build();
        }
        else {
            return new ReadOperationBuilder()
                    .opLabels(Arrays.asList(new PlainLiteral("Retrieve the whole dataset", "en")))
                    .outputs(Arrays.asList(describeOutput()))
                    .build();

        }
    }

    private OutputParameter describeOutput() throws ConstraintViolationException {
        return new OutputParameterBuilder()
                .representation(describeRepresentation())
                .build();
    }

    private Representation describeRepresentation() throws ConstraintViolationException {
        return new RepresentationBuilder()
                .mediaType(IANAMediaType.APPLICATION_XML)
                .build();
    }

    public void setOperationUrl(URL operationUrl) {
        this.operationUrl = operationUrl;
    }
}
