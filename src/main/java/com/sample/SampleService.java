package com.sample;

import com.sample.health.SampleHealthCheck;
import com.sample.resources.SampleResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

public class SampleService extends Service<SampleServiceConfiguration> {

    /**
     * Service Entry Point
     *
     * @param args
     * @throws Exception
     */
    public static void main(String... args) throws Exception {
        new SampleService().run(args);
    }

    /**
     * Configure aspects of the service required before the service is run
     *
     * @param bootstrap
     */
    @Override
    public void initialize(Bootstrap<SampleServiceConfiguration> bootstrap) {
        bootstrap.setName("sample");
    }

    @Override
    public void run(SampleServiceConfiguration configuration, Environment environment) throws Exception {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();
        environment.addResource(new SampleResource(template, defaultName));
        environment.addHealthCheck(new SampleHealthCheck(template));
    }
}
