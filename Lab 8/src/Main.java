import java.util.List;

public class Main {
    public static void main(String[] args) {
        // adding all regular workers
        Employee John;
        Employee Mary;
        Employee Jane;
        Employee Tom;
        Employee Nick;
        Employee Rob;
        Employee Ed;
        Employee Rick;
        Employee Michael;
        Employee Joe ;
        Employee Frank;
        Employee Sam;
        Employee Greg;
        Employee Amy;
        Employee Wil;
        Employee Nancy;
        Employee Adam;

        // adding supervisors
        Employee Jack;
        Employee Jeff;

        // adding project leaders
        Employee Chuck;
        Employee Denise;

        // adding managers
        Employee Bob;
        Employee Rachel;

        //adding CEO
        Employee Steve;

       //creating new worker objects
        //all these workers are supervised by jack
        John = new Worker("John");
        Mary = new Worker("Mary");
        Jane = new Worker("Jane");
        Tom = new Worker("Tom");
        Nick = new Worker("Nick");
        List<Employee> workersUnderJack = List.of(John, Mary, Jane, Tom, Nick);//adding workers to a list
        Jack = new Supervisor("Jack", workersUnderJack);
        John.setDirectOverseer(Jack);
        Mary.setDirectOverseer(Jack);
        Jane.setDirectOverseer(Jack);
        Tom.setDirectOverseer(Jack);
        Nick.setDirectOverseer(Jack);

       //creating worker objects that are supervised by jeff
        Rob = new Worker("Rob");
        Ed = new Worker("Ed");
        Rick = new Worker("Rick");
        Michael = new Worker("Michael");
        List<Employee> workersUnderJeff = List.of(Rob, Ed, Rick, Michael);
        Jeff = new Supervisor("Jeff", workersUnderJeff);
        Rob.setDirectOverseer(Jeff);
        Ed.setDirectOverseer(Jeff);
        Rick.setDirectOverseer(Jeff);
        Michael.setDirectOverseer(Jeff);

      //adding workers who are under by chuck
        Joe = new Worker("Joe");
        Frank = new Worker("Frank");
        Sam = new Worker("Sam");
        Greg = new Worker("Greg");
        List<Employee> workersUnderChuck = List.of(Joe, Frank, Sam, Greg);
        Chuck = new ProjectLeader("Chuck", workersUnderChuck);
        Joe.setDirectOverseer(Chuck);
        Frank.setDirectOverseer(Chuck);
        Sam.setDirectOverseer(Chuck);
        Greg.setDirectOverseer(Chuck);

        //adding workers who are under Denise
        Amy = new Worker("Amy");
        Wil = new Worker("Wil");
        Nancy = new Worker("Nancy");
        Adam = new Worker("Adam");
        List<Employee> workersUnderDenise = List.of(Amy, Wil, Nancy, Adam);
        Denise = new ProjectLeader("Denise", workersUnderDenise);
        Amy.setDirectOverseer(Denise);
        Wil.setDirectOverseer(Denise);
        Nancy.setDirectOverseer(Denise);
        Adam.setDirectOverseer(Denise);


        List<Employee> supervisors = List.of(Jack, Jeff);
        Bob = new Manager("Bob", supervisors);
        Jack.setDirectOverseer(Bob);
        Jeff.setDirectOverseer(Bob);


        List<Employee> leads = List.of(Chuck, Denise);
        Rachel = new Manager("Rachel", leads);
        Chuck.setDirectOverseer(Rachel);
        Denise.setDirectOverseer(Rachel);

        List<Employee> upperManagement = List.of(Bob, Rachel);
        Steve = new CEO("Steve", upperManagement);
        Bob.setDirectOverseer(Steve);
        Rachel.setDirectOverseer(Steve);


        //run simulation
        System.out.println("Scenario: John observes a gasleak from a large tank and reports it to h is supervisor\n");
        Hazard hazard = new Hazard("Gas leak","Gas leak from large tank", 10);
        John.seeDanger(null, hazard);
    }
}

