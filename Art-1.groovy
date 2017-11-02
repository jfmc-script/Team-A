artifactory('Artifactory-1'){
   localRepository("docker-local") {
     packageType "docker"
     description "My local Docker registry"
   }
}