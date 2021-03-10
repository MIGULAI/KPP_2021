class Window implements IPart{
    def partName = "Window"
    @Override
    def Instaling(workers, House house, def base, Team _team) {
        if (workers.size() < house.windowW) {
            println("We nead more workers")
            _team.AddWorker("Валера")
            _team.Building(house , _team)
        }else if( workers.size() > house.windowW){
            println("We nead less workers")
            _team.RemoveLastWorker()
            _team.Building(house, _team)
        }
        else {
            println("Window instaled")
            house.windowN--
            house.parts.push(base)
        }

    }
}
