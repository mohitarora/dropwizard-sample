package com.sample.health;

import com.yammer.metrics.core.HealthCheck;

public class SampleHealthCheck extends HealthCheck
{
    private final String template;

    /**
     * Create a new {@link com.yammer.metrics.core.HealthCheck} instance with the given name.
     *
     * @param template the name of the health check (and, ideally, the name of the underlying component the health check
     * tests)
     */
    public SampleHealthCheck(String template)
    {
        super("template");
        this.template = template;
    }

    @Override
    protected Result check() throws Exception
    {
        final String message = String.format(template, "TEST");
        if (!message.contains("TEST"))
        {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}
