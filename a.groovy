
// ask user for repository to replicate
repo = userInput(name: "Repository to replicate:", type: "REPOSITORY")
// ask user for instances to replicate to
other = userInput(name: "Instances to replicate to:", type: "ARTIFACTORY", multivalued: true)

def idx = 0, otherk = []
while (true) {
  try {
    def x = other[idx].name
    otherk << other[idx]
  } catch (NullPointerException ex) {
    break
  }
  idx += 1
}

for (art in otherk) {
  artifactory(other[5].name) {
      localRepository('repo') {
        description 'foobar'
        //  packageType "generic"
      }
  }
}
