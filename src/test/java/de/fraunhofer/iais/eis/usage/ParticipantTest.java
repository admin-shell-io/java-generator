package de.fraunhofer.iais.eis.usage;

import de.fraunhofer.iais.eis.*;
import de.fraunhofer.iais.eis.util.ConstraintViolationException;
import de.fraunhofer.iais.eis.util.PlainLiteral;
import de.fraunhofer.iais.eis.util.VocabUtil;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.junit.Assert;
import org.junit.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class ParticipantTest {

    @Test
    public void structuredOrganization() throws MalformedURLException, ConstraintViolationException {
        Participant original = new ParticipantBuilder(new URL("http://example.org/ACME"))
            .entityNames(Arrays.asList(new PlainLiteral("ACME Explosives GmbH")))
            .corporateEmailAddresses(Arrays.asList("kaboom@acme.org"))
            .memberParticipants(Arrays.asList(createMemberParticipant()))
            .entityDescriptions(Collections.EMPTY_LIST)
            .build();
        Participant deserialized = (Participant) VocabUtil.fromRdf(original.toRdf());

        Collection<? extends PlainLiteral> origEntityNames = original.getEntityNames();
        Collection<? extends PlainLiteral> deserEntityNames = deserialized.getEntityNames();
        Assert.assertArrayEquals(origEntityNames.toArray(), deserEntityNames.toArray());

        Person origSubOrgMemberPerson = original.getMemberParticipants().iterator().next().getMemberPersons().iterator().next();
        Person deserSubOrgMemberPerson = deserialized.getMemberParticipants().iterator().next().getMemberPersons().iterator().next();
        ReflectionAssert.assertReflectionEquals(origSubOrgMemberPerson, deserSubOrgMemberPerson);
    }

    private Participant createMemberParticipant() throws MalformedURLException, ConstraintViolationException {
        return new ParticipantBuilder(new URL("http://example.org/ACME/sales"))
            .entityNames(Arrays.asList(new PlainLiteral("ACME Explosives Sales Dept.")))
            .memberPersons(Arrays.asList(createMemberPerson()))
            .entityDescriptions(Collections.EMPTY_LIST)
            .build();
    }

    private Person createMemberPerson() throws MalformedURLException, ConstraintViolationException {
        return new PersonBuilder(new URL("http://example.org/elmer_fudd"))
            .givenName("Elmer")
            .familyName("Fudd")
            .phoneNumbers(Arrays.asList("+49123456789"))
            .gender(Gender.MALE)
            .build();
    }

}
