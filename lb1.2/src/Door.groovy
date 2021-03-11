class Door implements IPart{
    def partName = "Door"
    @Override
    def Instaling(workers, House house, def base, Team _team) {
        if (workers.size() < house.doorW) {
            println("We nead more workers")
            _team.AddWorker("Валера")
            _team.Building(house , _team)
        }else if( workers.size() > house.doorW){
            println("We nead less workers")
            _team.RemoveLastWorker()
            _team.Building(house, _team)
        }
        else {
            println("Door instaled")
            house.doorN--
            house.parts.push(base)
            if(house.doorN == 0){
                house.buildingStatus.door = true
            }
        }

    }
}
