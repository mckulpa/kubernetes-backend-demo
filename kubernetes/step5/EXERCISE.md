# More apps, Deployments and Services

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

#TODO Deployment update and rollback 