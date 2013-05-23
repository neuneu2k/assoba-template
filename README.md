assoba-template
====================

Introduction
---------------------

Just another fork of the [play2](https://github.com/playframework/Play20) template library, aka [twirl](https://github.com/spray/twirl)

Why the play2 template system instead of Scalate
------------------------------------------------

One word: **IDE's**, both eclipse and IDEA support the play2 template syntax and provide static typing helpers.

While HAML derived languages are great for HTML templating, they are not designed for generic text templating, wich means that the only Scalate competitor is SSP.
The Play2 syntax is both more simple (to write, not to parse :D) and more typesafe than the SSP one.


Why fork ?
----------

Both Play2 and Twirl are designed to be used from SBT, bringing the sbt dependency on scala 2.9.x,
for scala 2.10 developpements, this means quite a lot of cruft in the maven plugin.

This fork also includes some design choices on template name detection and template "format" detection
that are more germane to generic templating and not only HTML templating.


How to use it ?
---------------

Include the following tiny runtime dependency in the project that will use templates.
```xml
<dependency>
        <groupId>fr.assoba.open</groupId>
        <artifactId>assoba-template-api</artifactId>
        <version>1.0</version>
</dependency>
```
Add the following plugin to the build>plugins section in your pom
```xml
<plugin>
    <groupId>fr.assoba.open</groupId>
    <artifactId>template-maven-plugin</artifactId>
    <version>1.0-SNAPSHOT</version>
    <executions>
        <execution>
            <goals>
                <goal>compile</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
Put your templates beside your scala code in src/main/scala,

templates should be named
    ***[CLASSNAME].stl***
for generic templates and
    ***[CLASSNAME].html.stl***
for html templates (with play2 escaping rules)

Template syntax documented in the [play2 documentation](http://www.playframework.com/documentation/2.1.1/ScalaTemplates)

Both m2eclipse and IDEA should detect the generated-sources automatically


