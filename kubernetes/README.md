# Minikube

## Installation

    brew install minikube
    brew install kubectl

## Cluster creation

    minikube start --nodes 3

For some exercises running a tunnel is also necessary - run this in a separate terminal window and leave it running in the background.

    minikube tunnel

This will route `localhost` traffic to your Minikube cluster. Running a tunnel is necessary only for macOS - on Linux you should be fine with using Minikube IP (run `minikube ip` in bash or just check IP of the nodes) to communicate with the cluster.

### Dealing with registry access error

When you notice the following error during Minikube startup:

    ❗  This container is having trouble accessing https://registry.k8s.io
    💡  To pull new external images, you may need to configure a proxy: https://minikube.sigs.k8s.io/docs/reference/networking/proxy/

The cluster will still be started, but you may end up having issues when enabling addons, e.g.:
    
    minikube addons enable ingress

    (...)

    🔎  Verifying ingress addon...
    ❌  Exiting due to MK_ADDON_ENABLE: enable failed: run callbacks: running callbacks: [waiting for app.kubernetes.io/name=ingress-nginx pods: timed out waiting for the condition]

It may be because certificates cannot be validated due to your company proxy that wraps your traffic with a custom
certificate (e.g. ZScaler). This certificate can be added with the following commands:

    openssl x509 -inform der -in my_company.cer -out my_company.pem
    mkdir -p $HOME/.minikube/files/etc/docker/certs.d/registry.k8s.io:5000
    cp my_company.pem $HOME/.minikube/files/etc/docker/certs.d/registry.k8s.io:5000
    
Restart Minikube (stopping is not necessary)

    minikube start

Above example will fix only `registry.k8s.io` registry, so you may want to repeat this for other registries you want to
connect to (also change the default `5000` port to whatever port this registry is using).

## Installation of additional tools

    brew install k9s
    brew install stern
    brew install derailed/popeye/popeye
    brew install helm

Please note that k9s has popeye integrated (type `:popeye` in k9s).

## Cluster deletion

    minikube delete

# Azure

    brew install azure-cli
    brew install Azure/kubelogin/kubelogin
    az login --tenant YOUR_TENANT_ID
    az account set -s YOUR_SUBSCRIPTION
    az aks get-credentials --resource-group eun-dev-213-csi1-aksblue --name eun-dev-213-csi1-aksblue
    kubectl config use-context eun-dev-213-csi1-aksblue
    kubectl config set-context --current --namespace=devops-k8s-training
