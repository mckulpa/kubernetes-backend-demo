# Helm - Library

Notice that in this step we do not have Ingress paths based on `.Release.Name` so the service is
accessible by the old path again for the sake of simplicity:

    curl -X POST localhost/v1/person

