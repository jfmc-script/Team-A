team = userInput (
        type : "STRING", // "BOOLEAN", "INTEGER", "INSTANCE", "REPOSITORY"
        description : "Repository Key",
        validations : (["cron"])
)
packageTypeUserInput = userInput (
name : "Input name Package Type",
type : "PACKAGE_TYPE",
value : "",
description : "please provide a value"
)
//construct a namespace
//team-technology-maturity-location
def maturitylist = ["dev", "prod"]
//def locationslist = ["sunnyvale", "shanghai"]
localname = ""
//virtname = ""
//def virtualrepos = []
def localrepos = []
/* def namecreator(String maturity, String location)
{ //this function creates a list of all repos
    String localname = team + "-" + packageTypeUserInput + "-" + maturity + "-" + location
    return localname
    //localrepos.add (localname)
}*/
//virtname = team + "-" + packageTypeUserInput + "-" + maturity
//virtualrepos.add(virtname)
//}
//}
//def localservice=services["Art-2"]
services.each { servicename,localservice ->
    artifactory(localservice.name)
            {
              def maturity="prod"
              def location="local"
              //packaageTypeUserInput="generic"
              String repokeyPrefix = team + "-" + packageTypeUserInput + "-" + maturity 
              String repokey=repokeyPrefix + "-" + location
                localRepository(/*"random-generic-prod-local"*/repokey) {
                    description "Public Description"
                    notes "Some internal notes"
                    packageType packageTypeUserInput // "maven" | "gradle" | "ivy" | "sbt" | "nuget" | "gems" | "npm" | "bower" | "debian" | "pypi" | "docker" | "vagrant" | "gitlfs" | "yum" | "generic"
                }
              services.each { servicename1,remoteservice ->
               if(remoteservice.name!=localservice.name) {
                       String repokey1=repokeyPrefix+ "-"+remoteservice.name
                       localRepository(/*"random-generic-prod-local"*/repokey1) {
                    	description "Public Description"
                    	notes "Some internal notes"
                    	packageType packageTypeUserInput // "maven" | "gradle" | "ivy" | "sbt" | "nuget" | "gems" | "npm" | "bower" | "debian" | "pypi" | "docker" | "vagrant" | "gitlfs" | "yum" | "generic"
                		}
             
            	}
              }
              string virtualRepoKey=repokeyPrefix
              def remoteRepos = services.collect{key,serviceindividual -> serviceindividual.name}
              virtualRepository(virtualRepoKey) {
                description "virtual descirption"
                notes "special notes"
                repositories(remoteRepos)
              }
            }
}