Overview
========

Demonstration of Kubernetes basics using an example project for person data generation split into multiple services.

api-gateway
-----------

Publicly exposed fronting service. Connects with downstream services (`naming`, `identity`) in order to generate person details.

Endpoints:
- `POST /v1/person` - generate person data, e.g. `{"id":"be9b17f4-b2b1-461f-8b09-0b87e536a858","firstname":"John","lastname":"Lehner"}`

naming
------

Private service with no connection allowed outside of cluster.

Endpoints:
- `POST /v1/firstname` - generate firstname, e.g. `John`
- `POST /v1/lastname` - generate lastname, e.g. `Lehner`

identity
------

Private service with no connection allowed outside of cluster.

Endpoints:
- `POST /v1/uuid` - generate UUID, e.g. `be9b17f4-b2b1-461f-8b09-0b87e536a858`

Running locally (without Kubernetes)
====================================

Run each in separate terminal window:

    ./gradlew :naming:bootRun
    ./gradlew :identity:bootRun
    ./gradlew :api-gateway:bootRun

Or, launch all at once:
    
    ./gradlew bootRun --parallel

Testing the endpoints
=====================

api-gateway:

    curl -X POST localhost:8080/v1/person

identity:

    curl -X POST localhost:8081/v1/uuid

naming:

    curl -X POST localhost:8082/v1/firstname
    curl -X POST localhost:8082/v1/lastname

Build docker image
==================

Just build:

    ./gradlew bootBuildImage

Build and publish to Docker Hub:
    
    export DOCKER_USERNAME=yourDockerHubUsername
    export DOCKER_PASSWORD=yourDockerHubPassword

    ./gradlew bootBuildImage --publishImage

