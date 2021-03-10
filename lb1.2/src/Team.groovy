class Team {
    def teamLeader
    def workers = []
    public def Building(def _house , Team _team){
        if (workers.size() != 0){
            for(int i; i < _house.basementN;i++)
            {
                Basement basement = new Basement()
                basement.Instaling(workers , _house , basement , _team)
            }
            for(int i; i < _house.wallN;i++)
            {
                Wall wall = new Wall()
                wall.Instaling(workers , _house , wall , _team)
            }
            for(int i; i <_house.roofN;i++)
            {
                Roof roof = new Roof()
                roof.Instaling(workers , _house , roof , _team)
            }
            for(int i; i < _house.doorN;i++)
            {
                Door door = new Door()
                door.Instaling(workers , _house , door , _team)
            }
            for(int i; i < _house.windowN;i++)
            {
                Window window = new Window()
                window.Instaling(workers , _house , window , _team)
            }
        }else {
            println("We have not workers")
            AddWorker("Иван")
            Building(_house , _team)
        }

    }
    public def AddWorker(IWorker a){
        workers.add(a)
    }
    public def AddWorker(String _name){
        workers.add(new Worker(Name: _name))
    }
    public def RemoveWorker(IWorker w){
        workers.remove(w)
    }
    public def RemoveLastWorker(){
        def w = workers.last()
        RemoveWorker(w)
    }
}
