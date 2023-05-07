# Helm

## Repo and Hub

```bash
helm repo add stable https://charts.helm.sh/stable
```
```bash
helm search repo
```

Notice almost all Charts are deprecated
```bash
helm search hub sonarqube --list-repo-url
```
```bash
helm repo add sonarsource https://SonarSource.github.io/helm-chart-sonarqube
```
```bash
helm search repo sonarqube
```
```bash
helm show chart sonarsource/sonarqube
```
```bash
helm install sonarqube sonarsource/sonarqube
```
```bash
helm list
```
```bash
kubectl get secret | grep sonarqube
```
```bash
helm uninstall sonarqube
```

## Chart Install, Upgrade, Rollback

### Installing
```bash
helm install kubernetes-demo kubernetes-demo-chart
```
```bash
helm list
```
```bash
helm get manifest kubernetes-demo
```

### Upgrading

1. Change `appVersion` in `Chart.yaml` to `1.2.0`
2. Change container image versions to `1.2.0` in all `template/*-deployment.yaml` files:

   * `mckulpa/k8s-demo-naming:1.0.0` -> `mckulpa/k8s-demo-naming:1.2.0`
   * `mckulpa/k8s-demo-api-gateway:1.0.0` -> `mckulpa/k8s-demo-api-gateway:1.2.0`
   * `mckulpa/k8s-demo-identity:1.0.0` -> `mckulpa/k8s-demo-identity:1.2.0`
   
3. Run Upgrade and check results
   ```bash
   helm upgrade kubernetes-demo kubernetes-demo-chart
   ```
   ```bash
   helm list
   ```
   ```bash
   helm get manifest kubernetes-demo
   ```


### Rollback

```bash
helm history kubernetes-demo
```
```bash
helm rollback kubernetes-demo 1
```

### Uninstall
```bash
helm uninstall kubernetes-demo
```

# Other

Notice Chart Version did not change
Notice Revision changes with each upgrade even when nothing changes, and we rerun the command
Notice App Version in theory does not have to be in line with container image versions used, it is purely informational