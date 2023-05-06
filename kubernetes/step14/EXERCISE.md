# Helm - multiple releases in one namespace

Prefixing resource names with `{{ .Release.Name }}` allows us to have multiple instances of the system installed in one namespace.

In order to reduce repetition and ease maintenance we can use definitions in `_helpers.tpl` file. Prefixing file name with `_` will prevent Helm from trying to run templating engine on them.

Notice direct `{{ .Release.Name }}` usage on `ingress.yaml` as well as using a custom template definition (`{{ include "api-gateway.name" . }}`) in `api-gateway-deployment.yaml`.

Install two releases in one namespace:

     helm install dev kubernetes-demo-chart
     helm install prod kubernetes-demo-chart

Test both releases (notice release name was included in ingress path):

    curl -X POST localhost/dev/v1/person
    curl -X POST localhost/prod/v1/person

## Other

Notice that definitions in `_helpers.tpl` should have names scoped to sub-chart to avoid naming conflicts.