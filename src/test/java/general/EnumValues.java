package general;

import de.fraunhofer.iais.eis.HashFunction;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;

/**
 * Created by christian on 26.05.17.
 */
public class EnumValues {

    @Test
    public void hashFunction_stringConversion() {
        Optional<HashFunction> hashFunction = HashFunction.getByString(HashFunction.SHA_256.toString());

        Assert.assertTrue(hashFunction.isPresent());
        Assert.assertEquals(hashFunction.get(), HashFunction.SHA_256);
    }

}
