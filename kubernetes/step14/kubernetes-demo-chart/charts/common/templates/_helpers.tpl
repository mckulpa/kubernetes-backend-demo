{{- define "common.basic-service-account-name" -}}
{{ .Release.Name }}-{{ .Chart.Name }}-basic
{{- end -}}