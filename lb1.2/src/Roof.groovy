class Roof implements IPart{
    @Override
    @Override
    def Instaling(workers, House house, def base, Team _team) {
        if (workers.size() < house.roofW) {
            println("We nead more workers")
            _team.AddWorker("Валера")
            _team.Building(house , _team)
        }else if( workers.size() > house.roofW){
            println("We nead less workers")
            _team.RemoveLastWorker()
            _team.Building(house, _team)
        }
        else {
            println("Roof instaled")
            house.roofN--
            house.parts.push(base)
        }

    }
}
