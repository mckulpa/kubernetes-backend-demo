# ConfigMap with Volume

Give all the resources a few minutes to run and try to hit the `api-gateway`:

    curl -X POST localhost:8180/v1/person

# Other

Notice that this defines one ConfigMap entry with key `application.yaml` and multiline value

    data:
        application.yaml: |
            external.identity.url: "http://identity-clusterip:8181/v1"
            external.naming.url: "http://naming-clusterip:8182/v1"

Notice that (depends on how the docker image is built) additional properties locations may be passed to application
using `spring.config.location`. As all Spring properties this can be set in multiple ways:
- as Java application arguments (`java -jar app.jar --spring.config.location="/app/config/application.yaml`)
- in `JAVA_OPTS` environment variable (by appending `-Dspring.config.location="/app/config/application.yaml`)
- or as a separate `SPRING_CONFIG_LOCATION` environment variable value

Try viewing the mounted `application.yaml` file contents inside a running pod.

Notice that for Spring it is also possible to use:
- Spring Cloud Kubernetes library to read properties from ConfigMap
(https://docs.spring.io/spring-cloud-kubernetes/docs/current/reference/html/)
- Spring Config Server to read configuration from a repository (https://spring.io/guides/gs/centralized-configuration/)
