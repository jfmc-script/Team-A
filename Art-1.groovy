artifactory('Artifactory-1'){
localRepository("my-repository") {
  description userInput (
    type : "STRING",
    value : "This is a generic description",
    description : "Please provide a description"
  )
}
  
}