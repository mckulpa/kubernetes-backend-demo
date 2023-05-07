# Helm - multiple releases in one namespace

Prefixing resource names with `{{ .Release.Name }}` allows us to have multiple instances of the system installed in one namespace.

In order to reduce repetition and ease maintenance we can use definitions in `_helpers.tpl` file. Prefixing file name with `_` will prevent Helm from creating a Kubernetes manifest out of it.

Notice direct `{{ .Release.Name }}` usage on `ingress.yaml` as well as using a custom template definition (`{{ include "api-gateway.name" . }}`) in `api-gateway-deployment.yaml`.

Install two releases in one namespace:

     helm install dev kubernetes-demo-chart
     helm install prod kubernetes-demo-chart

Test both releases (notice release name was included in ingress path):

    curl -X POST localhost/dev/v1/person
    curl -X POST localhost/prod/v1/person

Notice that we could have reused the same paths (without `dev` and `prod`) by specifying a distinct `host` field in
Ingress `rules` instead, e.g. `{{ .Release.Name }}.kubernetes-demo.info`. For local environment this hostname would also
have to be added to `/etc/hosts` file pointing to Minikube IP.

## Other

Notice that definitions in `_helpers.tpl` should have names scoped to sub-chart to avoid naming conflicts.