package interfaces;

import humans.Person;

public interface CheckingAbilityAction {
    default void checkAbilityAction(Person person){
        if(person.getStatusSleeping()== Person.StatusSleeping.sleeping){
            System.err.printf("%n%s is sleeping now", person.getName());
        }
    }
}