package persistencetier;

import businesstier.League;

import java.util.ArrayList;
import java.util.List;

public class LeagueService {
    private final List<League> leagueList= new ArrayList<>();

    public  String addLeague(League league)
    {
        leagueList.add(league);
        return "Success!";
    }
    public List<League> getLeaguesDetails(){
        return leagueList;
    }
}
