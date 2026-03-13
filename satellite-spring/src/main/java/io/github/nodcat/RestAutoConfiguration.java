package io.github.nodcat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

/**
 * @author nodcat
 * @version 1.0
 * @since 2026/2/13 上午10:37
 */
@AutoConfiguration
@ConditionalOnWebApplication
@ConfigurationProperties(prefix = "nasa")
public class RestAutoConfiguration {

    /**
     * 密钥
     */
    private String mapKey;

    /**
     * 范围
     */
    private String area;

    public void setArea(String area) {
        this.area = area;
    }

    public void setMapKey(String mapKey) {
        this.mapKey = mapKey;
    }

    public String getMapKey() {
        return mapKey;
    }

    public String getArea() {
        return area;
    }


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
    public SatelliteClientProperties clientProperties(){
        return  new SatelliteClientProperties(
                mapKey,
                area
        );
    }
}
