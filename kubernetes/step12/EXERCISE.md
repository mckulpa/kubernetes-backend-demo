# Helm - Umbrella Chart

Notice apps are organized in subdirectories of a `charts` directory, and you can install all of them by installing the root Chart
```bash
helm install kubernetes-demo kubernetes-demo-chart
```

# Other

Notice what happens when you try to install the same Chart multiple times with different name
```bash
helm install kubernetes-demo kubernetes-demo-chart
```
```bash
helm install kubernetes-demo-2 kubernetes-demo-chart 
```
