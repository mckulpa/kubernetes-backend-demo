# Two pods and a LoadBalancer service

### Calling service from within the cluster (by connecting to another pods shell)
```bash
kubectl exec --stdin --tty curl -- /bin/sh
```

Try a few options - which ones do you think will work? Remember to update the IP value to whatever the `naming` pod has been assigned.
```bash
curl -X POST naming-clusterip:8182/v1/lastname
curl -X POST 10.110.227.144:8182/v1/lastname
```

### Calling service from outside of cluster
```bash
kubectl get service
```

Notice `EXTERNAL-IP` column. Our local minikube setup needs additional tunnel:
```bash
minikube tunnel
```
```bash
kubectl get service
```

Notice `EXTERNAL-IP` column again.
```bash
curl -X POST localhost:8182/v1/lastname
```

### Other

```bash
kubectl get service
```
```bash
kubectl get nodes -o wide
```
