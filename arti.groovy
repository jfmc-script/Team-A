team = userInput (
        type : "STRING", // "BOOLEAN", "INTEGER", "INSTANCE", "REPOSITORY"
        description : "Repository Key",
        validations : (["cron"])
)
packageTypeUserInput = "generic"
/* userInput (
name : "Input name Package Type",
type : "PACKAGE_TYPE",
value : "",
description : "please provide a value"
) */
//construct a namespace
//team-technology-maturity-location
def maturitylist = ["dev", "prod"]
//def locationslist = ["sunnyvale", "shanghai"]
localname = ""
//virtname = ""
//def virtualrepos = []
def localrepos = []
def namecreator(String maturity, String location)
{ //this function creates a list of all repos
    String localname = team + "-" + packageTypeUserInput + "-" + maturity + "-" + location
    return localname
    //localrepos.add (localname)
}
//virtname = team + "-" + packageTypeUserInput + "-" + maturity
//virtualrepos.add(virtname)
//}
//}
def localservice=services["Art-2"]
//for (localservice in service) {
    artifactory(localservice)
            {
                localRepository("random-generic-prod-local"/*namecreator("prod","local")*/) {
                    description "Public Description"
                    notes "Some internal notes"
                    packageType packageTypeUserInput // "maven" | "gradle" | "ivy" | "sbt" | "nuget" | "gems" | "npm" | "bower" | "debian" | "pypi" | "docker" | "vagrant" | "gitlfs" | "yum" | "generic"
                }
            }
//}