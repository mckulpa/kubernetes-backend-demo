# Helm - multiple releases in one namespace

Prefixing resource names with `{{ .Release.Name }}` allows us to have multiple instances of the system installed in one namespace.

In order to reduce repetition and ease maintenance we can use definitions in `_helpers.tpl` file. Prefixing file name with `_` will prevent Helm from trying to run templating engine on them.

Notice direct `{{ .Release.Name }}` usage on `ingress.yaml` as well as using a custom template definition (`{{ include "api-gateway.name" . }}`) in `api-gateway-deployment.yaml`.

## Other

Notice that even though definitions in `_helpers.tpl` file are accessible globally they are resolved for each sub-chart,
so in `api-gateway-configmap.yaml` we cannot simply use:

    external.identity.url: "http://{{ include "identity.name" . }}:8181/v1"
    external.naming.url: "http://{{ include "naming.name" . }}:8182/v1"

It would install correctly, but it would be resolved to:

    external.identity.url: "http://kubernetes-demo-api-gateway:8181/v1"
    external.naming.url: "http://kubernetes-demo-api-gateway:8182/v1"                                                                                       │
                                                                      
Instead of:

    external.identity.url: "http://kubernetes-demo-identity:8181/v1"
    external.naming.url: "http://kubernetes-demo-naming:8182/v1"             