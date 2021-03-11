class House {
    public def parts = []
    int basementN
    int wallN
    int roofN
    int doorN
    int windowN
    int basementW = 3
    int wallW = 2
    int roofW = 2
    int doorW = 1
    int windowW = 1
    def buildingStatus = [
            "basement": false,
            "walls":false,
            "roof" : false,
            "door" : false,
            "windows" : false
    ]

}
