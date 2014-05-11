package com.sample;

import com.sample.health.SampleHealthCheck;
import com.sample.resources.SampleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SampleService extends Application<SampleServiceConfiguration> {

    /**
     * Service Entry Point
     *
     * @param args
     * @throws Exception
     */
    public static void main(String... args) throws Exception {
        new SampleService().run(args);
    }


    @Override
    public void run(SampleServiceConfiguration configuration, Environment environment) throws Exception {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.jersey().register(new SampleResource(template, defaultName));
        environment.healthChecks().register("template", new SampleHealthCheck(template));
    }

    /**
     * Configure aspects of the service required before the service is run
     *
     * @param bootstrap
     */
    @Override
    public void initialize(Bootstrap<SampleServiceConfiguration> bootstrap) {
    }
}
