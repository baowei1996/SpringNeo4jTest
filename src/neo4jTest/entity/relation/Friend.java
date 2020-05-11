package neo4jTest.entity.relation;

import neo4jTest.entity.node.Person;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "friend")
public class Friend {
    @Id
    @GeneratedValue
    Long id;
    @StartNode
    Person startNode;
    @EndNode
    Person endNode;

    public Person getStartNode() {
        return startNode;
    }

    public void setStartNode(Person startNode) {
        this.startNode = startNode;
    }

    public Person getEndNode() {
        return endNode;
    }

    public void setEndNode(Person endNode) {
        this.endNode = endNode;
    }
}
