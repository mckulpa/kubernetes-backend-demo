# Popeye

Prior to applying yaml files in this directory run

    popeye

See what can be improved. This directory contains all the Popeye suggestions implemented.

    diff -U 20 -x '*.md' ../step8 . | bat --language=diff

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

# Other

