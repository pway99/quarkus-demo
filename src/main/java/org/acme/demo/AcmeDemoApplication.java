package org.acme.demo;

import io.smallrye.common.annotation.Blocking;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@Blocking
public class AcmeDemoApplication extends Application {
}
