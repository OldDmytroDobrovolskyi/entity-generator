package com.softserve.entity.generator.config;


import com.softserve.entity.generator.salesforce.WebServiceUtil;
import com.softserve.entity.generator.service.EntityService;
import com.softserve.entity.generator.service.applier.EntityApplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import static org.mockito.Mockito.mock;

@Configuration
@ComponentScan(basePackages = "com.softserve.entity.generator.salesforce")
public class SalesforceMockConfig
{
    @Bean
    public EntityService entityServiceMock()
    {
        return mock(EntityService.class);
    }

    @Bean
    public EntityApplier entityApplierMock()
    {
        return mock(EntityApplier.class);
    }

    @Bean
    public WebServiceUtil webServiceUtil()
    {
        return mock(WebServiceUtil.class);
    }
}
