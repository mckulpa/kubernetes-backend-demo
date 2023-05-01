# Just a pod

### Calling app from within the cluster (by connecting to another pods shell)

    kubectl exec --stdin --tty curl -- /bin/sh

Try a few options - which ones do you think will work? Remember to update the IP value to whatever the `naming` pod has been assigned.

    / $ curl -X POST naming:8082/v1/lastname
    / $ curl -X POST naming-ctr:8082/v1/lastname
    / $ curl -X POST 10.244.2.16:8082/v1/lastname

### Calling app from outside of cluster

Port forwarding

### Pod removal

Notice if anything happens when Pod is removed