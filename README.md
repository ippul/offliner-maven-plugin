# offliner-maven-plugin

usage example 
```
<plugin>
   <groupId>org.ippul.maven.plugin</groupId>
   <artifactId>offliner-maven-plugin</artifactId>
   <version>1.0-SNAPSHOT</version>
   <executions>
      <execution>
         <goals>
            <goal>offliner</goal>
         </goals>
         <configuration>
            <settingsFile>/Users/claudio/.m2/settings.xml</settingsFile>
            <localMavenRepository>/Users/claudio/.m2/repository</localMavenRepository>
            <artifacts>
               <gav>com.company:evaluation:1.0.0-SNAPSHOT</gav>
               <gav>com.company:evaluation:2.0.0-SNAPSHOT</gav>
            </artifacts>
         </configuration>
      </execution>
   </executions>
</plugin>
```
