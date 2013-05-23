package fr.assoba.open.template.mojo;

import fr.assoba.open.template.compiler.PathCompiler;
import fr.assoba.open.template.compiler.ScalaTemplateCompiler;
import fr.assoba.open.template.compiler.ScalaTemplateCompiler$;
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
        PathCompiler.compile(inputDir,outputDir);
    }
}
