# Ingress

When using Minikube, ingress addon has to be enabled
```bash
minikube addons enable ingress
```

```bash
curl -X POST localhost/api-gateway/v1/person
curl -X POST localhost/identity/v1/uuid
curl -X POST localhost/naming/v1/lastname
```

# Other

Notice Ingress runs on ports 80/443

Notice all services can be reached with one ingress instead (LoadBalancer requires separate instance for each service)

Notice you can fork the traffic to the right service using custom prefixes 
