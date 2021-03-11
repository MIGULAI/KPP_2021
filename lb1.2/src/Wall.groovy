class Wall implements IPart {
    def partName = "Wall"
    @Override
    def Instaling(workers, House house, def base, Team _team) {
        if (workers.size() < house.wallW) {
            println("We nead more workers")
            _team.AddWorker("Валера")
            _team.Building(house , _team)
        }else if( workers.size() > house.wallW){
            println("We nead less workers")
            _team.RemoveLastWorker()
            _team.Building(house, _team)
        }
        else {
            println("Wall instaled")
            house.wallN--
            house.parts.push(base)
            if(house.wallN == 0){
                house.buildingStatus.walls = true
            }
        }

    }
}
