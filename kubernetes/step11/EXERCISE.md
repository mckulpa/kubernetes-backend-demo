# Helm

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

# Other

