# Two pods and a ClusterIP service

### Calling service from within the cluster (by connecting to another pods shell)
```bash
kubectl exec --stdin --tty curl -- /bin/sh
```

Try a few options - which ones do you think will work? Remember to update the IP value to whatever the `naming` pod has been assigned.

```bash
    curl -X POST naming-clusterip:8182/v1/lastname
```
```bash
    curl -X POST 10.110.227.144:8182/v1/lastname
```

### Calling service from outside of cluster

Port forwarding is necessary

### Other

Can you check application logs to see whether both pods receive the traffic?
