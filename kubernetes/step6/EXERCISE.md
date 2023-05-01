# ConfigMap with Environment Variables

Give all the resources a few minutes to run and try to hit the `api-gateway`:

    curl -X POST localhost:8180/v1/person

# Other

Notice that ConfigMap sets data as environment variables and Spring overwrites default `application.yaml` properties 
located at `api-gateway/src/main/resources/application.yaml` (using `this.naming.convention`) with corresponding
environment variables (using `THIS_NAMING_CONVENTION`).
