import database.Creator;
import database.dao.AddressDAO;
import database.dao.AddressImp;
import database.dao.PeopleDAO;
import database.dao.PeopleImp;
import database.entity.Address;
import database.entity.People;

import java.util.List;

public class Join {
    public static void main(String[] args) {
        Creator creator = new Creator();
        creator.createDB();
        creator.createTable();

        AddressDAO addressDAO = new AddressImp();
        PeopleDAO peopleDAO = new PeopleImp();

        for (int i = 1; i < 6; i++) {
            Address address = Address.builder()
                    .id(i)
                    .street("street" + i + i)
                    .house(i)
                    .build();
            addressDAO.save(address);

            People people = People.builder()
                    .id(i)
                    .name("name" + i)
                    .surname("surname" + i)
                    .age(i + 20)
                    .build();
            peopleDAO.save(people);
        }

        List<Address> addressList = addressDAO.getAll();
        List<People> peopleList = peopleDAO.getAll();
        for (int i = 1; i <= 2; i++) {
            Address address = addressList.get(addressList.size() - i);
            address.setHouse(address.getHouse() + 1);
            addressDAO.update(address);

            People people = peopleList.get(peopleList.size() - i);
            people.setAge(people.getAge() + 2);
            peopleDAO.update(people);
        }

        addressDAO.delete(addressList.get(1));
        peopleDAO.delete(peopleList.get(1));
    }
}
