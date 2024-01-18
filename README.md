# springboot-observability

>NB :  Observations are using Micrometer’s official naming convention, but Metrics names will be automatically converted to the format preferred by the monitoring system backend (Prometheus, Atlas, Graphite, InfluxDB…​).To learn more about Micrometer’s capabilities, see its reference documentation 

>NB : To create observations by using the @Observed aspect, we need to add the org.springframework.boot:spring-boot-starter-aop dependency. 
