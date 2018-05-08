package de.fraunhofer.iais.eis.general;

import de.fraunhofer.iais.eis.HashFunction;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by christian on 26.05.17.
 */
public class EnumValues {

    @Test
    public void hashFunction_stringConversion() {
        HashFunction hashFunction = HashFunction.getByString(HashFunction.SHA_256.toString());

        Assert.assertNotNull(hashFunction);
        Assert.assertEquals(hashFunction, HashFunction.SHA_256);
    }

}
