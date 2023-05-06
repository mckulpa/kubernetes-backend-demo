# Helm - Umbrella Chart

Notice apps are organized in subdirectories of a `charts` directory and you can install of them by installing the root Chart

    helm install kubernetes-demo kubernetes-demo-chart

# Other

Notice what happens when you try to install the same Chart multiple times with different name

    helm install kubernetes-demo kubernetes-demo-chart
    helm install kubernetes-demo-2 kubernetes-demo-chart 