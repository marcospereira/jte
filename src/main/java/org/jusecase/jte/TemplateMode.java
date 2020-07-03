package org.jusecase.jte;

public enum TemplateMode {
    /**
     * All templates are precompiled to Java class files.
     * The template engine will load them from the specified location.
     * No JDK is required.
     * This is recommended when running templates in production.
     * More info: https://github.com/casid/jte/blob/master/DOCUMENTATION.md#precompiling-templates
     */
    Precompiled,

    /**
     * All templates are compiled to Java class files on demand.
     * A JDK is required.
     * This is recommended when running templates on your developer machine.
     */
    Dynamic,
}
