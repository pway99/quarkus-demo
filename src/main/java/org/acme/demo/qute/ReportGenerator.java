package org.acme.demo.qute;

import io.quarkus.qute.Template;
import io.quarkus.qute.api.ResourcePath;
import io.quarkus.scheduler.Scheduled;

public class ReportGenerator {
    @ResourcePath("reports/v1/report_01")
    Template report;

    @Scheduled(cron = "0 30 * * * ?")
    void generate() {
        String result = report
                .data("samples", new Object())
                .render();
    }
}

