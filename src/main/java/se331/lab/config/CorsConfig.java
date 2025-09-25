 package se331.lab.config;

 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import org.springframework.web.cors.CorsConfiguration;
 import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
 import org.springframework.web.filter.CorsFilter;

 import java.util.Arrays;

 @Configuration
 public class CorsConfig {
     @Bean
     public CorsFilter corsFilter() {
         CorsConfiguration configuration = new CorsConfiguration();
         configuration.setAllowCredentials(true);
         configuration.addAllowedOriginPattern("*");
         configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
         configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type", "X-Requested-With"));
         configuration.setExposedHeaders(Arrays.asList("x-total-count"));

         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
         source.registerCorsConfiguration("/**", configuration);
         return new CorsFilter(source);
     }
 }


