createLocalRepo

repokeyArt1 = userInput (
    type : "STRING", // "BOOLEAN", "INTEGER", "INSTANCE", "REPOSITORY"
    description : "Repository Key",
    validations : (["cron"])
  )

artifactory("Art-1") { //Enter the source artifactory node
localRepository(repokeyArt1) {
description "Public description"
    notes "Some internal notes"
    includesPattern "**/*" // default
    excludesPattern "" // default
    repoLayoutRef "maven-2-default"
    propertySets // (["ps1", "ps2"])
    archiveBrowsingEnabled false
    blackedOut false // default
    packageType "generic"
}
}


artifactory("Art-2") { //Enter the target/s artifactory. Repeat the artifactory closure for every target in star topology.
localRepository(repokeyArt1) {
description "Public description"
    notes "Some internal notes"
    includesPattern "**/*" // default
    excludesPattern "" // default
    repoLayoutRef "maven-2-default"
    propertySets // (["ps1", "ps2"])
    archiveBrowsingEnabled false
    blackedOut false // default
    packageType "generic"
}
}

artifactory("Art3-TEAMD") { //Enter the target/s artifactory. Repeat the artifactory closure for every target in star topology.
localRepository(repokeyArt1) {
description "Public description"
    notes "Some internal notes"
    includesPattern "**/*" // default
    excludesPattern "" // default
    repoLayoutRef "maven-2-default"
    propertySets // (["ps1", "ps2"])
    archiveBrowsingEnabled false
    blackedOut false // default
    packageType "generic"
}
}

createPushReplication

artifactory("Art-2") { //Enter the source artifactory node
remoteRepository ('teamc-generic-remote') {
    description "Public description"
    notes "Some internal notes"
    includesPattern "**/*" // default
    excludesPattern "" // default
    repoLayoutRef "maven-2-default"
    propertySets // (["ps1", "ps2"])
    archiveBrowsingEnabled false
    blackedOut false // default
    url "https://artifactory-edge1-team-c.jfrogdev.co/artifactory/teamc-generic-local"
    username "admin"
    password "password" 
    packageType "generic"
    proxy "proxy-ref"
    socketTimeoutMillis 15000
    retrievalCachePeriodSecs 43200
    failedRetrievalCachePeriodSecs 30
    missedRetrievalCachePeriodSecs 7200
    unusedArtifactsCleanupEnabled false
    unusedArtifactsCleanupPeriodHours 0
    shareConfiguration false
    synchronizeProperties false
    enableCookieManagement false
  }
}

remoteRepo

artifactory("Art-2") { //Enter the source artifactory node
remoteRepository ('teamc-generic-remote') {
    description "Public description"
    notes "Some internal notes"
    includesPattern "**/*" // default
    excludesPattern "" // default
    repoLayoutRef "maven-2-default"
    propertySets // (["ps1", "ps2"])
    archiveBrowsingEnabled false
    blackedOut false // default
    url "https://artifactory-edge1-team-c.jfrogdev.co/artifactory/teamc-generic-local"
    username "admin"
    password "password" 
    packageType "generic"
    proxy "proxy-ref"
    socketTimeoutMillis 15000
    retrievalCachePeriodSecs 43200
    failedRetrievalCachePeriodSecs 30
    missedRetrievalCachePeriodSecs 7200
    unusedArtifactsCleanupEnabled false
    unusedArtifactsCleanupPeriodHours 0
    shareConfiguration false
    synchronizeProperties false
    enableCookieManagement false
  }
}
