import java.awt.List

class lb1 {
    static void main(String[] args) {
        Company myCompany = new Company(_CName: "ManyMakers")
        President mainWorker = new President(_Name: "Oleg", _Salary: 10000)
        Worker worker1 = new Worker(_Name: "Ivan", _Salary: 2500)

        myCompany.workersList.add(mainWorker)
        myCompany.workersList.add(worker1)

        println("Number of workers is " + myCompany.WorkersNumber())
        println("Salary per months in company is " + myCompany.SalaryAll())
    }
}
