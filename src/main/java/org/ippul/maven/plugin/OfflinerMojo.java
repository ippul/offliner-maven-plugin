/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ippul.maven.plugin;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;
import org.codehaus.plexus.util.FileUtils;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.jboss.shrinkwrap.resolver.api.maven.MavenArtifactInfo;
import org.jboss.shrinkwrap.resolver.api.maven.MavenResolvedArtifact;

/**
 * @author cluppi@redhat.com
 */
@Mojo(name = "offliner", defaultPhase = LifecyclePhase.PACKAGE)
public class OfflinerMojo extends AbstractMojo {

    @Parameter(required = true)
    private List<String> artifacts;

    @Parameter(required = true)
    private String settingsFile;

    @Parameter(required = true)
    private String localMavenRepository;

    @Parameter(required = false)
    private String outputDirectory;

    /**
     * @parameter default-value="${project}"
     * @required
     * @readonly
     */
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project;

    public void execute() throws MojoExecutionException {
        if(outputDirectory == null || outputDirectory.isEmpty()){
            outputDirectory = project.getBasedir().toPath().toString() + "/target/classes/repository/";
            Paths.get(outputDirectory).toFile().mkdir();
        }
        for (String artifact : artifacts) {
            readDependecies(getMavenResolvedArtifact(artifact));
        }
    }

    private void readDependecies(final MavenArtifactInfo... artifacts) {
        for (final MavenArtifactInfo artifact : artifacts) {
            final File[] files = getArtifact(getGav(artifact));
            saveInRepo(files);
            readDependecies(artifact.getDependencies());
        }
    }

    private String getGav(final MavenArtifactInfo artifact){
        return artifact.getCoordinate().getGroupId() + ":" + //
            artifact.getCoordinate().getArtifactId() + ":" + //
            artifact.getCoordinate().getVersion();
    }

    private MavenResolvedArtifact[] getMavenResolvedArtifact(final String gav) {
        return Maven //
                .configureResolver() //
                .fromFile(settingsFile) //
                .resolve(gav) //
                .withTransitivity()
                .asResolvedArtifact();
    }

    private File[] getArtifact(final String gav) {
        return Maven //
                .configureResolver() //
                .fromFile(settingsFile) //
                .resolve(gav) //
                .withTransitivity() //
                .asFile();
    }

    private void saveInRepo(final File... files) {
        for(File file : files){
            final String basePath = file.toPath().toFile().getParentFile().toString().replaceFirst(localMavenRepository, outputDirectory);
            if(!Paths.get(basePath).toFile().exists()){
                Paths.get(basePath).toFile().mkdir();
            }
            try {
                FileUtils.copyDirectory(Paths.get(file.getParent()).toFile(), Paths.get(basePath + "/").toFile());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
