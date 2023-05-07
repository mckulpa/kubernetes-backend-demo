# Popeye

Prior to applying yaml files in this directory run

    popeye

See what can be improved. This directory contains all the Popeye suggestions implemented. See what has changed with below command:

    diff -r -U 20 -x '*.md' ../step8 . | bat --language=diff

Verify everything is still working

    curl -X POST localhost/v1/person

## Disruption Budget

Notice that `naming` deployment has 2 replicas and its budget allows minimum 2 pods as well.
Find a node that has a naming pod and try to drain it.

    kubectl get pods -o wide
    kubectl drain minikube-m02 --ignore-daemonsets

Uncordon node to bring it back.

    kubectl uncordon minikube-m02

## Run as non-root

Notice that users created after installation on Linux will usually have IDs starting from 1000. You can check all user 
IDs and names on your system or in Docker container:

    cat /etc/passwd

## Readiness and Liveness

Open logs of all api-gateway pods

    stern "pod/api-gateway-.*"

Send multiple requests

    curl -X POST localhost/v1/person

Notice multiple pods are responding. Break readiness of one of the pods (whichever this request will be routed to):

    curl -X POST localhost/availability/readiness -H 'Content-Type: text/plain' -d 'REFUSING_TRAFFIC'
    
Notice that pod is in Unready state, but it is not restarted. All requests will now be handled by the other pod. Break liveness of the other pod:

    curl -X POST localhost/availability/liveness -H 'Content-Type: text/plain' -d 'BROKEN'

Notice it will be restarted
Notice that failed probes are stored as pod Events

    kubectl describe pod POD_NAME

# Other

Notice how rollouts (update image tag in a deployment and apply) changed too after adding the probes (in comparison to what was observed on step5).