package org.acme.demo.misc;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;

// https://github.com/quarkusio/quarkus/blob/main/docs/src/main/asciidoc/qute-reference.adoc
@CheckedTemplate
public class Templates {
    public static native TemplateInstance hello(String name);
}