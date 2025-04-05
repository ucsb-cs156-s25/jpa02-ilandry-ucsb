package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void  equals_is_correct() {

        assertEquals(team.equals(team), true);
        String test_team_name = "s";
        assertEquals(team.equals(test_team_name), false);        

        Team test_team_2 = new Team("test-team");
        assertEquals(team.equals(test_team_2), true);

        test_team_2.addMember("0");
        assertEquals(team.equals(test_team_2), false);

        team.addMember("0");
        assertEquals(team.equals(test_team_2), true);

        test_team_2.setName("H");
        assertEquals(team.equals(test_team_2), false);

        test_team_2.addMember("1");
        assertEquals(team.equals(test_team_2), false);
    }

    @Test
    public void hashCode_returns_correct_hash() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}
