/*
 * Copyright 2013 Josselin Pujo
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package fr.assoba.open.template.mojo;

import fr.assoba.open.template.compiler.PathCompiler;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Component;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;

@Mojo(
        name = "compile",
        requiresProject = true,
        defaultPhase = LifecyclePhase.GENERATE_SOURCES
)
public class TemplateCompiler extends AbstractMojo {

    @Parameter(
            defaultValue = "${basedir}/src/main/scala"
    )
    private File inputDir;

    @Parameter(
            defaultValue = "${project.build.directory}/generated-sources/assoba-template"
    )
    private File outputDir;

    @Component
    private MavenProject project;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        this.project.addCompileSourceRoot(outputDir.getAbsolutePath());
        outputDir.mkdirs();
        getLog().info("Compiling templates");
        PathCompiler.compile(inputDir, outputDir);
    }
}
