package neo4jTest;

import neo4jTest.entity.node.Person;
import neo4jTest.entity.relation.Friend;
import neo4jTest.repository.FriendRepository;
import neo4jTest.repository.PersonRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Test {
    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(Neo4jConfig.class);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
        Person haiping = personRepository.save(new Person("haiping",23L));
        Person baowei = personRepository.save(new Person("baowei",24L));
        System.out.println(haiping);
        System.out.println(baowei);
        long count = personRepository.count();
        System.out.println(count);
        Iterable<Person> people = personRepository.findAll();
        for(Person person:people){
            System.out.println(person);
        }
        FriendRepository friendRepository = context.getBean(FriendRepository.class);
        Friend friend = new Friend();
        friend.setStartNode(baowei);
        friend.setEndNode(haiping);
        Friend f = friendRepository.save(friend);
        System.out.println(f);
    }
}
