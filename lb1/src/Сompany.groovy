import java.awt.List

class Company {
    public String _CName
    def workersList = []
    public President president

    public int WorkersNumber(){
        def number = workersList.size()
        if (president != null)
            number++
    }

    public int SalaryAll(){
        int sum = workersList.sum(){

        }
        workersList.each {
            sum = sum + it._Salary
        }
        if (president != null)
            sum += president._Salary
    }
}
