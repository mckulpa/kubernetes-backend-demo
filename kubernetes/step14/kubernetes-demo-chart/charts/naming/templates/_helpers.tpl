{{- define "naming.name" -}}
{{ .Release.Name }}-{{ .Chart.Name }}
{{- end -}}