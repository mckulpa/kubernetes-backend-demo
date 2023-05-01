# Two pods and a NodePort service

### Calling service from within the cluster (by connecting to another pods shell)

    kubectl exec --stdin --tty curl -- /bin/sh

Try a few options. Remember to update the IP value to whatever the `naming` pod has been assigned.

    / $ curl -X POST naming-nodeport:8182/v1/lastname
    / $ curl -X POST 10.111.112.196:8182/v1/lastname

### Calling service from outside of cluster

No port forwarding is needed anymore. Now we can communicate via node IP (any node!) from outside the cluster:
    
    curl -X POST 192.168.49.2:30082/v1/lastname

But it doesn't work! Our local minikube setup needs additional tunnel:

    minikube service naming-nodeport --url
    curl -X POST localhost:54065/v1/lastname

### Other

    kubectl get service
    kubectl get nodes -o wide

Notice EXTERNAL-IP is <none>
