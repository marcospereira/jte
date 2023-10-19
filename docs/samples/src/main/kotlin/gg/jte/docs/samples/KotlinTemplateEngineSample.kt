package gg.jte.docs.samples;

import org.example.Page

// --8<-- [start:imports]
import gg.jte.ContentType
import gg.jte.TemplateEngine
import gg.jte.resolve.DirectoryCodeResolver


import java.nio.file.Path
// --8<-- [end:imports]

// --8<-- [start:imports-render]
import gg.jte.output.StringOutput
// --8<-- [end:imports-render]

class KotlinTemplateEngineSample {

    fun templateEngineSamples() {
        // --8<-- [start:createTemplateEngine]
        // This is the directory where your .jte files are located.
        val templatesPath = Path.of("jte")
        val codeResolver = DirectoryCodeResolver(templatesPath)
        val templateEngine = TemplateEngine.create(codeResolver, ContentType.Html)
        // --8<-- [end:createTemplateEngine]

        val page = Page()
        // --8<-- [start:renderTemplate]
        val output = StringOutput()
        templateEngine.render("example.kte", page, output)
        println(output)
        // --8<-- [end:renderTemplate]
    }
}
