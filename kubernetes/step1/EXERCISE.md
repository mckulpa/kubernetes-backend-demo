# Just a pod

### Intro to `kubectl`

Look at the available contexts and make sure that you are using `minikube` context

```bash
kubectl config get-contexts
kubectl config current-context
kubectl config use-context minikube 
```

See available nodes

```bash
kubectl get nodes
```

Apply resources in current directory

```bash
kubectl apply -f .
```

See pods

```bash
kubectl get pods
kubectl get pods -o wide
```

See logs

```bash
kubectl logs naming
```

Delete resources in current directory

```bash
kubectl delete -f .
```

### Calling app from within the cluster (by connecting to another pods shell)

```bash
kubectl exec --stdin --tty curl -- /bin/sh
```

Try a few options - which ones do you think will work? Remember to update the IP value to whatever the `naming` pod has been assigned.

```bash
curl -X POST naming:8082/v1/lastname
curl -X POST naming-ctr:8082/v1/lastname
curl -X POST 10.244.1.105:8082/v1/lastname
```

### Calling app from outside of cluster

Try a few options - which ones do you think will work? Remember to update the IP value to whatever the `naming` pod has been assigned.

```bash
curl --max-time 3 -v -X POST naming:8082/v1/lastname
```
```bash
curl --max-time 3 -v -X POST 10.244.1.105:8082/v1/lastname
```
```bash
curl --max-time 3 -v -X POST $(minikube ip):8082/v1/lastname
```

Port forwarding is necessary.

### Pod removal

Notice if anything happens when Pod is removed

# Other

Try to do the same operations using `k9s`

Try to view logs using `stern`