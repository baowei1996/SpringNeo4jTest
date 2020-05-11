package neo4jTest.repository;

import neo4jTest.entity.relation.Friend;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface FriendRepository extends Neo4jRepository<Friend,Long> {
}
