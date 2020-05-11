package neo4jTest.repository;

import neo4jTest.entity.node.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface PersonRepository extends Neo4jRepository<Person,Long> {
}
