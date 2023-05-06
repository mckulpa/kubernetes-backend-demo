# Helm

## Repo and Hub

    helm repo add stable https://charts.helm.sh/stable

    helm search repo

Notice almost all Charts are deprecated

    helm search hub sonarqube --list-repo-url

    helm repo add sonarsource https://SonarSource.github.io/helm-chart-sonarqube

    helm search repo sonarqube
    
    helm show chart sonarsource/sonarqube

    helm install sonarqube sonarsource/sonarqube

    helm list

    kubectl get secret | grep sonarqube
    
    helm uninstall sonarqube

## Chart Install, Upgrade, Rollback

### Installing

    helm install kubernetes-demo kubernetes-demo-chart
    helm list
    helm get manifest kubernetes-demo

### Upgrading

1. Change `appVersion` in `Chart.yaml` to `1.2.0`
2. Change container image versions to `1.2.0` in all `template/*-deployment.yaml` files:

   * `mckulpa/k8s-demo-naming:1.0.0` -> `mckulpa/k8s-demo-naming:1.2.0`
   * `mckulpa/k8s-demo-api-gateway:1.0.0` -> `mckulpa/k8s-demo-api-gateway:1.2.0`
   * `mckulpa/k8s-demo-identity:1.0.0` -> `mckulpa/k8s-demo-identity:1.2.0`
   
3. Run Upgrade and check results

       helm upgrade kubernetes-demo kubernetes-demo-chart
       helm list
       helm get manifest kubernetes-demo

### Rollback

    helm history kubernetes-demo
    helm rollback kubernetes-demo 1

### Uninstall

    helm uninstall kubernetes-demo

# Other

Notice Chart Version did not change
Notice Revision changes with each upgrade even when nothing changes, and we rerun the command
Notice App Version in theory does not have to be in line with container image versions used, it is purely informational