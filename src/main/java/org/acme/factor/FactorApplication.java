package org.acme.factor;

import io.smallrye.common.annotation.Blocking;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@Blocking
public class FactorApplication extends Application {
}
