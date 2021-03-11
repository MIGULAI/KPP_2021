import java.awt.List

class Company {
    public String _CName
    def workersList = []
    public President president

    public int WorkersNumber(){
        def number = workersList.size() + 1
    }

    public def FindWorker(def worker){
        workersList.find(it == worker)
    }
    public def FindAllWorker(def worker){
        
    }

    public int SalaryAll(){
        def sum = workersList.sum(){it._Salary}
        sum += president._Salary
    }
    public void AddNewWorker(def worker){
        workersList.add(worker)
    }
    public void DeleteFromWorker(def worker){
        workersList.remove(worker)
    }
    //groovy работа с колекциями Collect
    public def ReturnWorkers(){
        def arrayReturn = []
        workersList.forEach(){
            if (it instanceof Worker)
                arrayReturn.add(it)
        }
    }
}
