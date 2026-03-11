package com.nodcat.satellite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/13 上午10:37
 */
@AutoConfiguration
@ConditionalOnWebApplication
public class RestAutoConfiguration {

    @Autowired
    SatelliteConfig satelliteConfig;

    @Bean
    @ConditionalOnMissingBean
    public MapKeyController mapKeyController() {
        return new MapKeyController();
    }

    @Bean
    public SatelliteClient satelliteClient(){
        return new SatelliteClientImpl(clientProperties());
    }

    @Bean
    public  SatelliteClientProperties clientProperties(){
        return  new SatelliteClientProperties(
                satelliteConfig.getMapKey(),
                satelliteConfig.getArea()
        );
    }
}
