#!groovy 

#declaring a function

def decidepipeline(Map configMap){
    type = configMap.get("type")
    switch(type) {
        case "nodejsEKS":
            nodejsEKS(configMap)
            break
        case "nodejsVM":
            nodejsVM(configMap)
            break
        default:
            error  "type is not matched"
            break
    }
}