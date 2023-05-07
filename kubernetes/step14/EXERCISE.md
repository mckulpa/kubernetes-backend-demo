# Helm - multiple releases in one namespace

Prefixing resource names with `{{ .Release.Name }}` allows us to have multiple instances of the system installed in one namespace.

In order to reduce repetition and ease maintenance we can use definitions in `_helpers.tpl` file. Prefixing file name with `_` will prevent Helm from creating a Kubernetes manifest out of it.

Notice direct `{{ .Release.Name }}` usage on `ingress.yaml` as well as using a custom template definition (`{{ include "api-gateway.name" . }}`) in `api-gateway-deployment.yaml`.

Install two releases in one namespace:
```bash
 helm install dev kubernetes-demo-chart
 helm install prod kubernetes-demo-chart
```

Test both releases (notice release name was included in ingress path):
```bash
curl -X POST localhost/dev/v1/person
curl -X POST localhost/prod/v1/person
```

Notice that we could have reused the same paths (without `dev` and `prod`) by specifying a distinct `host` field in
Ingress `rules` instead, e.g. `{{ .Release.Name }}.kubernetes-demo.info`. For local environment this hostname would also
have to be added to `/etc/hosts` file pointing to Minikube IP.

## Dependencies

Notice you can add dependencies that will add Charts to you Umbrella Chart. Add this to root `Chart.yaml` file:
```yaml
dependencies:
    - name: mongodb
      version: 13.10.2
      repository: https://charts.bitnami.com/bitnami
```

Notice `mongodb-13.10.2.tgz` was downloaded to `charts` directory.

## Other

Notice that definitions in `_helpers.tpl` should have names scoped to sub-chart to avoid naming conflicts.

Notice there is still a lot of code duplication, but honestly it might be for the better, having a large chart shared
between multiple services can be a mess to maintain. Nonetheless, here are some ways to solve this:
* Library Chart with merging between two files (this requires all files to be duplicated anyway, they can just be mostly empty) - https://helm.sh/docs/topics/library_charts/
* Dependency with alias (allows to reuse the same Chart multiple times) to local base Chart - https://devops.stackexchange.com/questions/13379/use-one-helm-chart-for-all-microservices
* Dependency with alias to a published base Chart (like above but the base Chart may be pushed to a repo first)