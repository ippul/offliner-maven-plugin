package org.ippul.maven.plugin;

import java.io.File;
import java.nio.file.Paths;

import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.junit.Test;

public class OfflinerMojoTest extends AbstractMojoTestCase {

    @Test
    public void test() throws Exception {
        final File testPom = new File(getBasedir(), "src/test/resources/org/ippul/maven/plugin/pom.xml");
        final OfflinerMojo mojo = (OfflinerMojo) lookupMojo("offliner", testPom);
        assertNotNull(mojo);
        mojo.execute();
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/_remote.repositories").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0-sources.jar").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0-sources.jar.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.jar").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.jar.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.pom").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/javax.activation-api-1.2.0.pom.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/activation/javax.activation-api/1.2.0/m2e-lastUpdated.properties").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/_remote.repositories").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1-sources.jar").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1-sources.jar.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1.jar").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1.jar.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1.pom").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/jaxb-api-2.3.1.pom.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/javax/xml/bind/jaxb-api/2.3.1/m2e-lastUpdated.properties").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/_remote.repositories").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12-sources.jar").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12-sources.jar.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12.jar").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12.jar.lastUpdated").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12.jar.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12.pom").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12.pom.lastUpdated").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/junit-4.12.pom.sha1").toFile().exists());
        assertTrue(Paths.get( getBasedir(), "target/test-classes/", "repository/junit/junit/4.12/m2e-lastUpdated.properties").toFile().exists());
    }
}