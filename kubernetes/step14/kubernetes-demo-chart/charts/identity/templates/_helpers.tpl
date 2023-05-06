{{- define "identity.name" -}}
{{ .Release.Name }}-{{ .Chart.Name }}
{{- end -}}