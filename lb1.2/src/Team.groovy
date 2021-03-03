class Team {
    def teamLeader
    def workers = []
    public def Building(def house , int basementN , int wallN, int roofN, int doorN, int windowN){
        for(int i; i < basementN;i++)
        {
            Basement basement = new Basement()
            basement.Instaling()
            house.parts.push(basement)
        }
        for(int i; i < wallN;i++)
        {
            Wall wall = new Wall()
            wall.Instaling()
            house.parts.push(wall)
        }
        for(int i; i <roofN;i++)
        {
            Roof roof = new Roof()
            roof.Instaling()
            house.parts.push(roof)
        }
        for(int i; i < doorN;i++)
        {
            Door door = new Door()
            door.Instaling()
            house.parts.push(door)
        }
        for(int i; i < windowN;i++)
        {
            Window window = new Window()
            window.Instaling()
            house.parts.push(window)
        }
    }
}
