# Deployments

After applying files in this directory open k9s on deployments and/or pods and change image version of `naming` deployment to `1.1.0` or `1.2.0`.
Apply and notice that a new pod is created and only after then an old one is removed making sure traffic can be handled at all times.

Notice that Kubernetes tracks rollouts:

    kubectl rollout history deployment/naming-deploy

You can also roll back:

    kubectl rollout undo deployment/naming-deploy
    kubectl rollout undo deployment/naming-deploy --to-revision=2

Give all the resources a few minutes to run and try to hit the `api-gateway`:

    curl -X POST localhost:8180/v1/person

You should see the following error:

    {"timestamp":"2023-04-30T19:32:20.183+00:00","status":500,"error":"Internal Server Error","path":"/v1/person"}%

Try to diagnose what might have gone wrong (this will be fixed however in next step)

### Other

Revisit previous steps - what happens when Pod is removed when it is managed by deployment vs when it is not?

Notice apiVersion value in Deployment YAML

Which `metadata.labels` must match the `selector.matchLabels`?

Notice that services still work properly despite deployment having the same label as deployment. Traffic is routed to pods, not deployments.

Notice ReplicaSet is automatically created along Pods and Deployment
