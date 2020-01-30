# offliner-maven-plugin

usage example 
```
<plugin>
   <groupId>org.ippul.maven.plugin</groupId>
   <artifactId>offliner-maven-plugin</artifactId>
   <version>1.0-SNAPSHOT</version>
   <executions>
      <execution>
         <phase>prepare-package</phase>
         <goals>
            <goal>offliner</goal>
         </goals>
         <configuration>
            <settingsFile>src/test/resources/org/ippul/maven/plugin/settings.xml</settingsFile>
            <outputDirectory>target/test-classes/repository/</outputDirectory>
            <artifacts>
               <gav>org.jboss.javaee:jboss-transaction-api:1.0.1.GA</gav>
               <gav>javax.xml.bind:jaxb-api:2.3.1</gav>
            </artifacts>
         </configuration>
      </execution>
   </executions>
</plugin>
```
