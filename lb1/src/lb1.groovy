import java.awt.List

//поиск сотрудников
//добавление,удаление одного сотрудника

class lb1 {
    static void main(String[] args) {
        President mainWorker = new President(_Name: "Oleg", _Salary: 10000)

        Company myCompany = new Company(_CName: "ManyMakers" , president: mainWorker)

        Worker worker1 = new Worker(_Name: "Ivan", _Salary: 2500)
        myCompany.AddNewWorker(worker1)

        println("Number of workers is " + myCompany.WorkersNumber())
        println("Salary per months in company is " + myCompany.SalaryAll())
    }
}
