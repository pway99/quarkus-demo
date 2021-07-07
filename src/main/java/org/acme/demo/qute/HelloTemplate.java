package org.acme.demo.qute;

import io.quarkus.qute.TemplateInstance;
import io.quarkus.qute.api.CheckedTemplate;

@CheckedTemplate
public class HelloTemplate {
    public static native TemplateInstance hello(String name);
}
