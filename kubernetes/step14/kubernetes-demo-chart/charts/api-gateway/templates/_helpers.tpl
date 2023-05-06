{{- define "api-gateway.name" -}}
{{ .Release.Name }}-{{ .Chart.Name }}
{{- end -}}