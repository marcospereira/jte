package gg.jte.docs.samples;

import org.example.Page;

// --8<-- [start:imports]
import gg.jte.CodeResolver;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.DirectoryCodeResolver;

import java.nio.file.Path;
// --8<-- [end:imports]

// --8<-- [start:imports-render]
import gg.jte.output.StringOutput;
// --8<-- [end:imports-render]

public class JavaTemplateEngineSample {

    public void templateEngineSamples() {
        // --8<-- [start:createTemplateEngine]
        // This is the directory where your .jte files are located.
        Path templatesPath = Path.of("jte");
        CodeResolver codeResolver = new DirectoryCodeResolver(templatesPath);
        TemplateEngine templateEngine = TemplateEngine.create(codeResolver, ContentType.Html); // Two choices: Plain or Html
        // --8<-- [end:createTemplateEngine]

        Page page = new Page();
        // --8<-- [start:renderTemplate]
        var output = new StringOutput();
        templateEngine.render("example.kte", page, output);
        System.out.println(output);
        // --8<-- [end:renderTemplate]
    }
}
