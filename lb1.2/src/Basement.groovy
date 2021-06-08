class Basement implements IPart {
    def partName = "Basement"

    @Override
    def Instaling(workers, House house, def base, Team _team) {
        if (workers.size() < house.basementW) {
            println("We nead more workers")
            _team.AddWorker("Валера")
            _team.Building(house , _team)
        }else if( workers.size() > house.basementW){
            println("We nead less workers")
            _team.RemoveLastWorker()
            _team.Building(house, _team)
        }
        else {
            println("Basement instaled")
            house.basementN--
            house.parts.push(base)
            if(house.basementN == 0){
                house.buildingStatus.basement = true
            }
        }

    }
}