class lb1 {
    static void main(String[] args) {
        House littleHome = new House(basementN: 1, wallN: 4, roofN: 1 , doorN: 1 , windowN: 4)
        TeamLeader Vitalic = new TeamLeader(Name: "Vitalic", project: littleHome)
        Team alcoTeam = new Team(teamLeader: Vitalic)
        alcoTeam.Building(littleHome , alcoTeam)
    }
}
