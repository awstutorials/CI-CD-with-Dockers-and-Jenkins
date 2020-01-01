# CI-CD-with-Dockers-and-Jenkins

For details on how to use the repo refer to our blog: https://blog.avmconsulting.net/posts/2019-04-07-automated-ci-cd-with-docker-and-jenkins/

Jenkins on Google cloud Kubernetes

1. Create a project in Google cloud. I used the name in28minutes-2
2. Follow the instructions here to create kubernetes cluster & install Jenkins on that cluster using Helm(https://cloud.google.com/solutions/jenkins-on-kubernetes-engine-tutorial)
3. Run the below command to give access for jenkins service account to use Google API's
```
kubectl create clusterrolebinding jenkins-deploy \
    --clusterrole=cluster-admin --serviceaccount=default:cd-jenkins
kubectl apply -f jenkins-volume-persistentvolumeclaim.yaml
```



