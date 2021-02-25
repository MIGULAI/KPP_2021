import java.awt.List

class Company {
    public String _CName
    def workersList = []

    public int WorkersNumber(){
        return workersList.size()
    }

    public int SalaryAll(){
        int sum = 0
        workersList.each {
            sum = sum + it._Salary
        }
        return sum

    }
}
